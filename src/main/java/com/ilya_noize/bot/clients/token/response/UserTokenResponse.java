package com.ilya_noize.bot.clients.token.response;

public record UserTokenResponse(
        String accessToken,
        Long expiresIn,
        String refreshToken,
        String tokenType) {

    public boolean isValidTokenType() {
        return tokenType.equals("bearer");
    }
}
