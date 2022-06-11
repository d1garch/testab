package ru.pashintsev.TestAB;

import org.springframework.stereotype.Component;

@Component
public class Values {
    private Double oldValue;
    private Double newValue;

    public Double getOldValue() {
        return oldValue;
    }

    public void setOldValue(Double oldValue) {
        this.oldValue = oldValue;
    }

    public Double getNewValue() {
        return newValue;
    }

    public void setNewValue(Double newValue) {
        this.newValue = newValue;
    }
}
