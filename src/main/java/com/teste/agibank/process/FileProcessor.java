package com.teste.agibank.process;

import com.teste.agibank.domain.Store;
import com.teste.agibank.service.BusinessService;
import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor {

    private final BusinessService businessService;

    @Autowired
    public FileProcessor(final BusinessService businessService){
        this.businessService = businessService;
    }

    @Consume(uri = "direct:fileProcessor")
    public String process(@Body final Store store) {
        final FileOut fileOut = FileOut.builder()
                .quantityClient(businessService.getNumberOfClients(store.getClient()))
                .quantitySalesman(businessService.getNumberOfSalesmen(store.getSalesmen()))
                .idBiggerSale(businessService.getIdOfBiggerSale(store.getSale()))
                .worstSalesman(businessService.getWorstSalesman(store.getSale()))
            .build();
        return fileOut.toString();
    }

}
