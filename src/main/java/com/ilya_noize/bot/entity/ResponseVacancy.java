package com.ilya_noize.bot.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseVacancy {
    private String responseId;
    private String vacancyId;
    private String status;

    public ResponseVacancy(String responseId, String vacancyId, String status) {
        this.responseId = responseId;
        this.vacancyId = vacancyId;
        this.status = status;
    }

}
