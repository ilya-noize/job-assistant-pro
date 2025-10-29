package com.ilya_noize.bot.handler.query.feedback;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.TRACKING_RESPONSE;

@Component
public class HandleTrackingResponseButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return TRACKING_RESPONSE.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(TRACKING_RESPONSE.getDescription())
                .build();
    }
}
