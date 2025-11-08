package com.ilya_noize.bot.clients.vacancy;

import com.ilya_noize.bot.clients.vacancy.entity.Vacancy;
import com.ilya_noize.bot.clients.vacancy.request.VacancyRequest;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@HttpExchange(
        accept = APPLICATION_JSON_VALUE,
        contentType = APPLICATION_FORM_URLENCODED_VALUE)
public interface VacancyClient {

    @PostExchange(url = "/vacancies")
    Vacancy searchVacancies(VacancyRequest vacancyRequest);
}
