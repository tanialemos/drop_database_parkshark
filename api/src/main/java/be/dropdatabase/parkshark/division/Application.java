package be.dropdatabase.parkshark.division;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"be.dropdatabase.parkshark"})
@EntityScan({"be.dropdatabase.parkshark"})
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}


