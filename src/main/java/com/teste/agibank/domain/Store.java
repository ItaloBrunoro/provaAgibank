package com.teste.agibank.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Builder.Default
    private List<Client> client = new ArrayList<>();
    @Builder.Default
    private List<Salesman> salesmen = new ArrayList<>();
    @Builder.Default
    private List<Sale> sale = new ArrayList<>();
}
