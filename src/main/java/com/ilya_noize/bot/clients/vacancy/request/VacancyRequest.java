package com.ilya_noize.bot.clients.vacancy.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class VacancyRequest {
    private Integer page = 0;
    private Integer perPage = 100;
    private String text;
    private String searchField;
    private String experience;
    private Integer area = 1;
    private String metro;
    private String professionalRole;
    private String industry;
    private String employerId;
    private String currency;
    private Integer salary;
    private String label;
    private Boolean onlyWithSalary = false;
    private Integer period;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private Integer topLat;
    private Integer bottomLat;
    private Integer leftLng;
    private Integer rightLng;
    private String orderBy;
    private Integer sortPointLat;
    private Integer sortPointLng;
    private Boolean clusters = false;
    private Boolean describeArguments = false;
    private Boolean noMagic = false;
    private Boolean premium = false;
    private Boolean responsesCountEnables = false;
    private Boolean acceptTemporary = false;
    private String employmentFrom;
    private String workScheduleByDays;
    private String workingHours;
    private String workFormat;
    private String excludedText;
    private String education;
    private String host = "hh.ru";
    private String locale = "RU";
}



