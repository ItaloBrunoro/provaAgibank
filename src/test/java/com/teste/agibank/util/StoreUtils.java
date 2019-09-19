package com.teste.agibank.util;

import com.teste.agibank.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Arrays;
import java.util.List;

public class StoreUtils {

    public static Store getStore() {
        return Store.builder()
            .client(getClients())
            .salesmen(getSalesmans())
            .sale(getSales()).build();
    }

    public static List<Client> getClients() {
        return Arrays.asList(
            new Client("2345675434544345", "Jose da Silva", "Rural"),
            new Client("2345675433444345", "Eduardo Pereira", "Rural"));
    }

    public static List<Salesman> getSalesmans() {
        return Arrays.asList(
            new Salesman("1234567891234", "Pedro", BigDecimal.valueOf(50000)),
            new Salesman("3245678865434", "Paulo", BigDecimal.valueOf(40000.99)));
    }

    public static List<Sale> getSales() {
        return Arrays.asList(
            Sale.builder()
                .id(10L)
                .items(getItemsSale1())
                .salesmanName("Pedro")
                .total(BigDecimal.ZERO)
            .build(),
            Sale.builder()
                .id(8L)
                .items(getItemsSale2())
                .salesmanName("Paulo")
                .total(BigDecimal.ZERO)
            .build());
    }

    private static List<Item> getItemsSale1() {
        return Arrays.asList(
            new Item(1L, 10L, BigDecimal.valueOf(100)),
            new Item(2L, 30L, BigDecimal.valueOf(2.5).setScale(2, RoundingMode.HALF_UP)),
            new Item(3L, 40L, BigDecimal.valueOf(3.1).setScale(2, RoundingMode.HALF_UP)));
    }

    private static List<Item> getItemsSale2() {
        return Arrays.asList(
            new Item(1L, 34L, BigDecimal.valueOf(10)),
            new Item(2L, 33L, BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP)),
            new Item(3L, 40L, BigDecimal.valueOf(0.10).setScale(2, RoundingMode.HALF_UP)));
    }
}
