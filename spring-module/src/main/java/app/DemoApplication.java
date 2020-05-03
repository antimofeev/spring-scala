package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        CoreModule core = new CoreModule();
        AkkaModule akk = new AkkaModule();

        System.out.println(core.getMessage());
        System.out.println(akk.getMessage());
    }
}
