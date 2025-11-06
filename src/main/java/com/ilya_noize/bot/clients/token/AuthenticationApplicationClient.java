package com.ilya_noize.bot.clients.token;

import com.ilya_noize.bot.clients.token.response.ApplicationTokenResponse;
import com.ilya_noize.bot.clients.token.response.CurrentUserResponse;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@HttpExchange(
        accept = APPLICATION_JSON_VALUE,
        contentType = APPLICATION_FORM_URLENCODED_VALUE)
public interface AuthenticationApplicationClient {

    @PostExchange(url = "/token")
    ApplicationTokenResponse getApplicationAccessToken(
            @RequestParam(name = "grand_type") String grandType,
            @RequestParam(name = "client_id") String clientId,
            @RequestParam(name = "client_secret") String clientSecret);

    @PostExchange(url = "/token")
    ApplicationTokenResponse updateApplicationToken(
            @RequestParam(name = "grand_type") String grandType,
            @RequestParam(name = "refresh_token") String refreshToken);

    @GetExchange(url = "/me")
    CurrentUserResponse getCurrentUser(
            @RequestHeader(name = "HH-User-Agent",
                    value = "MyApp/1.0 (my-app-feedback@example.com)")
            @RequestParam String host,
            @RequestParam String locale);
}
