package com.ilya_noize.bot.handler.query.analylic;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.STATISTICS_RESPONSES;

@Slf4j
@Component
public class HandleStatisticsResponsesButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return STATISTICS_RESPONSES.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        log.debug("Build message:{} to chat:{}", getOperationType(), chatId);
        return SendMessage.builder()
                .chatId(chatId)
                .text(STATISTICS_RESPONSES.getDescription())
                .build();
    }
}
