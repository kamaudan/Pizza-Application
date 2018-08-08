package Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class SecurityConfig {

    @Bean
    public MapReactiveUserDetailsService userDetailsService () {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        return  new MapReactiveUserDetailsService(user);


    }

    @Bean
    public SecurityWebFilterChain  springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                       .anyExchange().authenticated()
                       .and()
                .httpBasic().and()
                .formLogin();
        return http.build();


    }

}
