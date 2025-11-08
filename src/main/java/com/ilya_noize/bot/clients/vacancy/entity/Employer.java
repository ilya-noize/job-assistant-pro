package com.ilya_noize.bot.clients.vacancy.entity;

public record Employer(
        String id,
        String name,
        String url,
        String alternateUrl,
        LogoUrls logoUrls,
        String vacanciesUrl,
        Integer countryId,
        boolean accreditedItEmployer,
        boolean trusted
) {}
