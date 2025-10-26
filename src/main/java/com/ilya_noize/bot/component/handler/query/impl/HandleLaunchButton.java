package com.ilya_noize.bot.component.handler.query.impl;

import com.ilya_noize.bot.enums.KeyboardButtons;
import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class HandleLaunchButton implements HandleCallbackQuery {
    private static final Logger log = LoggerFactory.getLogger(HandleLaunchButton.class);

    @Override
    public String getOperationType() {

        return KeyboardButtons.LAUNCH.getText();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {

        StringBuilder message = new StringBuilder("Application was launched on ");
        try {
            message.append(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            message.append("unknown");
        }
        log.debug("Processing complete.");

        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(message.append(" host").toString())
                .build();
    }
}
