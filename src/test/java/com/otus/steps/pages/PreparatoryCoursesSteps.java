package com.otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Затем;
import pages.PreparatoryCourses;

public class PreparatoryCoursesSteps {

    @Inject
    private PreparatoryCourses preparatoryCourses;

    @Затем("^Вывести информацию о самом (дешевом|дорогом) курсе$")
    public void printInfoAboutTheMostExpensiveOrCheapCourse(String param) {
        switch (param) {
            case "дешевом":
                System.out.println("-----> Самый дешевый курс:");
                preparatoryCourses.printToCheapCourse();
                break;
            case "дорогом":
                System.out.println("-----> Самый дорогой курс:");
                preparatoryCourses.printToExpensiveCourse();
                break;
        }
    }

}
