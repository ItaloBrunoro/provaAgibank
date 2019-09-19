package com.teste.agibank.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    private Long quantity;
    private BigDecimal price;
}
