package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class DollarRateController {
    DollarParsing dollarParsing;

    public DollarRateController(DollarParsing dollarParsing) {
        this.dollarParsing = dollarParsing;

    }
    @GetMapping("/dollarRate")
    public String index(Model model) throws IOException {
        model.addAttribute("dollarExchangeRate", dollarParsing.dollarExchangeRate);
        return "index";
    }
}
