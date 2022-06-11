package ru.pashintsev.TestAB.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pashintsev.TestAB.Values;
import ru.pashintsev.TestAB.model.Exchange;
import ru.pashintsev.TestAB.service.FeignService;

import java.util.HashMap;

@RestController
@RequestMapping("/testab")
public class TestABController {

    @Autowired
    private FeignService feignService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private Exchange exchange;
    @Autowired
    private Values values;

    @GetMapping("/old-value")
    public String getOldValue() {
        String jsonString = feignService.getHistoricalValue();
        try{
            exchange = mapper.readValue(jsonString, Exchange.class);
        }
        catch (JSONException e) {
            return "Something wrong with JSON answer from server";
        }
        catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Double oldValue = exchange.getRatesValue("RUB");
        values.setOldValue(oldValue);

        return oldValue.toString();
    }

    @GetMapping("/latest-value")
    public String getLatestValue() {
        String jsonString = feignService.getLatestValue();
        try{
            exchange = mapper.readValue(jsonString, Exchange.class);
        }
        catch (JSONException e) {
            return "Something wrong with JSON answer from server";
        }
        catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Double latestValue = exchange.getRatesValue("RUB");
        values.setNewValue(latestValue);

        if(values.getNewValue()> values.getOldValue()) {
            return "I'm RICH!!!";
        }
        else return "I'm POOR!!!(((";
    }

}
