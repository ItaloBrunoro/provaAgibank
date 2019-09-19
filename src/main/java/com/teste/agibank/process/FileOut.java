package com.teste.agibank.process;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileOut {

    private Integer quantityClient;
    private Integer quantitySalesman;
    private Long idBiggerSale;
    private String worstSalesman;

    @Override
    public String toString() {
        return "Quantidade de clientes : " + quantityClient + "\n" +
               "Quantidade de vendedores : " + quantitySalesman + "\n" +
               "ID da venda mais cara : " + idBiggerSale + "\n" +
               "O pior vendedor : " + worstSalesman;
    }
}
