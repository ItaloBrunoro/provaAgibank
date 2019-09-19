package com.teste.agibank.converters;

import com.teste.agibank.domain.Salesman;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SalesmanConverter implements Converter<String[], Salesman> {

    private static final int CNPJ = 1;
    private static final int NAME = 2;
    private static final int SALARY = 3;

    @Override
    public Salesman convert(final String[] source) {
        final String cnpj = source[CNPJ];
        final String name = source[NAME];
        final BigDecimal salary = new BigDecimal(source[SALARY]);

        return new Salesman(cnpj, name, salary);
    }
}
