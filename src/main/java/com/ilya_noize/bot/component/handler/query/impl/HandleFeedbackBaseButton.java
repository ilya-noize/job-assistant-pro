package com.ilya_noize.bot.component.handler.query.impl;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import com.ilya_noize.bot.enums.KeyboardButtons;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class HandleFeedbackBaseButton implements HandleCallbackQuery {


    private static final KeyboardButtons BUTTON = KeyboardButtons.FEEDBACK_BASE;

    @Override
    public String getOperationType() {

        return BUTTON.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        //log.debug("Processing complete.");

        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(BUTTON.getDescription())
                .build();
    }
}
