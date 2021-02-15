package com.trueaccord.admin.service.impl;

import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.domain.Payment;
import com.trueaccord.admin.domain.PaymentPlan;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DebtServiceTest
{
    @MockBean
    DataServiceImpl dataService;

    @Autowired
    DebtServiceImpl debtService;

    @Test
    public void testGetDebts() {
        List<Debt> debts = new ArrayList();
        Debt d = new Debt();
        d.setId(1);
        d.setAmount(new BigDecimal(500.00));
        debts.add(d);
        Mockito.when(dataService.getDebts()).thenReturn(debts);

        List<Payment> payments = new ArrayList();
        Payment p = new Payment();
        p.setPayment_plan_id(1);
        p.setAmount(new BigDecimal(100.00));
        p.setDate(LocalDate.now());
        payments.add(p);
        Mockito.when(dataService.getPayments()).thenReturn(payments);

        List<PaymentPlan> plans = new ArrayList();
        PaymentPlan plan = new PaymentPlan();
        plan.setId(1);
        plan.setDebt_id(1);
        plan.setAmount_to_pay(new BigDecimal(200.00));
        plan.setStart_date(LocalDate.now());
        plan.setInstallment_amount(new BigDecimal(100.00));
        plan.setInstallment_frequency("WEEKLY");
        plans.add(plan);
        Mockito.when(dataService.getPaymentPlans()).thenReturn(plans);

        List<Debt> response = debtService.calculateDetails();

        Assert.assertNotNull(response);
        Assert.assertEquals(response.size(), 1);
        Assert.assertEquals(response.get(0).isIs_in_payment_plan(), true);
    }
}
