package com.teste.agibank.converters;

import com.teste.agibank.domain.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter implements Converter<String[], Client> {

    private static final int CNPJ = 1;
    private static final int NAME = 2;
    private static final int BUSINESS_AREA = 3;

    @Override
    public Client convert(final String[] source) {
        final String cnpj = source[CNPJ];
        final String name = source[NAME];
        final String businessArea = source[BUSINESS_AREA];

        return new Client(cnpj, name, businessArea);
    }
}
