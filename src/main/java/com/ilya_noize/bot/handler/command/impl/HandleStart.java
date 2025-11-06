package com.ilya_noize.bot.handler.command.impl;

import com.ilya_noize.bot.enums.Command;
import com.ilya_noize.bot.enums.KeyboardButtons;
import com.ilya_noize.bot.handler.HandleCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Slf4j
@Component
public class HandleStart implements HandleCommand {

    public String getOperationType() {
        return Command.START.getName();
    }

    @Override
    public SendMessage processing(Long chatId) {
        log.debug("Build message:{} to chat:{}", getOperationType(), chatId);
        String accessToken = getAccessToken();

        if (accessToken.isBlank()) {
            generateUrl();

            return SendMessage.builder()
                    .text("Авторизация на сайте агрегатора")
                    .chatId(chatId)
                    .build();
        }
        return getSendMessageWithButtons(chatId);
    }

    private static String generateUrl() {

        Map<String, String> params = Map.of(
                "grant_type", "authorization_code",
                "client_id", "ETVQdMs2n9VKw7SMXkh9nX5H",
                "client_secret", "95dNjB8FmtxQsmygm6dtEy53",
                "redirect_uri", "http%3A%2F%2Fwww.example.com%2Foauth",
                "code", "29CtxMcaA8pRFDYyC8e8Gkm4");

        return params.entrySet().stream()
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"))
                .replaceAll(".$", "");
    }

    private String getAccessToken() {

        return "";
    }

    private SendMessage getSendMessageWithButtons(Long chatId) {

        SendMessage message = SendMessage.builder()
                .text(Command.START.getDescription())
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
