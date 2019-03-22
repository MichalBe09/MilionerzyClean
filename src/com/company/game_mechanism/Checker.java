package com.company.game_mechanism;

import com.company.communicates.Communicates;


import java.util.Random;


public class Checker {


    int counter = 1;        // licznik pkt, warunkiem przegrania jest spadek tej zmiennej do 0, dlatego pętla musi zacząć się z wartością 1
    int lifebuoy = 0;       // licznik użytych kół ratunkowych
    String skip = "skip";   // komenda kola ratunkowego
    String exit = "Wyjście";

    Communicates communicates = new Communicates();
    Random random = new Random();


    public boolean modulo() {               // metoda ktora kazdorazowo po udzieleniu odpowiedzi generuje randoma i oblicza z niego modulo, jeśli warunek jest spełniony, generuje pytanie dodatkowe

        int r = random.nextInt(10000);

        if (r % 7 == 0) {
            System.out.println(communicates.areYouSure);

            return true;
        }
        return false;
    }

    public void exit(String answer) {       // metoda pozwalajaca na zakonczenie gry w dowolnym momencie
        if (answer.equals(exit)) {
            System.out.println(communicates.exitGame + (counter - 1));      // zawsze soutuje counter-1, poniewaz jednym z warunkow przerwania petli jest spadek punktow do 0, dlatego counter ma domyslna wartosc 1, ale gracz nie musi o tym wiedziec
        }
    }


    public void secondR(String answer, String rightAnswer) {        // metoda odpalająca się, jeśli po udzieleniu prawidlowej odpowiedzi warunek do wyswietlenia pytania zwodzacego zostanie spelniony

        if (answer.equals(rightAnswer)) {
            counter++;
            System.out.println(communicates.right + (counter - 1));

        } else {
            counter--;
            System.out.println(communicates.secondWrong + (counter - 1));
            if (counter == 0) {
                System.out.println(communicates.lost);
            } else if (counter == 1) {
                counter--;
                System.out.println(communicates.lost);

            }
        }
    }

    public void secondW(String answer, String rightAnswer){     // metoda odpalająca się, jeśli gracz odpowie zle i warunek do pytania dodatkowego zostanie spelniony

        if (answer.equals(rightAnswer)){
            System.out.println(communicates.secondRight+(counter-1));   // jesli za drugim razem odpowiemy dobrze, nie dostajemy punktu, ale tez nie tracimy
        }else {
            counter--;
            System.out.println(communicates.wrong + (counter - 1));
            if (counter == 0) {
                System.out.println(communicates.lost);
            } else if (counter == 1) {
                counter--;
                System.out.println(communicates.lost);
            }
        }
    }


    public int right(String answer, String rightAnswer) {       // metoda odpalajaca sie, jeśli po udzieleniu odpowiedzi warunek pytania dodatkowego nie zostanie spelniony

        if (answer.equals(rightAnswer)) {
            counter++;
            System.out.println(communicates.right + (counter - 1));
        } else {
            counter--;
            System.out.println(communicates.wrong + (counter - 1));
            if (counter ==0){
                System.out.println(communicates.lost);
            }
            if (counter == 1) {
                counter--;
                if (counter <= 0) {
                    System.out.println(communicates.lost);
                } else {
                    System.out.println(communicates.wrong + (counter - 1));
                }
            }
        }
        return counter;
    }


    public boolean skip(String answer) {        // metoda kola ratunkowego, graczowi na kazda gre przysluguja 3 kola, przy >3 probie uzycia kola, gracz traci punkty

        if (answer.equals(skip)) {
            lifebuoy++;
            if (lifebuoy <= 3) {
                System.out.println(communicates.skip + lifebuoy);

                return true;

            } else if (lifebuoy > 3) {
                counter--;
                System.out.println(communicates.noSkipsLeft+(counter-1));
                    if (counter <= 0) {
                        System.out.println(communicates.lost);
                    }


                return false;
            }
        }
        return false;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}