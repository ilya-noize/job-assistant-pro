package com.ilya_noize.bot.component.handler.command;

import com.ilya_noize.bot.component.handler.HandleCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.ilya_noize.bot.enums.Command.UNKNOWN;

@Component
public class HandleUnknown implements HandleCommand {

    public String getOperationType() {
        return UNKNOWN.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(UNKNOWN.getDescription())
                .build();
    }
}
