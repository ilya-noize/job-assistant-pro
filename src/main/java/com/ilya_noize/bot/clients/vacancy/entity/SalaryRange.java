package com.ilya_noize.bot.clients.vacancy.entity;

public record SalaryRange(
        Integer from,
        Integer to,
        String currency,
        boolean gross,
        Mode mode,
        Frequency frequency
) {}
