package com.company.game_mechanism;

import com.company.communicates.Communicates;
import com.company.questions.Generator;

import java.util.Random;
import java.util.Scanner;

public class Checker {

    int counter = 1;


    Communicates communicates = new Communicates();


    public void right(String answer, String rightAnswer) {
        if (answer.equals(rightAnswer)) {
            counter++;
            System.out.println(communicates.right + (counter - 1));
        } else {
            counter--;
            if (counter == 0){
                System.out.println(communicates.lost);
            }else {
                counter--;
                System.out.println(communicates.wrong+counter);
            }
        }
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
