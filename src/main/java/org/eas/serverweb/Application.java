package org.eas.serverweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ferrinkatz on 9/17/17.
 */

@SpringBootApplication
@EntityScan(basePackages = {"org.eas.serverweb"})
@EnableJpaRepositories(basePackages =  {"org.eas.serverweb"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
