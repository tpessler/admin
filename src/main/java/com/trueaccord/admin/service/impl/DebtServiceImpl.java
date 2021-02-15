package com.trueaccord.admin.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.domain.Payment;
import com.trueaccord.admin.domain.PaymentPlan;
import com.trueaccord.admin.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DebtServiceImpl implements DebtService
{
    private DataServiceImpl dataService;

    @Autowired
    public DebtServiceImpl(DataServiceImpl dataService)
    {
        this.dataService = dataService;
    }

    @PostConstruct
    @Override
    public List<Debt> calculateDetails() {

        //Retrieve the data
        //To optimize I would multi thread this, making all the calls simultaneously.
        List<Debt> debts = dataService.getDebts();
        List<PaymentPlan> plans = dataService.getPaymentPlans();
        List<Payment> payments =  dataService.getPayments();

        //calculate the results
        //Loop thru debts and add fields
        for (Debt debt : debts) {
            //Get the plan record
            try
            {
                PaymentPlan plan = plans.stream().filter(p -> p.getDebt_id() == debt.getId())
                        .findAny().get();
                //Plan found, now set additional details.
                debt.setIs_in_payment_plan(true);

                //get the matching payments made for this plan
                List<Payment> planPayments = payments.stream()
                        .filter(p -> p.getPayment_plan_id() == plan.getId())
                        .collect(Collectors.toList());

                BigDecimal totalPayments = BigDecimal.ZERO;
                LocalDate lastPaymentDate = plan.getStart_date();
                for (Payment payment : planPayments)
                {
                    totalPayments = totalPayments.add(payment.getAmount());
                    lastPaymentDate =
                            (lastPaymentDate == null || lastPaymentDate.isBefore(payment.getDate()))
                                    ? payment.getDate() : lastPaymentDate;
                }

                //Set the remaining balance - Amount_to_pay minus total_of_all_ayments
                debt.setRemaining_amount(plan.getAmount_to_pay().subtract(totalPayments));

                //Add the frequency in days to the last payment date to get the next payment date.
                int frequencyDays = (plan.getInstallment_frequency().equalsIgnoreCase("WEEKLY"))
                        ? 7 : 14;
                debt.setNext_payment_due_date(lastPaymentDate.plusDays(frequencyDays));
            } catch (NoSuchElementException e) {
            }
        }

        //Log the response in json format per the requirements
        ObjectMapper mapper = new ObjectMapper();
        String debtJson = null;
        try
        {
            debtJson = mapper.writeValueAsString(debts);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        System.out.println("Response -> " + debtJson);

        return debts;
    }
}
