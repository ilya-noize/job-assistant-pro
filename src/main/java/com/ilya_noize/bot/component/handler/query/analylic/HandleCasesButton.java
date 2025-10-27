package com.ilya_noize.bot.component.handler.query.analylic;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.CASES;

@Component
public class HandleCasesButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return CASES.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(CASES.getDescription())
                .build();
    }
}
