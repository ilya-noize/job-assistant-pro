package com.ilya_noize.bot.clients.authentication.response;

public record ApplicationTokenResponse(
        String accessToken,
        String tokenType) {

    public boolean isValidTokenType() {
        return tokenType.equals("bearer");
    }
}
