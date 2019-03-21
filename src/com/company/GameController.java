package com.company;

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

    String answer;


    public void run() {

        while (checker.getCounter() > 0) {
            List<String> col = generator.generateQuestion();
            answer = scanner.nextLine();
            checker.right(answer,generator.getRightAnswer());



        }


    }
}


