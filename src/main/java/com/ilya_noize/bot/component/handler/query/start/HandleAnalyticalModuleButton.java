package com.ilya_noize.bot.component.handler.query.start;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import com.ilya_noize.bot.component.handler.command.impl.HandleAnalytic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.ANALYTICAL_MODULE;

@Component
public class HandleAnalyticalModuleButton implements HandleCallbackQuery {
    private final HandleAnalytic handleAnalytic;

    @Autowired
    public HandleAnalyticalModuleButton(HandleAnalytic handleAnalytic) {
        this.handleAnalytic = handleAnalytic;
    }

    @Override
    public String getOperationType() {

        return ANALYTICAL_MODULE.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {

        return handleAnalytic.processing(callbackQuery.getMessage().getChatId());
    }
}
