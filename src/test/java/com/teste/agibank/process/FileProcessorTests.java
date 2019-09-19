package com.teste.agibank.process;

import com.teste.agibank.util.StoreUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileProcessorTests {

    @Autowired
    FileProcessor fileProcessor;

    @Test
    public void testNumberOfClients() {
        final String process = fileProcessor.process(StoreUtils.getStore());
        assertEquals(this.getFile(), process);
    }

    private String getFile() {
        return "Quantidade de clientes : 2\n" +
                "Quantidade de vendedores : 2\n" +
                "ID da venda mais cara : 10\n" +
                "O pior vendedor : Paulo";
    }
}
