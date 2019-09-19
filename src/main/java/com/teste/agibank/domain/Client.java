package com.teste.agibank.domain;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client{
    private String cnpj;
    private String name;
    private String businessArea;
}
