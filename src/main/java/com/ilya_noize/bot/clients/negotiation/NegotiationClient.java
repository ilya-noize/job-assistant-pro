package com.ilya_noize.bot.clients.negotiation;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.ilya_noize.bot.BotApplication.HH_USER_AGENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@HttpExchange(
        url = "/negotiations",
        accept = APPLICATION_JSON_VALUE,
        contentType = MULTIPART_FORM_DATA_VALUE,
        headers = {"HH-User-Agent", HH_USER_AGENT})
public interface NegotiationClient {

    @PostExchange
    void makeNegotiation(@RequestParam String resumeId,
                      @RequestParam String vacancyId,
                      @RequestParam(required = false) String message,
                      @RequestParam(required = false) String host,
                      @RequestParam(required = false) String locale);
}
