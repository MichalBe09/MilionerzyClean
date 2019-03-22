package com.company.controller;

import com.company.communicates.Communicates;
import com.company.game_mechanism.Checker;
import com.company.questions.Generator;
import sun.nio.cs.Surrogate;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    Scanner scanner = new Scanner(System.in);
    Generator generator = new Generator();
    Checker checker = new Checker();
    Random random = new Random();
    Communicates communicates = new Communicates();

    int r;
    String skip = checker.getSkip();
    String answer;
    String exit = checker.getExit();
    boolean flag = true;

    public void run() {

        System.out.println(communicates.welcome);
        while (checker.getCounter() > 0 || flag) {      // petla w ktorej toczy się gra

            generator.generateQuestion();

            answer = scanner.nextLine();

            if (!answer.equals(skip) && !answer.equals(checker.getExit())) {

                if (answer.equals(generator.getRightAnswer()) && checker.modulo()) {
                    answer = scanner.nextLine();
                    checker.secondR(answer, generator.getRightAnswer());
                } else if (!answer.equals(generator.getRightAnswer()) && checker.modulo()) {
                    answer = scanner.nextLine();
                    checker.secondW(answer, generator.getRightAnswer());
                } else {
                    checker.right(answer, generator.getRightAnswer());
                }
            } else if (checker.skip(answer)) {

            } else checker.exit(answer);


            if (checker.getCounter() == 0 || answer.equals(checker.getExit())) {
                flag = false;
            }

        }
    }
}

