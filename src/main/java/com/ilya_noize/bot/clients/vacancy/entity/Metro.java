package com.ilya_noize.bot.clients.vacancy.entity;

public record Metro(
        String stationName,
        String lineName,
        String stationId,
        String lineId,
        Double lat,
        Double lng
) {}
