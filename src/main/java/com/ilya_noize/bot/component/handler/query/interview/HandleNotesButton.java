package com.ilya_noize.bot.component.handler.query.interview;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.NOTES;

@Component
public class HandleNotesButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return NOTES.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(NOTES.getDescription())
                .build();
    }
}
