package be.dropdatabase.parkshark.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication( scanBasePackages = {"be.dropdatabase.parkshark"} )
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}


