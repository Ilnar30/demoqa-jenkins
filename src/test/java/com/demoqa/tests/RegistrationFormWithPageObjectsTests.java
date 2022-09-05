package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @Tag("pageObject")
    void fillFormTest() {


        step("Open registration form ", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName("Alexander")
                    .setLastName("Ivanov")
                    .setEmail("alexivanov22@mail.ru")
                    .setGender("Male")
                    .setNumber("8999888776")
                    .setBirthDate("26", "October", "1970")
                    .setSubjects("English")
                    .setHobbies("Sports")
                    .setPicture("nature.jpeg")
                    .setCurrentAddress("Ufa")
                    .setStateAndCity("NCR", "Delhi")
                    .setSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage.checkResultsModalIsVisible()
                    .checkResult("Student Name", "Alexander Ivanov")
                    .checkResult("Student Email", "alexivanov22@mail.ru")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "8999888776")
                    .checkResult("Date of Birth", "26 October,1970")
                    .checkResult("Subjects", "English")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Picture", "nature.jpeg")
                    .checkResult("Address", "Ufa")
                    .checkResult("State and City", "NCR Delhi");
        });
    }

    @Test
    void fillFormWithMinimumDataTest() {
        step("Open registration form ", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName("Alexander")
                    .setLastName("Ivanov")
                    .setGender("Male")
                    .setNumber("8999888776")
                    .setSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage.checkResultsModalIsVisible()
                    .checkResult("Student Name", "Alexander Ivanov")
                    .checkResult("Mobile", "8999888776");
        });

    }
}
