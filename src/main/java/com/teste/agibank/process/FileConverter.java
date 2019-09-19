package com.teste.agibank.process;

import com.teste.agibank.converters.ClientConverter;
import com.teste.agibank.converters.SaleConverter;
import com.teste.agibank.converters.SalesmanConverter;
import com.teste.agibank.domain.Store;
import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileConverter {

    private final static String SPLIT = "ç";
    private final static String SALESMAN = "001";
    private final static String CLIENT = "002";
    private final static String SALE = "003";

    private final ClientConverter clientConverter;
    private final SaleConverter saleConverter;
    private final SalesmanConverter salesmanConverter;

    @Autowired
    public FileConverter(final ClientConverter clientConverter,
                         final SaleConverter saleConverter,
                         final SalesmanConverter salesmanConverter){
        this.clientConverter = clientConverter;
        this.saleConverter = saleConverter;
        this.salesmanConverter = salesmanConverter;
    }

    @Consume(uri = "direct:fileConverter")
    public Store process(@Body final String body) {
        final String[] rows = body.split("\n");
        final Store store = new Store();

        for (final String row : rows) {
            final String[] fields = row.split(SPLIT);
            switch (fields[0]) {
                case SALESMAN:
                    store.getSalesmen().add(salesmanConverter.convert(fields));
                    break;
                case CLIENT:
                    store.getClient().add(clientConverter.convert(fields));
                    break;
                case SALE:
                    store.getSale().add(saleConverter.convert(fields));
                    break;
            }
        }

        return store;
    }

}
