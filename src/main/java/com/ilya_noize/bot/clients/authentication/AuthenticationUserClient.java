package com.ilya_noize.bot.clients.authentication;

import com.ilya_noize.bot.clients.authentication.response.UserTokenResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@HttpExchange(
        url = "/oauth/token",
        accept = APPLICATION_JSON_VALUE,
        contentType = APPLICATION_FORM_URLENCODED_VALUE)
public interface AuthenticationUserClient {

    @PostExchange
    UserTokenResponse getUserAccessToken(
            @RequestParam(name = "grand_type") String grandType,
            @RequestParam(name = "client_id") String clientId,
            @RequestParam(name = "client_secret") String clientSecret,
            @RequestParam String code,
            @RequestParam String redirect);

    @PostExchange
    UserTokenResponse updateUserToken(
            @RequestParam(name = "grand_type") String grandType,
            @RequestParam(name = "refresh_token") String refreshToken);
}
