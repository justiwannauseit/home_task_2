package com.otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Затем;
import lombok.extern.java.Log;
import pages.PreparatoryCourses;

@Log
public class PreparatoryCoursesSteps {

    @Inject
    private PreparatoryCourses preparatoryCourses;

    @Затем("^Вывести информацию о самом (дешевом|дорогом) курсе$")
    public void printInfoAboutTheMostExpensiveOrCheapCourse(String param) {
        switch (param) {
            case "дешевом":
                log.info("-----> Самый дешевый курс:");
                preparatoryCourses.printToCheapCourse();
                break;
            case "дорогом":
                log.info("-----> Самый дорогой курс:");
                preparatoryCourses.printToExpensiveCourse();
                break;
        }
    }

}
