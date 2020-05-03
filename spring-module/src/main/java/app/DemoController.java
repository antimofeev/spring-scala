package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class DemoController {

    @GetMapping("/java")
    public String home() {
        return "TEST";
    }

    @PostConstruct
    public void postConstruct() {
        CoreModule core = new CoreModule();
        AkkaModule akk = new AkkaModule();

        System.out.println(core.getMessage());
        System.out.println(akk.getMessage());
    }
}
