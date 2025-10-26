package com.ilya_noize.bot.component.handler.query.impl;

import com.ilya_noize.bot.enums.KeyboardButtons;
import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class HandleMyNameButton implements HandleCallbackQuery {
    private static final Logger log = LoggerFactory.getLogger(HandleMyNameButton.class);

    @Override
    public String getOperationType() {

        return KeyboardButtons.NAME.getText();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        var user = callbackQuery.getFrom();
        var text = ("Your name %s %s%nYour nickname: @%s")
                .formatted(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUserName());
        log.debug("Processing complete.");

        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(text)
                .build();
    }
}
