package com.ilya_noize.bot.configuration;

import com.ilya_noize.bot.clients.token.AuthenticationApplicationClient;
import com.ilya_noize.bot.clients.token.AuthenticationUserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientsConfiguration {

    @Bean
    AuthenticationUserClient authenticationUserClient(@Value("${aggregator.hh.uri.host}") String authUrl) {
        RestClient restClient = RestClient.builder().baseUrl(authUrl).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(AuthenticationUserClient.class);
    }

    @Bean
    AuthenticationApplicationClient authenticationApplicationClient(@Value("${aggregator.hh.uri.api}") String authUrl) {
        RestClient restClient = RestClient.builder().baseUrl(authUrl).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(AuthenticationApplicationClient.class);
    }
}
