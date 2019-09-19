package com.teste.agibank.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salesman{
    private String cpf;
    private String name;
    private BigDecimal salary;
}
