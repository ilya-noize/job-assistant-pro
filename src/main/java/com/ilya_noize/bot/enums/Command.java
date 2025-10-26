package com.ilya_noize.bot.enums;

public enum Command {
    UNKNOWN("",             "No such command"),

    START("/start",         "Начало работы"),
    MENU("/menu",           "Рабочее меню"),
    REPORT("/report",       "Показать отчёт");

    private final String name;
    private final String description;

    Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public static String findByName(String name) {
        for(Command command: Command.values()) {
            if (command.name.equals(name)) {
                return command.name;
            }
        }
        return Command.UNKNOWN.name;
    }

    public String getDescription() {
        return description;
    }
}
