package org.martinzhekov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by martinzhekov on 14.11.20
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.martinzhekov")
public class WebConfig {

}
