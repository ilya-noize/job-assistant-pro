package com.ilya_noize.bot.handler.command.impl;

import com.ilya_noize.bot.handler.HandleCommand;
import com.ilya_noize.bot.enums.Command;
import com.ilya_noize.bot.enums.KeyboardButtons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Slf4j
@Component
public class HandleFeedbackBase implements HandleCommand {


    public String getOperationType() {
        return Command.FEEDBACK_BASE.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        log.debug("Build message:{} to chat:{}", getOperationType(), chatId);
        SendMessage message = SendMessage.builder()
                .text(Command.FEEDBACK_BASE.getDescription())
                .chatId(chatId)
                .build();

        message.setReplyMarkup(
                getInlineKeyboardMarkup(
                        Arrays.stream(KeyboardButtons.values())
                                .filter(button -> button
                                        .getLinkingMenu().equals(getOperationType()))
                                .collect(toMap(
                                        KeyboardButtons::getCallbackData,
                                        KeyboardButtons::getDescription))));
        return message;
    }

    private InlineKeyboardMarkup getInlineKeyboardMarkup(Map<String, String> buttons) {

        return new InlineKeyboardMarkup(
                buttons.entrySet()
                        .stream()
                        .map(e -> new InlineKeyboardRow(
                                InlineKeyboardButton.builder()
                                        .callbackData(e.getKey())
                                        .text(e.getValue())
                                        .build()))
                        .toList());
    }
}
