package com.trueaccord.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Debt
{
    private int        id;
    private BigDecimal amount;
    private boolean    is_in_payment_plan;
    private BigDecimal remaining_amount;
    private LocalDate  next_payment_due_date;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public boolean isIs_in_payment_plan()
    {
        return is_in_payment_plan;
    }

    public void setIs_in_payment_plan(boolean is_in_payment_plan)
    {
        this.is_in_payment_plan = is_in_payment_plan;
    }

    public BigDecimal getRemaining_amount()
    {
        return remaining_amount;
    }

    public void setRemaining_amount(BigDecimal remaining_amount)
    {
        this.remaining_amount = remaining_amount;
    }

    public LocalDate getNext_payment_due_date()
    {
        return next_payment_due_date;
    }

    public void setNext_payment_due_date(LocalDate next_payment_due_date)
    {
        this.next_payment_due_date = next_payment_due_date;
    }
}
