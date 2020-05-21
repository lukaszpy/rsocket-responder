package com.biteit.rsocket.responder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.rsocket.EnableRSocketSecurity;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.rsocket.core.PayloadSocketAcceptorInterceptor;

@Configuration
@EnableRSocketSecurity
public class RSocketConfiguration {

    @Bean
    PayloadSocketAcceptorInterceptor authorization(RSocketSecurity security){
        return security.authorizePayload(spec ->
                spec.route("com.biteit.rsocket.{worksId}.v0").hasRole("ADMIN")
                        .route("com.biteit.rsocket.v0").authenticated()
                    .anyExchange().permitAll())
                .simpleAuthentication(Customizer.withDefaults())
                .build();
    }

    @Bean
    MapReactiveUserDetailsService authentication(){
        var lpyrkosz = User.withDefaultPasswordEncoder().username("lpyrkosz").password("pw").roles("ADMIN", "USER").build();

        return new MapReactiveUserDetailsService(lpyrkosz);
    }
}
