package basejava.project.webapp;

import basejava.project.webapp.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static basejava.project.webapp.model.ContactType.GITHUB;
import static basejava.project.webapp.model.ContactType.LINKEDIN;
import static basejava.project.webapp.model.ContactType.TELEPHON;
import static basejava.project.webapp.model.SectionType.ACHIEVEMENT;
import static basejava.project.webapp.model.SectionType.EXPERIENCE;
import static basejava.project.webapp.model.SectionType.QUALIFICATIONS;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("John Black");
        Link gitHubPage = new Link("Профиль GitHub", "https://github.com/gkislin");
        Link linkedInPage = new Link("Профиль LinkedIn", "https://www.linkedin.com/in/gkislin");
        Link homePage = new Link("homePage", "https://yandex.ru/");

        Contact LinkedInContact = new Contact("Профиль LinkedIn", linkedInPage);
        Contact GitHubContact = new Contact("Профиль GitHub", gitHubPage);
        Contact phone = new Contact("+7(921) 855-048");

        resume.getContact().put(LINKEDIN, LinkedInContact);
        resume.getContact().put(GITHUB, GitHubContact);
        resume.getContact().put(TELEPHON, phone);
        //System.out.println(resume.getContact());

        String content1 = "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям";
        String content2 = "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры";
        TextSection personal = new TextSection(content1);
        TextSection objective = new TextSection(content2);

        List<String> achievements = new ArrayList<>();
        String point1 = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 1000 выпускников.";
        String point2 = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
        achievements.add(point1);
        achievements.add(point2);
        ListSection achievement = new ListSection(achievements);

        List<String> qualifications = new ArrayList<>();
        String item = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
        String item2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
        String item3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle";
        qualifications.add(item);
        qualifications.add(item2);
        qualifications.add(item3);
        ListSection qualification = new ListSection(qualifications);
        resume.getSection().put(ACHIEVEMENT, achievement);
        resume.getSection().put(QUALIFICATIONS, qualification);
        //System.out.println(resume);

        String title1 = "Автор проекта";
        String description1 = "Создание, организация и проведение Java онлайн проектов и стажировок.";
        Link jobLink1 = new Link("Java Online Projects", "http://javaops.ru/");
        LocalDate start1 = LocalDate.of(2013, 10, 1);
        LocalDate end1 = LocalDate.now();
        Experience job1 = new Experience(title1, start1, end1, description1, jobLink1);

        String title2 = "Старший разработчик (backend)";
        String description2 = "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.";
        Link jobLink2 = new Link("Wrike", "https://www.wrike.com/");
        LocalDate start2 = LocalDate.of(2014, 10, 1);
        LocalDate end2 = LocalDate.of(2016, 1, 1);
        Experience job2 = new Experience(title2, start2, end2, description2, jobLink2);
        List<Experience> experienceList = new ArrayList<>();
        experienceList.add(job1);
        experienceList.add(job2);
        ExperienceSection experience = new ExperienceSection(experienceList);
        resume.getSection().put(EXPERIENCE, experience);

        System.out.println(resume);
    }
}
