package com.ilya_noize.bot.enums;


import static com.ilya_noize.bot.enums.Command.ANALYTIC;
import static com.ilya_noize.bot.enums.Command.FEEDBACK;
import static com.ilya_noize.bot.enums.Command.INTERVIEW;
import static com.ilya_noize.bot.enums.Command.RESUME;
import static com.ilya_noize.bot.enums.Command.START;

public enum KeyboardButtons {

    UNKNOWN("No such command", "unknown", ""),

    LAUNCH("Where is launched?", "launch", START.getName()),
    FEEDBACK_BASE(START.getDescription(), "feedback_base", START.getName()),
    RESUME_MANAGER(START.getDescription(), "resume_manager", START.getName()),
    CALENDAR(START.getDescription(), "calendar", START.getName()),
    ANALYTICAL_MODULE(START.getDescription(), "analytical_module", START.getName()),

    MANAGING_FEEDBACK("Управление списком откликов на вакансии",
            "managing_feedback", FEEDBACK.getName()),
    TRACKING_RESPONSE("Отслеживание статусов откликов",
            "tracking_response", FEEDBACK.getName()),
    REMINDERS_RESPONSE("Напоминания о сроках ответа работодателей",
            "reminders_response", FEEDBACK.getName()),

    VERSIONS("Хранение и управление версиями резюме",
            "versions", RESUME.getName()),
    TEMPLATES("Шаблоны для разных типов вакансий",
            "templates", RESUME.getName()),
    AUTOMATIC_FIELD_FILLING("Автоматическое заполнение полей",
            "field_filling", RESUME.getName()),

    INTERVIEW_PLANNING("Планирование интервью",
            "planning", INTERVIEW.getName()),
    REMINDERS("Напоминания",
            "reminders", INTERVIEW.getName()),
    NOTES("Хранение заметок по каждому собеседованию",
            "notes", INTERVIEW.getName()),

    STATISTICS_RESPONSES("Статистика по откликам",
            "statistics_responses", ANALYTIC.getName()),
    CASES("Анализ кейсов (успешных/неуспешных)",
            "cases", ANALYTIC.getName()),
    RECOMMENDATIONS("Рекомендации по улучшению процесса",
            "recommendations", ANALYTIC.getName());


    private final String description;
    private final String callbackData;
    private final String linkingMenu;

    KeyboardButtons(String description, String callbackData, String linkingMenu) {
        this.description = description;
        this.callbackData = callbackData;
        this.linkingMenu = linkingMenu;
    }

    public static String findByText(String text) {
        for (KeyboardButtons key : KeyboardButtons.values()) {
            if (key.callbackData.equals(text)) {
                return key.callbackData;
            }
        }
        return KeyboardButtons.UNKNOWN.callbackData;
    }

    public String getDescription() {
        return description;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public String getLinkingMenu() {
        return linkingMenu;
    }
}
