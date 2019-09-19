package com.teste.agibank.service;

import com.teste.agibank.util.StoreUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessServiceTests {

    @Autowired
    private BusinessService businessService;

    @Test
    public void testNumberOfClients() {
        final Integer numberOfClients = businessService.getNumberOfClients(StoreUtils.getClients());
        assertEquals(new Integer(2), numberOfClients);
    }

    @Test
    public void testNumberOfSalesmen() {
        final Integer numberOfSalesmen = businessService.getNumberOfSalesmen(StoreUtils.getSalesmans());
        assertEquals(new Integer(2), numberOfSalesmen);
    }

    @Test
    public void testIdOfBiggerSale() {
        final Long idOfBiggerSale = businessService.getIdOfBiggerSale(StoreUtils.getSales());
        assertEquals(new Long(10), idOfBiggerSale);
    }

    @Test
    public void testWorstSalesman() {
        final String worstSalesman = businessService.getWorstSalesman(StoreUtils.getSales());
        assertEquals("Paulo", worstSalesman);
    }
}
