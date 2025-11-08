package com.ilya_noize.bot.clients.vacancy.entity;

import java.util.List;

// Базовый класс для представления вакансии
public record Vacancy(
        String id,
        boolean premium,
        String name,
        Department department,
        boolean hasTest,
        boolean responseLetterRequired,
        Area area,
        Salary salary,
        SalaryRange salaryRange,
        VacancyType type,
        Address address,
        String responseUrl,
        Double sortPointDistance,
        String publishedAt,
        String createdAt,
        boolean archived,
        String applyAlternateUrl,
        Boolean showLogoInSearch,
        Boolean showContacts,
        Object insiderInterview,
        String url,
        String alternateUrl,
        List<Relation> relations,
        Employer employer,
        Snippet snippet,
//        Schedule schedule,    //Deprecated
        List<String> workingDays,
        List<String> workingTimeIntervals,
        List<String> workingTimeModes,
        boolean acceptTemporary,
        List<String> flyInFlyOutDuration,
        List<WorkFormat> workFormat,
        List<WorkingHours> workingHours,
        List<WorkSchedule> workScheduleByDays,
        boolean nightShifts,
        List<ProfessionalRole> professionalRoles,
        boolean acceptIncompleteResumes,
        Experience experience,
//        Employment employment,    //Deprecated
        EmploymentForm employmentForm,
        boolean internship,
        String advResponseUrl,
        boolean isAdvVacancy,
        Object advContext
) {}
