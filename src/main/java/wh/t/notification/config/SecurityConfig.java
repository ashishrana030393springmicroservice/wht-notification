package wh.t.notification.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AppConfig appConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(c->c.jwt(j->j.jwkSetUri(appConfig.getMain().getUrl() + Constant.JWK_SET_URL)));
        http.authorizeHttpRequests(c-> c.anyRequest().authenticated());
        return http.build();
    }
}
