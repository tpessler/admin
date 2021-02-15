package com.trueaccord.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentPlan
{
    private int        id;
    private int        debt_id;
    private BigDecimal amount_to_pay;
    private String     installment_frequency;
    private BigDecimal installment_amount;
    private LocalDate  start_date;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getDebt_id()
    {
        return debt_id;
    }

    public void setDebt_id(int debt_id)
    {
        this.debt_id = debt_id;
    }

    public BigDecimal getAmount_to_pay()
    {
        return amount_to_pay;
    }

    public void setAmount_to_pay(BigDecimal amount_to_pay)
    {
        this.amount_to_pay = amount_to_pay;
    }

    public String getInstallment_frequency()
    {
        return installment_frequency;
    }

    public void setInstallment_frequency(String installment_frequency)
    {
        this.installment_frequency = installment_frequency;
    }

    public BigDecimal getInstallment_amount()
    {
        return installment_amount;
    }

    public void setInstallment_amount(BigDecimal installment_amount)
    {
        this.installment_amount = installment_amount;
    }

    public LocalDate getStart_date()
    {
        return start_date;
    }

    public void setStart_date(LocalDate start_date)
    {
        this.start_date = start_date;
    }
}
