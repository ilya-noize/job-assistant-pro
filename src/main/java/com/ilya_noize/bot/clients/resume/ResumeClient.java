package com.ilya_noize.bot.clients.resume;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.time.LocalDateTime;

import static com.ilya_noize.bot.BotApplication.HH_USER_AGENT;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@HttpExchange(
        url = "/resumes",
        accept = APPLICATION_JSON_VALUE,
        contentType = APPLICATION_FORM_URLENCODED_VALUE,
        headers = {"HH-User-Agent", HH_USER_AGENT})
public interface ResumeClient {


    @PostExchange(url = "/{resumeId}/publish")
    void updateResume(@PathVariable String resumeId,
                      @RequestParam(required = false) String host,
                      @RequestParam(required = false) String locale);

    @PostExchange(url = "/{resumeId}/views")
    void viewsResume(@PathVariable String resumeId,
                     @RequestParam(required = false) String host,
                     @RequestParam(required = false) String locale);

    @GetExchange(url = "/{resumeId}/status")
    void statusResume(@PathVariable String resumeId,
                      @RequestParam(required = false) String host,
                      @RequestParam(required = false) String locale);

    @GetExchange(url = "/{resumeId}")
    void getResume(@PathVariable String resumeId,
                   @RequestParam(required = false) String host,
                   @RequestParam(required = false) String locale);

    @GetExchange(url = "/mine")
    void getMineResume(@RequestParam(required = false) String host,
                       @RequestParam(required = false) String locale);

    @GetExchange(url = "/{resumeId}/similar_vacancies")
    void getMineResume(@PathVariable String resumeId,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "100") Integer perPage,
                       @RequestParam String text,
                       @RequestParam String searchField,
                       @RequestParam String experience,
                       @RequestParam String employment,
                       @RequestParam String schedule,
                       @RequestParam(defaultValue = "1") String area,
                       @RequestParam String metro,
                       @RequestParam String professionalRole,
                       @RequestParam String industry,
                       @RequestParam String employerId,
                       @RequestParam String excludedEmployerId,
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
                       @RequestParam String partTime,
                       @RequestParam(defaultValue = "hh.ru") String host,
                       @RequestParam(defaultValue = "RU") String locale);
}
