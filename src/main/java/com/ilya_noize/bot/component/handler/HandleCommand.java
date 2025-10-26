package com.ilya_noize.bot.component.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface HandleCommand {
    String getOperationType();

    SendMessage processing(Long chatId);
}
