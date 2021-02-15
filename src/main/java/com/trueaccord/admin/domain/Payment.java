package com.trueaccord.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment
{
    private int        payment_plan_id;
    private BigDecimal amount;
    private LocalDate  date;

    public int getPayment_plan_id()
    {
        return payment_plan_id;
    }

    public void setPayment_plan_id(int payment_plan_id)
    {
        this.payment_plan_id = payment_plan_id;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}
