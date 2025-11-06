package com.ilya_noize.bot.clients.vacancy;

import com.ilya_noize.bot.clients.vacancy.entity.Vacancy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@HttpExchange(
        accept = APPLICATION_JSON_VALUE,
        contentType = APPLICATION_FORM_URLENCODED_VALUE)
public interface SearchVacancies {

    @PostExchange(url = "/vacancies")
    Vacancy searchVacancies(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "100") Integer perPage,
            @RequestParam String text,
            @RequestParam String searchField,
            @RequestParam String experience,
            @RequestParam(defaultValue = "1") String area,
            @RequestParam String metro,
            @RequestParam String professionalRole,
            @RequestParam String industry,
            @RequestParam String employerId,
            @RequestParam String currency,
            @RequestParam Integer salary,
            @RequestParam String label,
            @RequestParam(defaultValue = "false") Boolean onlyWithSalary,
            @RequestParam Integer period,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dateFrom,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dateTo,
            @RequestParam Integer topLat,
            @RequestParam Integer bottomLat,
            @RequestParam Integer leftLng,
            @RequestParam Integer rightLng,
            @RequestParam String orderBy,
            @RequestParam Integer sortPointLat,
            @RequestParam Integer sortPointLng,
            @RequestParam(defaultValue = "false") Boolean clusters,
            @RequestParam(defaultValue = "false") Boolean describeArguments,
            @RequestParam(defaultValue = "false") Boolean noMagic,
            @RequestParam(defaultValue = "false") Boolean premium,
            @RequestParam(defaultValue = "false") Boolean responsesCountEnables,
            @RequestParam(defaultValue = "false") Boolean acceptTemporary,
            @RequestParam String employmentFrom,
            @RequestParam String workScheduleByDays,
            @RequestParam String workingHours,
            @RequestParam String workFormat,
            @RequestParam String excludedText,
            @RequestParam String education,
            @RequestParam(defaultValue = "hh.ru") String host,
            @RequestParam(defaultValue = "RU") String locale
    );
}
