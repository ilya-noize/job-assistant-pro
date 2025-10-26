package com.ilya_noize.bot.component.handler;

import com.ilya_noize.bot.enums.Command;
import com.ilya_noize.bot.enums.KeyboardButtons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MessageHandlerListener implements LongPollingUpdateConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MessageHandlerListener.class);
    private final TelegramClient telegramClient;
    private final Map<String, HandleCommand> commands;
    private final Map<String, HandleCallbackQuery> callbackQueries;

    @Autowired
    public MessageHandlerListener(@Value("${telegram.bot.token}") String token,
                                  List<HandleCommand> commands,
                                  List<HandleCallbackQuery> callbackQueries) {
        logger.debug("MessageHandlerListener constructing...");
        this.telegramClient = new OkHttpTelegramClient(token);
        this.commands = commands.stream()
                .collect(Collectors.toMap(
                        HandleCommand::getOperationType,
                        handler -> handler));
        logger.debug("HandleCommands.count = '{}'", commands.size());
        this.callbackQueries = callbackQueries.stream()
                .collect(Collectors.toMap(
                        HandleCallbackQuery::getOperationType,
                        handler -> handler));
        logger.debug("HandleCallbackQueries.count = '{}'", callbackQueries.size());
        logger.debug("MessageHandlerListener constructed");
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
            logger.debug("Processing message '{}' ...", messageKey);
            if (commands.containsKey(messageKey)) {
                logger.debug("Process by message '{}' was found. Processing...", messageKey);
                return commands.get(messageKey)
                        .processing(message.getChatId());
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String queryKey = KeyboardButtons.findByText(callbackQuery.getData());
            logger.debug("Processing query '{}' ...", queryKey);
            if (callbackQueries.containsKey(queryKey)) {
                logger.debug("Process by query '{}' was found. Processing...", queryKey);

                return callbackQueries.get(queryKey)
                        .processing(callbackQuery);
            }
        }
        logger.trace("[t] Processing message fail. Can't execute null-response.");
        return null;
    }

    private void execute(SendMessage message) {
        Integer threadId = message.getMessageThreadId();
        logger.debug("Executing message id:{}...", threadId);
        try {
            telegramClient.execute(message);
            logger.debug("Execute message id:{} complete.", threadId);
        } catch (TelegramApiException telegramApiException) {
            logger.error("[e] Execute message fail - TelegramApiException: '{}'.", telegramApiException.getMessage());
            logger.trace("TelegramApiException: {}", Arrays.stream(telegramApiException.getStackTrace()).sequential());
        }
    }
}
