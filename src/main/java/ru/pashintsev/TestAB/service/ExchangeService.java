package ru.pashintsev.TestAB.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pashintsev.TestAB.client.FeignClient;
import ru.pashintsev.TestAB.model.Exchange;

@Service
public class ExchangeService {
    @Autowired
    private FeignClient feignClient;
    private ObjectMapper objectMapper;
    private Exchange exchange;

    public String getValue() {
        Double oldValue, latestValue;

        String jsonStr = feignClient.getHistoricalValue();

        try{
            exchange = objectMapper.readValue(jsonStr, Exchange.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        oldValue = exchange.getRatesValue("RUB");

        jsonStr = feignClient.getLatestValue();

        try {
            exchange = objectMapper.readValue(jsonStr, Exchange.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        latestValue = exchange.getRatesValue("RUB");

        if(oldValue<latestValue) {
            return "https://media1.giphy.com/media/LdOyjZ7io5Msw/200.gif?cid=84e415f1z9143hx51pd68am6cwk0ypr6pyr1vzwa8s9k6i8x&rid=200.gif&ct=g";
        }

        return "https://media3.giphy.com/media/ZGH8VtTZMmnwzsYYMf/200.gif?cid=84e415f19xq7zr50v79or341s17z2n8fxbvxoqh93se9kxek&rid=200.gif&ct=g";
    }
}
