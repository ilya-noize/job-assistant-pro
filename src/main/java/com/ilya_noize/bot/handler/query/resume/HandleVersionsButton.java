package com.ilya_noize.bot.handler.query.resume;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.VERSIONS;

@Component
public class HandleVersionsButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return VERSIONS.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(VERSIONS.getDescription())
                .build();
    }
}
