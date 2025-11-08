package com.ilya_noize.bot.handler.query.start;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import com.ilya_noize.bot.handler.command.impl.HandleInterviewCalendar;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.INTERVIEW_CALENDAR;

@Component
public class HandleInterviewCalendarButton implements HandleCallbackQuery {
    private final HandleInterviewCalendar handleInterviewCalendar;

    public HandleInterviewCalendarButton(HandleInterviewCalendar handleInterviewCalendar) {
        this.handleInterviewCalendar = handleInterviewCalendar;
    }

    @Override
    public String getOperationType() {

        return INTERVIEW_CALENDAR.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return handleInterviewCalendar.processing(callbackQuery.getMessage().getChatId());
    }
}
