package com.ilya_noize.bot.component.handler;

import com.ilya_noize.bot.enums.Command;
import com.ilya_noize.bot.enums.KeyboardButtons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MessageHandlerListener implements LongPollingUpdateConsumer {
    private final TelegramClient telegramClient;
    private final Map<String, HandleCommand> commands;
    private final Map<String, HandleCallbackQuery> callbackQueries;

    @Autowired
    public MessageHandlerListener(@Value("${telegram.bot.token}") String token,
                                  List<HandleCommand> commands,
                                  List<HandleCallbackQuery> callbackQueries) {
        this.telegramClient = new OkHttpTelegramClient(token);
        this.commands = commands.stream()
                .collect(Collectors.toMap(
                        HandleCommand::getOperationType,
                        handler -> handler));
        this.callbackQueries = callbackQueries.stream()
                .collect(Collectors.toMap(
                        HandleCallbackQuery::getOperationType,
                        handler -> handler));
    }

    @Override
    public void consume(List<Update> updates) {
        for (Update update : updates) {
            SendMessage processed = handleUpdate(update);
            if (processed == null) break;
            execute(processed);
        }
    }

    public SendMessage handleUpdate(Update update) throws IllegalArgumentException {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String messageKey = Command.findByName(message.getText());
            if (commands.containsKey(messageKey)) {
                return commands.get(messageKey)
                        .processing(message.getChatId());
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String queryKey = KeyboardButtons.findByCallback(callbackQuery.getData());
            if (callbackQueries.containsKey(queryKey)) {

                return callbackQueries.get(queryKey)
                        .processing(callbackQuery);
            }
        }
        return null;
    }

    private void execute(SendMessage message) {
        try {
            telegramClient.execute(message);
        } catch (TelegramApiException telegramApiException) {
            throw new IllegalArgumentException(telegramApiException);
        }
    }
}
