package com.ilya_noize.bot.handler.query.tools;

import com.ilya_noize.bot.handler.HandleCallbackQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.ilya_noize.bot.enums.KeyboardButtons.LAUNCH;

@Slf4j
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

        Long chatId = callbackQuery.getMessage().getChatId();
        log.debug("Build message:{} to chat:{}", getOperationType(), chatId);
        return SendMessage.builder()
                .chatId(chatId)
                .text(message.append(" host").toString())
                .build();
    }
}
