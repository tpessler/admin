package com.trueaccord.admin.service.impl;

import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.domain.Payment;
import com.trueaccord.admin.domain.PaymentPlan;
import com.trueaccord.admin.service.DataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest
{
    @Autowired
    DataService dataService;

    @Test
    public void testGetDebts() {
        List<Debt> debts = dataService.getDebts();
        Assert.assertNotNull(debts);
    }

    @Test
    public void testGetPaymentPlans() {
        List<PaymentPlan> plans = dataService.getPaymentPlans();
        Assert.assertNotNull(plans);
    }

    @Test
    public void testGetPayments() {
        List<Payment> payments = dataService.getPayments();
        Assert.assertNotNull(payments);
    }
}
