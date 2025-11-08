package com.ilya_noize.bot.clients.vacancy.entity;

import java.util.List;

public record Address(
        String city,
        String street,
        String building,
        Double lat,
        Double lng,
        String description,
        String raw,
        Metro metro,
        List<Metro> metroStations,
        String id
) {}
