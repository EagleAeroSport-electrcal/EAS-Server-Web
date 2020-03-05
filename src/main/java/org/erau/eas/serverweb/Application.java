package org.erau.eas.serverweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ferrinkatz on 9/17/17.
 */

@SpringBootApplication
@EntityScan(basePackages = {"org.erau.eas.serverweb"})
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}