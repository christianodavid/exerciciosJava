package com.botsimples.controller;

import com.botsimples.model.Bot;
import com.botsimples.view.BotView;

public class BotController {
    private final Bot model;
    private final BotView view;

    public BotController(Bot model, BotView view) {
        this.model = model;
        this.view = view;
    }

    public void runBot() {
        greet();
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    private void greet() {
        view.displayGreeting(model.getBotName(), model.getBotYear());
    }

    private void remindName() {
        String name = view.getUserName();
        model.setUserName(name);
        view.displayNameConfirmation(name);
    }

    private void guessAge() {
        view.displayGuessAgePrompt();
        int[] remainders = view.getAgeRemainders();
        int age = model.calculateAge(remainders[0], remainders[1], remainders[2]);
        model.setUserAge(age);
        view.displayAgeGuess(age);
    }

    private void count() {
        view.displayCountPrompt();
        int limit = view.getCountLimit();
        for(int i = 0; i <= limit; i++) {
            view.displayCount(i);
        }
    }

    private void test() {
        view.displayTest();
        int correctAnswer = 3;
        int userAnswer;
        do {
            userAnswer = view.getTestAnswer();
            view.displayTestResult(userAnswer == correctAnswer);
        } while (userAnswer != correctAnswer);
    }

    private void end() {
        view.displayEnd();
        view.closeScanner();
    }
}
