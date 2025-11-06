package com.ilya_noize.bot.clients.directory;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;
import java.util.Map;

import static com.ilya_noize.bot.BotApplication.HH_USER_AGENT;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@HttpExchange(
        accept = APPLICATION_JSON_VALUE,
        contentType = APPLICATION_FORM_URLENCODED_VALUE,
        headers = {"HH-User-Agent", HH_USER_AGENT})
public interface DirectoryClient {
    @GetExchange(url = "/dictionaries")
    Map<String, List<DirectoryElement>> getDictionaries(@RequestParam(required = false) String host,
                                                        @RequestParam(required = false) String locale);


    @GetExchange(url = "/industries")
    Map<String, List<DirectoryElement>> getIndustries(@RequestParam(required = false) String host,
                                                      @RequestParam(required = false) String locale);


}
