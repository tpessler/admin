package com.trueaccord.admin.service;

import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.domain.Payment;
import com.trueaccord.admin.domain.PaymentPlan;

import java.util.List;

public interface DataService
{
    public List<Debt> getDebts();

    public List<PaymentPlan> getPaymentPlans();

    public List<Payment> getPayments();
}
