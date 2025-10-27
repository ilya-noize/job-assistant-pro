package com.ilya_noize.bot.component.handler.query.tools;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.ilya_noize.bot.enums.KeyboardButtons.LAUNCH;

@Component
public class HandleLaunchButton implements HandleCallbackQuery {

    @Override
    public String getOperationType() {

        return LAUNCH.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {

        StringBuilder message = new StringBuilder("Application was launched on ");
        try {
            message.append(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            message.append("unknown");
        }

        return SendMessage.builder()
                .chatId(callbackQuery.getFrom().getId())
                .text(message.append(" host").toString())
                .build();
    }
}
