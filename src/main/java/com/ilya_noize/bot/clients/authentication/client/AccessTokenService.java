package com.ilya_noize.bot.clients.authentication.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class AccessTokenService {
    private final RestClient restClient;
    private final String clientId;
    private final String clientSecret;
    private final String uri;
    private final String redirect;

    public AccessTokenService(RestTemplate restTemplate,
                              @Value("${aggregator.hh.clientId}") String clientId,
                              @Value("${aggregator.hh.clientSecret}") String clientSecret,
                              @Value("${aggregator.uri.host}") String uri,
                              @Value("${aggregator.uri.redirect}") String redirect) {
        this.restClient = RestClient.create(restTemplate);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.uri = uri + "/oauth/token";
        this.redirect = redirect;
    }

    /**
     * Получение access-токена
     *
     * @return
     */
    public AuthResponse getUserToken() {
        Map<String, String> formData = Map.of(
                "grant_type", "authorization_code",
                "client_id", clientId,
                "client_secret", clientSecret,
                "code", "authorization_code",
                "redirect_uri", redirect
        );
        return getAuthResponse(formData);
    }

    /**
     * Получения нового токена приложения
     *
     * @return
     */
    public AuthResponse getApplicationToken() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, String> formData = Map.of(
                "grant_type", "client_credentials",
                "client_id", clientId,
                "client_secret", clientSecret
        );

        return getAuthResponse(formData);
    }

    /**
     * Обновление пары access и refresh токенов
     *
     * @param refreshToken
     * @return
     */
    public AuthResponse updateRefreshAccessTokens(String refreshToken) {
        String uri = "https://hh.ru/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, String> formData = Map.of(
                "grant_type", "refresh_token",
                "refresh_token", refreshToken
        );

        return getAuthResponse(formData);
    }

    private AuthResponse getAuthResponse(Map<String, String> formData) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        formData.forEach(body::add);

        var entity = restClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(body)
                .retrieve()
                .toEntity(AuthResponse.class);
        if (entity.getStatusCode().is4xxClientError()) {
            return null;
        }
        return entity.getBody();
    }


    static class AuthResponse {
        private String accessToken;
        private Integer expiresIn;
        private String refreshToken;
        private String tokenType;

        public AuthResponse(String accessToken, Integer expiresIn, String refreshToken, String tokenType) {
            this.accessToken = accessToken;
            this.expiresIn = expiresIn;
            this.refreshToken = refreshToken;
            this.tokenType = tokenType;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }
    }
}
