package com.ilya_noize.bot.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.List;
import java.util.Map;


@Component
public class UpdateConsumer implements LongPollingUpdateConsumer {
    private static final String NO_SUCH_COMMAND = "No such command";
    private final TelegramClient telegramClient;

    public UpdateConsumer(@Value("${telegram.bot.token}") String token) {
        this.telegramClient = new OkHttpTelegramClient(token);
    }

    @Override
    public void consume(List<Update> updates) {
        for (Update update : updates) {
            if (update.hasMessage()) {
                String text = update.getMessage().getText();
                Long chatId = update.getMessage().getChatId();

                if (text.equals("/start")) {
                    sendMainMenu(chatId);
                } else {
                    send(chatId, NO_SUCH_COMMAND);
                }

            } else if (update.hasCallbackQuery()) {
                handleCallbackQuery(update.getCallbackQuery());
            }
        }
    }

    private void sendMainMenu(Long chatId) {
        SendMessage message = SendMessage.builder()
                .text("Welcome")
                .chatId(chatId)
                .build();

        Map<String, String> menuKeyboard = Map.of(
                "my_name", "Say my name.");

        message.setReplyMarkup(getInlineKeyboardMarkup(menuKeyboard));
        execute(message);
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

    private void handleCallbackQuery(CallbackQuery callbackQuery) {
        var data = callbackQuery.getData();
        var chatId = callbackQuery.getFrom().getId();
        var user = callbackQuery.getFrom();
        if (data.equals("my_name")) {
            send(chatId, ("Your name %s %s%n" +
                    "Your nickname: @%s")
                    .formatted(
                            user.getFirstName(),
                            user.getLastName(),
                            user.getUserName()));
        } else {
            send(chatId, NO_SUCH_COMMAND);
        }
    }

    private void send(Long chatId, String text) {
        SendMessage message = SendMessage.builder().text(text).chatId(chatId).build();
        execute(message);
    }

    private void execute(SendMessage message) {
        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
