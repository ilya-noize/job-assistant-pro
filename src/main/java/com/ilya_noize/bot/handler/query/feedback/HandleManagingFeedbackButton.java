package com.ilya_noize.bot.handler.query.feedback;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.MANAGING_FEEDBACK;

@Component
public class HandleManagingFeedbackButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return MANAGING_FEEDBACK.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(MANAGING_FEEDBACK.getDescription())
                .build();
    }
}
