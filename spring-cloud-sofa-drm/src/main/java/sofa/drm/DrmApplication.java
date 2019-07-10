package sofa.drm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrmApplication.class, args);
    }


}
