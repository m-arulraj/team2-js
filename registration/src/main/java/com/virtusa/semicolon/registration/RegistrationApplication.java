<<<<<<< HEAD
package com.virtusa.semicolon.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegistrationApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(RegistrationApplication.class, args);
    }
}
=======
package com.virtusa.semicolon.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RegistrationApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(RegistrationApplication.class, args);
    }
}
>>>>>>> 7c8fcfa84151358ae19f5ab3bd10fea252c18073
