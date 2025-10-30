package com.ilya_noize.bot.handler.command;

import com.ilya_noize.bot.handler.HandleCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.ilya_noize.bot.enums.Command.UNKNOWN;

@Slf4j
@Component
public class HandleUnknown implements HandleCommand {

    public String getOperationType() {
        return UNKNOWN.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        log.debug("Build message:{} to chat:{}", getOperationType(), chatId);
        return SendMessage.builder()
                .chatId(chatId)
                .text(UNKNOWN.getDescription())
                .build();
    }
}
