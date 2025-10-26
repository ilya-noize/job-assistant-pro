package com.ilya_noize.bot.component;

import com.ilya_noize.bot.component.handler.MessageHandlerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;

@Component
public class TelegramBot implements SpringLongPollingBot {
    private final String token;
    private final MessageHandlerListener messageHandlerListener;

    @Autowired
    public TelegramBot(@Value("${telegram.bot.token}") String token,
                       MessageHandlerListener messageHandlerListener) {
        this.token = token;
        this.messageHandlerListener = messageHandlerListener;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return messageHandlerListener;
    }
}
