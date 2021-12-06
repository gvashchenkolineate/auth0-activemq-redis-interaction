package com.lineate.internal.idp.interaction.service1;

import com.lineate.internal.idp.interaction.service1.config.MessagingConfig;
import com.lineate.internal.idp.interaction.service1.config.StorageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        StorageConfig.class,
        MessagingConfig.class
})
@WebAppConfiguration
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}