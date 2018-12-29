package basejava.project.webapp;

import basejava.project.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static basejava.project.webapp.model.ContactType.GITHUB;
import static basejava.project.webapp.model.ContactType.LINKEDIN;
import static basejava.project.webapp.model.ContactType.TELEPHON;
import static basejava.project.webapp.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("John Black");

        resume.getContact().put(LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.getContact().put(GITHUB, "https://github.com/gkislin");
        resume.getContact().put(TELEPHON, "+7-911-911-11-91");

        TextSection personal = new TextSection("Ведущий стажировок и корпоративного обучения по Java " +
                "Web и Enterprise технологиям");
        TextSection objective = new TextSection("Аналитический склад ума, сильная логика, креативность, " +
                "инициативность. Пурист кода и архитектуры");
        resume.getSection().put(PERSONAL, personal);
        resume.getSection().put(OBJECTIVE, objective);

        List<String> achievements = new ArrayList<>(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web " +
                        "приложения\",\"Java Enterprise\", " +
                        "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                        "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                        "Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                        "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."));
        ListSection achievement = new ListSection(achievements);
        resume.getSection().put(ACHIEVEMENT, achievement);

        List<String> qualifications = new ArrayList<>(Arrays.asList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, " +
                        "Jetty, WebLogic, WSO2", "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle"));
        ListSection qualification = new ListSection(qualifications);
        resume.getSection().put(QUALIFICATIONS, qualification);

        LocalDate start1 = LocalDate.of(2013, 10, 1);
        LocalDate end1 = LocalDate.now();
        Experience job1 = new Experience("Автор проекта", start1, end1, "Создание, организация и " +
                "проведение Java онлайн проектов и стажировок.", "Java Online Projects", "http://javaops.ru/");

        LocalDate start2 = LocalDate.of(2014, 10, 1);
        LocalDate end2 = LocalDate.of(2016, 1, 1);
        Experience job2 = new Experience("Старший разработчик (backend)", start2, end2, "Проектирование" +
                " и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", "Wrike","https://www.wrike.com/" );
        List<Experience> experienceList = new ArrayList<>();
        experienceList.add(job1);
        experienceList.add(job2);
        ExperienceSection experience = new ExperienceSection(experienceList);
        resume.getSection().put(EXPERIENCE, experience);

        System.out.println(resume);
    }
}
