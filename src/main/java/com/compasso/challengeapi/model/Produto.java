package com.compasso.challengeapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Produto {

    @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
}
