package ru.pashintsev.TestAB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pashintsev.TestAB.service.ExchangeService;

@RestController
@RequestMapping("/testab")
public class TestABController {

    private ExchangeService exchangeService;

    @GetMapping("/get-value")
    public String getOldValue() {
        return exchangeService.getValue();
    }

}
