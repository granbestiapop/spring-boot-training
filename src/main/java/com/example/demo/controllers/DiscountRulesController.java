package com.example.demo.controllers;

import com.example.demo.dto.DiscountRules;
import com.example.demo.services.DiscountRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountRulesController {

    @Autowired
    private DiscountRulesService discountRulesService;

    @GetMapping(path="/sites/{id}/discount_rules")
    public @ResponseBody DiscountRules getDiscountRules(@PathVariable("id") final String siteId){
        return discountRulesService.getDiscountRules(siteId);
    }
}
