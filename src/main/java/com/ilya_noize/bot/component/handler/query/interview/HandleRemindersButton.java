package com.ilya_noize.bot.component.handler.query.interview;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.REMINDERS;

@Component
public class HandleRemindersButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return REMINDERS.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(REMINDERS.getDescription())
                .build();
    }
}
