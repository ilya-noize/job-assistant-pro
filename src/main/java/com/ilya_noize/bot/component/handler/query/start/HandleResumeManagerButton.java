package com.ilya_noize.bot.component.handler.query.start;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import com.ilya_noize.bot.component.handler.command.impl.HandleResumeManager;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.RESUME_MANAGER;

@Component
public class HandleResumeManagerButton implements HandleCallbackQuery {
    private final HandleResumeManager handleResumeManager;

    public HandleResumeManagerButton(HandleResumeManager handleResumeManager) {
        this.handleResumeManager = handleResumeManager;
    }

    @Override
    public String getOperationType() {

        return RESUME_MANAGER.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {
        return handleResumeManager.processing(callbackQuery.getMessage().getChatId());
    }
}
