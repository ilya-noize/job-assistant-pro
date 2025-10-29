package com.ilya_noize.bot.handler.query.analylic;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.STATISTICS_RESPONSES;

@Component
public class HandleStatisticsResponsesButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return STATISTICS_RESPONSES.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(STATISTICS_RESPONSES.getDescription())
                .build();
    }
}
