package ru.pashintsev.TestAB.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
@Data
public class Exchange {
    private String disclaimer;
    private String license;
    private String base;
    private HashMap<String, Double> rates;

    public Double getRates(String key) {
        return rates.get(key);
    }
}
