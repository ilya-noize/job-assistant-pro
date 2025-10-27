package com.ilya_noize.bot.component.handler.query.start;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.INTERVIEW_CALENDAR;

@Component
public class HandleCalendarButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return INTERVIEW_CALENDAR.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(INTERVIEW_CALENDAR.getDescription())
                .build();
    }
}
