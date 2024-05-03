package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;	

@Configuration
@PropertySource("classpath:credentials.properties")
public class CredentialPropertiesConfig {

}
