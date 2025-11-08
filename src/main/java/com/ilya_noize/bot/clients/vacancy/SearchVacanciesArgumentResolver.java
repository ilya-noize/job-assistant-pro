package com.ilya_noize.bot.clients.vacancy;

import com.ilya_noize.bot.clients.vacancy.request.VacancyRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.service.invoker.HttpRequestValues;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

public class SearchVacanciesArgumentResolver implements HttpServiceArgumentResolver {
    @Override
    public boolean resolve(Object argument, MethodParameter parameter, HttpRequestValues.Builder requestValues) {
        if(parameter.getParameterType().equals(VacancyRequest.class)) {
            VacancyRequest vacancyRequest = (VacancyRequest) argument;
//            requestValues.addRequestParameter("");
        }
        return false;
    }
}
