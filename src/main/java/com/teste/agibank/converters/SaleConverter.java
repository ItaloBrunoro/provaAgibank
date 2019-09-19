package com.teste.agibank.converters;

import com.teste.agibank.domain.Item;
import com.teste.agibank.domain.Sale;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaleConverter implements Converter<String[], Sale> {

    private static final String SPLIT = ",";
    private static final int ID = 1;
    private static final int ITEMS = 2;
    private static final int SALESMAN_NAME = 3;
    private static final int ITEM_ID = 0;
    private static final int ITEM_QUANTITY = 1;
    private static final int ITEM_PRICE = 2;

    @Override
    public Sale convert(final String[] source) {
        final Long id = Long.valueOf(source[ID]);
        final List<Item> items = convertItems(source[ITEMS]);
        final String salesmanName = source[SALESMAN_NAME];

        return new Sale(id, items, salesmanName, BigDecimal.ZERO);
    }

    private List<Item> convertItems(final String source) {
        final String[] itemRows = source.replaceAll("\\[|]", "").split(SPLIT);
        final List<Item> items = new ArrayList<>();

        for (final String row : itemRows) {
            final String[] itemFields = row.split("-");

            final Item item = Item.builder()
                    .id(Long.valueOf(itemFields[ITEM_ID]))
                    .quantity(Long.valueOf(itemFields[ITEM_QUANTITY]))
                    .price(new BigDecimal(itemFields[ITEM_PRICE]))
                .build();

            items.add(item);
        }

        return items;
    }
}
