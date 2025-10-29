package com.ilya_noize.bot.handler.query.interview;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.INTERVIEW_PLANNING;

@Component
public class HandleInterviewPlanningButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return INTERVIEW_PLANNING.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(INTERVIEW_PLANNING.getDescription())
                .build();
    }
}
