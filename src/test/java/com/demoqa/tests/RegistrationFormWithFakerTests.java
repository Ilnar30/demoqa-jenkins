package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static io.qameta.allure.Allure.step;


public class RegistrationFormWithFakerTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    @Tag("faker")
    void fillFormTest() {

        step("Open registration form ", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setGender(userGender)
                    .setNumber(userNumber)
                    .setBirthDate(day, month, year)
                    .setSubjects(userSubjects)
                    .setHobbies(userHobbies)
                    .setPicture(userPicture)
                    .setCurrentAddress(currentAdress)
                    .setStateAndCity(state, city)
                    .setSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage.checkResultsModalIsVisible()
                    .checkResult("Student Name", expectedFullName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", userGender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", expectedDateOfBirth)
                    .checkResult("Subjects", userSubjects)
                    .checkResult("Hobbies", userHobbies)
                    .checkResult("Picture", userPicture)
                    .checkResult("Address", currentAdress)
                    .checkResult("State and City", expectedLocation);
        });
    }

    @Test
    void fillFormWithMinimumDataTest() {

        step("Open registration form ", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(userGender)
                    .setNumber(userNumber)
                    .setSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage.checkResultsModalIsVisible()
                    .checkResult("Student Name", expectedFullName)
                    .checkResult("Mobile", userNumber);
        });

    }
}
