package com.ilya_noize.bot.component.handler.query.start;

import com.ilya_noize.bot.component.handler.HandleCallbackQuery;
import com.ilya_noize.bot.component.handler.command.impl.HandleFeedbackBase;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static com.ilya_noize.bot.enums.KeyboardButtons.FEEDBACK_BASE;

@Component
public class HandleFeedbackBaseButton implements HandleCallbackQuery {
    private final HandleFeedbackBase handleFeedbackBase;

    public HandleFeedbackBaseButton(HandleFeedbackBase handleFeedbackBase) {
        this.handleFeedbackBase = handleFeedbackBase;
    }

    @Override
    public String getOperationType() {

        return FEEDBACK_BASE.getCallbackData();
    }

    @Override
    public SendMessage processing(CallbackQuery callbackQuery) {

        return handleFeedbackBase.processing(callbackQuery.getMessage().getChatId());
    }
}
