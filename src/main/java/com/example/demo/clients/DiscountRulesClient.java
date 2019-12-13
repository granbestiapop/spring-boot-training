package com.example.demo.clients;

import com.example.demo.dto.DiscountRules;
import com.example.demo.strings.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DiscountRulesClient {

    static private final String URL = "https://api.mercadolibre.com/sites/%s/discount_rules";
    static private final HttpEntity entity;

    static {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>(headers);
    }

    @Autowired
    private RestTemplate restTemplate;


    public DiscountRules getDiscountRules(@Nullable final String siteId){
        if(Utils.isNullOrEmpty(siteId)) {
            throw new RuntimeException("Is null or empty siteId");
        }

        final String url = String.format(URL, siteId);
        return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<DiscountRules>>(){})
                .getBody()
                .stream()
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
