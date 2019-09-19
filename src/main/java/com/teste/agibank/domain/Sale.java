package com.teste.agibank.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale{
    private Long id;
    @Builder.Default
    private List<Item> items = new ArrayList<>();
    private String salesmanName;
    private BigDecimal total;
}
