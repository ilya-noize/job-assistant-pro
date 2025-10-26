package com.ilya_noize.bot.component.handler.command;

import com.ilya_noize.bot.component.handler.HandleCommand;
import com.ilya_noize.bot.enums.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class HandleUnknown implements HandleCommand {

    public String getOperationType() {
        return Command.UNKNOWN.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        //log.debug("Processing complete.");
        return SendMessage.builder()
                .chatId(chatId)
                .text(Command.UNKNOWN.getDescription())
                .build();
    }
}
