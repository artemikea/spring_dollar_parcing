package com.example.demo1.controllers;

import com.example.demo1.services.DollarParsing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DollarRateController {
    DollarParsing dollarParsing;

    public DollarRateController(DollarParsing dollarParsing) {
        this.dollarParsing = dollarParsing;
    }

    @GetMapping("/dollarRate")
    public String index(Model model) {
        model.addAttribute("dollarExchangeRate", dollarParsing.dollarExchangeRate);
        return "index";
    }
}
