package be.dropdatabase.parkshark.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication( scanBasePackages = {"be.dropdatabase.parkshark.jar","be.dropdatabase.parkshark.api","be.dropdatabase.parkshark.service","be.dropdatabase.parkshark.domain","be.dropdatabase.parkshark.utilities"} )
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}


