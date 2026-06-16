package my.sg2048;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "my.sg2048")
public class Sg2048Application {

    public static void main(String[] args) {
        SpringApplication.run(Sg2048Application.class, args);
    }

}
