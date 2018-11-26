package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApiApplication.class)//该class是SpringBoot项目的Application
@ActiveProfiles("test")
@WebAppConfiguration
@TestPropertySource({//引用的配置文件
        "classpath:/application.yml"
})
public abstract class SpringBootTestAbstract {


}
