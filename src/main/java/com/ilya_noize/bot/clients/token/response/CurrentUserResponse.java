package com.ilya_noize.bot.clients.token.response;

import java.util.List;
import java.util.Map;

public record CurrentUserResponse(
        String auth_type,       //:"applicant",
        boolean is_admin,       //":false,
        boolean is_applicant,   //":false,
        boolean is_application, //":false,
        boolean is_employer,    //":false,
        boolean is_employer_integration, //":false,
        String email,           //":"ivanov@example.com",
        String first_name,      //":"Александр",
        String id,              //":"12345678",
        boolean is_anonymous,   //":true,
        String last_name,       //":"Иванов",
        String mid_name,        //":"Николаевич",
        String middle_name,     //":"Петрович",
        String phone,           //":"79164555555",
        Counter counters,
//        Employer employer,   //{}
        boolean is_in_search,   //":false,
        List<LinkedSocials> linked_socials,
//        Manager manager,    //": {},
        String negotiations_url,        //":"http://example.com",
        Map<String, String> personal_manager,   //": {},
        ProfileVideo profile_videos, //":
        String resumes_url, //":"https://api.hh.ru/resumes/mine",
        UserStatuses user_statuses) {

//    record Employer() {}
//    record Manager() {}

    record Counter(
            int newResumeViews, //2
            int resumesCount,   //5
            int unreadNegotiations  //1
    ) {
    }

    record LinkedSocials(
            String id,  // "id":"vk",
            String name // "name":"Вконтакте"
    ) {
    }

    /**
     * "profile_videos": {
     * "items": [
     * {
     * "download_url": {
     * "expires_at": "2022-01-01T12:00:00+0300",
     * "url": "https://storage.yandexcloud.net/..."
     * },
     * "id": "ec6b42e5-b0fb-4f72-b81b-5b44f8c09968"
     * }
     * ]
     * }
     */
    record ProfileVideo(
            List<DownloadedVideo> items
    ) {
        record DownloadedVideo(
                DownloadUrlData download_url,
                String id
        ) {
            record DownloadUrlData(
                    String expires_at,
                    String url
            ) {
            }
        }
    }

    /**
     * "user_statuses": {
     * "job_search_status": {
     * "id": "active_search",
     * "last_change_time": "2024-02-08T10:48:44.267Z",
     * "name": "В активном поиске работы"
     * }
     * }
     */
    record UserStatuses(
            JobSearchStatus jobSearchStatus
    ) {
        record JobSearchStatus(
                String id,
                String lustChangeTime,
                String name
        ) {
        }
    }
}