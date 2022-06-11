package ru.pashintsev.TestAB.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "client", url = "https://openexchangerates.org/api")
public interface FeignService {

    @GetMapping("/historical/2022-06-07.json?app_id=fcf13718dfde40aa89e938d61c78dec1")
    String getHistoricalValue();

    @GetMapping("/latest.json?app_id=fcf13718dfde40aa89e938d61c78dec1")
    String getLatestValue();
}
