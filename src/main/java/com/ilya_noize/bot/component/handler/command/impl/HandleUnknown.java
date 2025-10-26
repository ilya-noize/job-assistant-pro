package com.ilya_noize.bot.component.handler.command.impl;

import com.ilya_noize.bot.enums.Command;
import com.ilya_noize.bot.component.handler.HandleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class HandleUnknown implements HandleCommand {
    private static final Logger log = LoggerFactory.getLogger(HandleUnknown.class);

    public String getOperationType() {
        return Command.UNKNOWN.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        log.debug("Processing complete.");
        return SendMessage.builder()
                .chatId(chatId)
                .text(Command.UNKNOWN.getDescription())
                .build();
    }
}
