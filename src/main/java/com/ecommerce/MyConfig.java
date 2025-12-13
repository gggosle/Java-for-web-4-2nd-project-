package com.ecommerce;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.ecommerce.*")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class MyConfig {
}
