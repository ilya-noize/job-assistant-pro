package com.ilya_noize.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public interface HandleCallbackQuery {
    String getOperationType();

    SendMessage processing(CallbackQuery callbackQuery);
}
