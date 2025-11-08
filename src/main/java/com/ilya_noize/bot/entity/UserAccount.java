package com.ilya_noize.bot.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserAccount {
    private String accessToken;
    private String refreshToken;
    private Long chatId;

    public UserAccount(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}
