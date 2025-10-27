package com.ilya_noize.bot.enums;


import static com.ilya_noize.bot.enums.Command.ANALYTIC;
import static com.ilya_noize.bot.enums.Command.FEEDBACK;
import static com.ilya_noize.bot.enums.Command.INTERVIEW;
import static com.ilya_noize.bot.enums.Command.RESUME;
import static com.ilya_noize.bot.enums.Command.START;
import static com.ilya_noize.bot.enums.Command.TOOLS;

public enum KeyboardButtons {

    UNKNOWN("No such command", Callback.UNKNOWN, ""),

    LAUNCH("Where is launched?", Callback.LAUNCH, TOOLS.getName()),

    FEEDBACK_BASE(START.getDescription(), Callback.FEEDBACK_BASE, START.getName()),
    RESUME_MANAGER(START.getDescription(), Callback.RESUME_MANAGER, START.getName()),
    CALENDAR(START.getDescription(), Callback.CALENDAR, START.getName()),
    ANALYTICAL_MODULE(START.getDescription(), Callback.ANALYTICAL_MODULE, START.getName())    ,

    MANAGING_FEEDBACK("Управление списком откликов на вакансии", Callback.MANAGING_FEEDBACK, FEEDBACK.getName()),
    TRACKING_RESPONSE("Отслеживание статусов откликов", Callback.TRACKING_RESPONSE, FEEDBACK.getName()),
    REMINDERS_RESPONSE("Напоминания о сроках ответа работодателей", Callback.REMINDERS_RESPONSE, FEEDBACK.getName()),

    VERSIONS("Хранение и управление версиями резюме", Callback.VERSIONS, RESUME.getName()),
    TEMPLATES("Шаблоны для разных типов вакансий", Callback.TEMPLATES, RESUME.getName()),
    AUTOMATIC_FIELD_FILLING("Автоматическое заполнение полей", Callback.FIELD_FILLING, RESUME.getName()),

    INTERVIEW_PLANNING("Планирование интервью", Callback.PLANNING, INTERVIEW.getName()),
    REMINDERS("Напоминания", Callback.REMINDERS, INTERVIEW.getName()),
    NOTES("Хранение заметок по каждому собеседованию", Callback.NOTES, INTERVIEW.getName()),

    STATISTICS_RESPONSES("Статистика по откликам", Callback.STATISTICS_RESPONSES, ANALYTIC.getName()),
    CASES("Анализ кейсов (успешных/неуспешных)", Callback.CASES, ANALYTIC.getName()),
    RECOMMENDATIONS("Рекомендации по улучшению процесса", Callback.RECOMMENDATIONS, ANALYTIC.getName());

    private final String description;
    private final Callback callbackData;
    private final String linkingMenu;

    KeyboardButtons(String description, Callback callbackData, String linkingMenu) {
        this.description = description;
        this.callbackData = callbackData;
        this.linkingMenu = linkingMenu;
    }

    public static String findByCallback(String callback) {
        Callback finding = Enum.valueOf(Callback.class, callback);
        for (KeyboardButtons key : KeyboardButtons.values()) {
            if (key.callbackData.equals(finding)) {
                return key.callbackData.toString();
            }
        }
        return KeyboardButtons.UNKNOWN.callbackData.toString();
    }
    public String getDescription() {
        return description;
    }

    public String getCallbackData() {
        return callbackData.toString().toLowerCase();
    }

    public String getLinkingMenu() {
        return linkingMenu;
    }

}
