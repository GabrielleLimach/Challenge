package com.compasso.challengeapi.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Produtc {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
}
