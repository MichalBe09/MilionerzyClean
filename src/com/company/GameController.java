package com.company;

import com.company.communicates.Communicates;
import com.company.game_mechanism.Checker;
import com.company.questions.Generator;

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
    String exit = "Wyjście";


    public void run() {

        System.out.println(communicates.welcome);
        while (checker.getCounter() > 0) {

            List<String> col = generator.generateQuestion();

            answer = scanner.nextLine();

            if (answer.equals(generator.getRightAnswer()) && checker.modulo()) {        // wchodzi w modulo nawet jak zla odpowiedz
                answer = scanner.nextLine();
                checker.secondR(answer, generator.getRightAnswer());   // przerobiona metoda
            } else {
                checker.right(answer, generator.getRightAnswer());
            }
            if (!answer.equals(skip) && !answer.equals(exit)) {

             else if (!answer.equals(generator.getRightAnswer()) && checker.modulo()) {
                    answer = scanner.nextLine();
                    checker.secondW(answer,generator.getRightAnswer());


                } else {
                    checker.skip(answer);

            }

            System.out.println(communicates.lost);

        }
    }

}
