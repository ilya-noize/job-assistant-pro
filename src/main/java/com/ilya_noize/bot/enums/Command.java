package com.ilya_noize.bot.enums;

/**
 * # BotFather settings:
 * start - Начало работы
 * feedback - База откликов
 * resume - Менеджер резюме
 * interview - Календарь собеседований
 * analytic - Аналитический модуль
 */
public enum Command {
    UNKNOWN     ("",            "No such command"),
    TOOLS       ("/tools",      "Инструменты"),

    START       ("/start",      "Начало работы")    ,
    FEEDBACK    ("/feedback",   "База откликов"),
    RESUME      ("/resume",     "Менеджер резюме"),
    INTERVIEW   ("/interview",  "Календарь собеседований"),
    ANALYTIC    ("/analytic",   "Аналитический модуль")
;
    private final String name;
    private final String description;

    Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static String findByName(String name) {
        for (Command command : Command.values()) {
            if (command.name.equals(name)) {
                return command.name;
            }
        }
        return Command.UNKNOWN.name;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}