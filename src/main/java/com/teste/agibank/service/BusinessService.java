package com.teste.agibank.service;

import com.teste.agibank.domain.Client;
import com.teste.agibank.domain.Item;
import com.teste.agibank.domain.Sale;
import com.teste.agibank.domain.Salesman;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class BusinessService {

    public Integer getNumberOfClients(final List<Client> clients) {
        if (clients.isEmpty()) {
            return 0;
        }
        return clients.size();
    }

    public Integer getNumberOfSalesmen(final List<Salesman> salesmen) {
        if (salesmen.isEmpty()) {
            return 0;
        }
        return salesmen.size();
    }

    public Long getIdOfBiggerSale(final List<Sale> sales) {
        this.getTotalSale(sales);
        final Sale sale = sales.stream()
                .max(Comparator.comparing(Sale::getTotal))
                .orElse(null);
        return Objects.nonNull(sale) ? sale.getId() : null;

    }

    public String getWorstSalesman(final List<Sale> sales) {
        this.getTotalSale(sales);
        final Sale sale = sales.stream()
                .min(Comparator.comparing(Sale::getTotal))
                .orElse(null);
        return Objects.nonNull(sale) ? sale.getSalesmanName() : null;
    }

    private void getTotalSale(List<Sale> sales) {
        for (final Sale sale : sales){
            BigDecimal total = BigDecimal.ZERO;
            for (final Item item : sale.getItems()){
                 total = total.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
            sale.setTotal(total);
        }
    }
}
