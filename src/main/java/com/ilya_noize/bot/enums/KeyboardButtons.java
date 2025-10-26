package com.ilya_noize.bot.enums;

import static com.ilya_noize.bot.enums.Command.START;

public enum KeyboardButtons {

    UNKNOWN("No such command", "unknown", ""),

    NAME("Say my name", "my_name_is", START.getName()),
    LAUNCH(   "Where is launched?", "launched", START.getName()),
    AUTHORIZE("Authorize me", "auth", START.getName()),
    MANAGE("goto Menu", "menu", START.getName());

    private final String callbackData;
    private final String text;
    private final String linkingMenu;

    KeyboardButtons(String callbackData, String text, String linkingMenu) {
        this.callbackData = callbackData;
        this.text = text;
        this.linkingMenu = linkingMenu;
    }

    public static String findByText(String text) {
        for(KeyboardButtons key: KeyboardButtons.values()) {
            if (key.text.equals(text)) {
                return key.text;
            }
        }
        return KeyboardButtons.UNKNOWN.text;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public String getText() {
        return text;
    }

    public String getLinkingMenu() {
        return linkingMenu;
    }
}
