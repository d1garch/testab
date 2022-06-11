package ru.pashintsev.TestAB.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
@Data
public class Exchange {
    private String disclaimer;
    private String license;
    private String base;
    private HashMap<String, Double> rates;

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public Double getRatesValue(String key) {
        return rates.get(key);
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }


}
