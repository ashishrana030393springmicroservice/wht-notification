package wh.t.notification.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private Main main;
    @Data
    public class Main {
        private String host;
        private String port;
        private String url;
    }
}
