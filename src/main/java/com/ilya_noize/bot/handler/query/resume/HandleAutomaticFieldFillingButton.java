package com.ilya_noize.bot.handler.query.resume;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.AUTOMATIC_FIELD_FILLING;

@Slf4j
@Component
public class HandleAutomaticFieldFillingButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return AUTOMATIC_FIELD_FILLING.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        log.debug("Build message:{} to chat:{}", getOperationType(), chatId);
        return SendMessage.builder()
                .chatId(chatId)
                .text(AUTOMATIC_FIELD_FILLING.getDescription())
                .build();
    }
}
