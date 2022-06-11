package ru.pashintsev.TestAB.client;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.openfeign.FeignClient(value = "client", url = "https://openexchangerates.org/api")
public interface FeignClient {

    @GetMapping("/historical/2022-06-07.json?app_id=fcf13718dfde40aa89e938d61c78dec1")
    String getHistoricalValue();

    @GetMapping("/latest.json?app_id=fcf13718dfde40aa89e938d61c78dec1")
    String getLatestValue();
}
