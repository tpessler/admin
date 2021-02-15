package com.trueaccord.admin.controller;

import com.trueaccord.admin.domain.Debt;
import com.trueaccord.admin.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController
{
    @Autowired
    DebtService debtService;

    @ResponseBody
    @GetMapping(value = "admin", produces = "application/json")
    public ResponseEntity<List<Debt>> getData()
    {
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();

        List<Debt> response = debtService.calculateDetails();

        return new ResponseEntity<>(response, headers, status);
    }

}
