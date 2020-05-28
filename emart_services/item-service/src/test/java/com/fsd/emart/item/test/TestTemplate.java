package com.fsd.emart.item.test;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestTemplate {
    @Before
    public void init() {
        System.out.println("test begin-----------------");
    }
 
    @After
    public void after() {
        System.out.println("test end-----------------");
    }


}
