package com.example.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DiscountRules {

    private Double minOriginPrice;
    private Double maxOriginPrice;
    private Double minDiscount;
    private Double maxDiscount;

    public Double getMinOriginPrice() {
        return minOriginPrice;
    }

    public DiscountRules setMinOriginPrice(Double minOriginPrice) {
        this.minOriginPrice = minOriginPrice;
        return this;
    }

    public Double getMaxOriginPrice() {
        return maxOriginPrice;
    }

    public DiscountRules setMaxOriginPrice(Double maxOriginPrice) {
        this.maxOriginPrice = maxOriginPrice;
        return this;
    }

    public Double getMinDiscount() {
        return minDiscount;
    }

    public DiscountRules setMinDiscount(Double minDiscount) {
        this.minDiscount = minDiscount;
        return this;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public DiscountRules setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
        return this;
    }
}
