package com.example.demo.services;

import com.example.demo.cache.CacheConfiguration;
import com.example.demo.clients.DiscountRulesClient;
import com.example.demo.dto.DiscountRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class DiscountRulesService {

    @Autowired
    private DiscountRulesClient discountRulesClient;

    @Cacheable(CacheConfiguration.IN_MEMORY_DISCOUNT_CACHE)
    public DiscountRules getDiscountRules(@Nullable final String siteId){
        return discountRulesClient.getDiscountRules(siteId);
    }
}
