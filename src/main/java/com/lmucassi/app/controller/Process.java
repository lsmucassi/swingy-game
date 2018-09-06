package com.lmucassi.app.controller;

import com.lmucassi.app.model.Enemies;
import com.lmucassi.app.model.Heroes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    int isFound = 0;
    public Process() {}

    //get players.txt
    public void loadPlayer(Heroes h) {

        String fileName = "/goinfre/lmucasi/Documents/swingy-game/src/main/java/com/lmucassi/app/players.txt";
        File file = new File(fileName);

        try {
            Scanner inFile = new Scanner(file);

            listPlayers(inFile, h);
            System.out.println("\n");
            inFile.close();
            isFound = 1;

        } catch (FileNotFoundException err) {
            System.out.println("\033[31mErr\033[0m: Players file not found \n\t\033[31m[ error loading heroes ]\033[0m\n");
            err.getMessage();
            System.out.println("\033[31mErr\033[0m: Invalid File \n\t\033[33m[ hint: fix file and run the game again]\033[0m\n");
            System.exit(0);
        }

        Scanner creatCha = new Scanner(System.in);
        int doneCreat = 0;

        if (isFound == 1) {
            System.out.println("\t \033[34m - C : Would you like to create a hero \033[0m");
            System.out.println("\t \033[31m - S : Choose from a list \033[0m");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\033[32m $ Enter command \033[0m");
            System.out.print("\033[32m $  \033[0m");

            String nextCha = creatCha.nextLine();
            if (nextCha == "C") {
                while (doneCreat == 0) {
                    //enter Hero characteristics
                }
            }
        }
    }

    //list available players.txt
    public  void listPlayers(Scanner ls, Heroes h) {
        ArrayList<Heroes> players = new ArrayList<>();

        while (ls.hasNext()) {
            players.add(h.getHero(ls.next()));
        }
//        hero = players.txt.get(3);
        for ( Heroes count: players) {
            System.out.println((players.indexOf(count) + 1) + " " + count.getName()
                    + " - The " + count.getType()
                    + " - level " + count.getLevel());
        }
    }
}
