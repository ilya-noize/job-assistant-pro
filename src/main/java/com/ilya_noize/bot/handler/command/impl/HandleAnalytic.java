package com.ilya_noize.bot.handler.command.impl;

import com.ilya_noize.bot.handler.HandleCommand;
import com.ilya_noize.bot.enums.Command;
import com.ilya_noize.bot.enums.KeyboardButtons;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Component
public class HandleAnalytic implements HandleCommand {

    @Override
    public String getOperationType() {
        return Command.ANALYTICAL_MODULE.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        SendMessage message = SendMessage.builder()
                .text(Command.ANALYTICAL_MODULE.getDescription())
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
