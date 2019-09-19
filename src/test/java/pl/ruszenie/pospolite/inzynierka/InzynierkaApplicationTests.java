package pl.ruszenie.pospolite.inzynierka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InzynierkaApplicationTests {

    @Test
    public void contextLoads() {
        ApplicationContextAware applicationContextAware = new ApplicationContextAware() {
            @Override
            public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

                System.out.println("####!!!! " + applicationContext.getApplicationName());
            }
        };
    }

}

