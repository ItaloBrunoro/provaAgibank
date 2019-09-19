package com.teste.agibank.process;


import com.teste.agibank.domain.*;
import com.teste.agibank.util.StoreUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileConverterTests {

    @Autowired
    private FileConverter fileConverter;

    @Test
    public void testConverterClient() {
        final Store store = fileConverter.process(this.getFile());
        assertEquals(StoreUtils.getClients(), store.getClient());
    }

    @Test
    public void testConverterSalesman() {
        final Store store = fileConverter.process(this.getFile());
        assertEquals(StoreUtils.getSalesmans(), store.getSalesmen());
    }

    @Test
    public void testConverterSale() {
        final Store store = fileConverter.process(this.getFile());
        assertEquals(StoreUtils.getSales(), store.getSale());
    }

    private String getFile() {
        return "001ç1234567891234çPedroç50000\n" +
                "001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo\n";
    }
}
