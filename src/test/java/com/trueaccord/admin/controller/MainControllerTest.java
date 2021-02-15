package com.trueaccord.admin.controller;

import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.service.DebtService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@TestPropertySource(properties = {"spring.cloud.consul.config.enabled=false"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = MainController.class,
        excludeAutoConfiguration = SecurityAutoConfiguration.class)
@Profile("local")
@WebAppConfiguration
public class MainControllerTest
{
    @MockBean
    DebtService debtService;

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp()
    {
        this.mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void test_admin_ep() throws Exception
    {
        String uri = "/admin";
        List<Debt> debts = new ArrayList<Debt>();
        Debt d = new Debt();
        d.setId(1);
        d .setAmount(BigDecimal.ONE);
        debts.add(d);
        Mockito.when(debtService.calculateDetails())
                .thenReturn(debts);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mvc.perform(requestBuilder)
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertNotNull(content);
    }

}
