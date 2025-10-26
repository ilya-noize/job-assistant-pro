package com.ilya_noize.bot.component.handler.query.impl;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import com.ilya_noize.bot.enums.KeyboardButtons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class HandleMenuButton implements HandleCallbackQuery {
    private static final Logger log = LoggerFactory.getLogger(HandleMenuButton.class);

    @Override
    public String getOperationType() {

        return KeyboardButtons.MANAGE.getText();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        var chatId = callbackQuery.getFrom().getId();
        var text = getOperationType();
        log.debug("Processing complete.");
        return SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .build();
    }
}
