package com.trueaccord.admin.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.domain.Payment;
import com.trueaccord.admin.domain.PaymentPlan;
import com.trueaccord.admin.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DataServiceImpl implements DataService
{
    private final RestTemplate restTemplate;

    @Autowired
    public DataServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public List<Debt> getDebts() {
        ResponseEntity<List<Debt>> debtResponse =
                restTemplate.exchange("https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/debts",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Debt>>() {
                        });
        List<Debt> debts = debtResponse.getBody();
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
        System.out.println("debts -> " + debtJson);
        return debts;
    }

    @Override
    public List<PaymentPlan> getPaymentPlans() {
        ResponseEntity<List<PaymentPlan>> planResponse =
                restTemplate.exchange("https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/payment_plans",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<PaymentPlan>>() {
                        });
        List<PaymentPlan> plans = planResponse.getBody();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try
        {
            json = mapper.writeValueAsString(plans);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        System.out.println("paymentPlans -> " + json);
        return plans;
    }

    @Override
    public List<Payment> getPayments() {
        ResponseEntity<List<Payment>> paymentResponse =
                restTemplate.exchange("https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/payments",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Payment>>() {
                        });
        List<Payment> payments = paymentResponse.getBody();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try
        {
            json = mapper.writeValueAsString(payments);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        System.out.println("payments -> " + json);
        return payments;
    }
}
