package com.ilya_noize.bot.component.handler.query.start;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.ANALYTICAL_MODULE;

@Component
public class HandleAnalyticalModuleButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return ANALYTICAL_MODULE.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(ANALYTICAL_MODULE.getDescription())
                .build();
    }
}
