package com.ilya_noize.bot.enums;


public enum KeyboardButtons {

    UNKNOWN("No such command", Callback.UNKNOWN, ""),

    LAUNCH("Where is launched?", Callback.LAUNCH, Command.TOOLS.getName()),

    FEEDBACK_BASE(Command.FEEDBACK_BASE.getDescription(), Callback.FEEDBACK_BASE, Command.START.getName()),
    RESUME_MANAGER(Command.RESUME_MANAGER.getDescription(), Callback.RESUME_MANAGER, Command.START.getName()),
    INTERVIEW_CALENDAR(Command.INTERVIEW_CALENDAR.getDescription(), Callback.CALENDAR, Command.START.getName()),
    ANALYTICAL_MODULE(Command.ANALYTICAL_MODULE.getDescription(), Callback.ANALYTICAL_MODULE, Command.START.getName())    ,

    MANAGING_FEEDBACK("Управление списком откликов на вакансии", Callback.MANAGING_FEEDBACK, Command.FEEDBACK_BASE.getName()),
    TRACKING_RESPONSE("Отслеживание статусов откликов", Callback.TRACKING_RESPONSE, Command.FEEDBACK_BASE.getName()),
    REMINDERS_RESPONSE("Напоминания о сроках ответа работодателей", Callback.REMINDERS_RESPONSE, Command.FEEDBACK_BASE.getName()),

    VERSIONS("Хранение и управление версиями резюме", Callback.VERSIONS, Command.RESUME_MANAGER.getName()),
    TEMPLATES("Шаблоны для разных типов вакансий", Callback.TEMPLATES, Command.RESUME_MANAGER.getName()),
    AUTOMATIC_FIELD_FILLING("Автоматическое заполнение полей", Callback.FIELD_FILLING, Command.RESUME_MANAGER.getName()),

    INTERVIEW_PLANNING("Планирование интервью", Callback.PLANNING, Command.INTERVIEW_CALENDAR.getName()),
    REMINDERS("Напоминания", Callback.REMINDERS, Command.INTERVIEW_CALENDAR.getName()),
    NOTES("Хранение заметок по каждому собеседованию", Callback.NOTES, Command.INTERVIEW_CALENDAR.getName()),

    STATISTICS_RESPONSES("Статистика по откликам", Callback.STATISTICS_RESPONSES, Command.ANALYTICAL_MODULE.getName()),
    CASES("Анализ кейсов (успешных/неуспешных)", Callback.CASES, Command.ANALYTICAL_MODULE.getName()),
    RECOMMENDATIONS("Рекомендации по улучшению процесса", Callback.RECOMMENDATIONS, Command.ANALYTICAL_MODULE.getName());

    private final String description;
    private final Callback callbackData;
    private final String linkingMenu;

    KeyboardButtons(String description, Callback callbackData, String linkingMenu) {
        this.description = description;
        this.callbackData = callbackData;
        this.linkingMenu = linkingMenu;
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
