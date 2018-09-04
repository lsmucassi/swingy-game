package com.lmucassi.app.controller;

import com.lmucassi.app.model.Enemies;
import com.lmucassi.app.model.Heroes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {

    public Process() {}

    //get players
    public void loadPlayer(Heroes h) {
        String fileName = "src/players.txt";
        File file = new File(fileName);

        try {
            Scanner inFile = new Scanner(file);

            listPlayers(inFile, h);
            System.out.println("\n");
            inFile.close();

        } catch (FileNotFoundException err) {
            System.out.println("Err: Players file not found [ error loading heroes ]");
            err.printStackTrace();
        }

        Scanner creatCha = new Scanner(System.in);
        int doneCreat = 0;

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

    //list available players
    public  void listPlayers(Scanner ls, Heroes h) {
        ArrayList<Heroes> players = new ArrayList<>();

        while (ls.hasNext()) {
            players.add(h.getHero(ls.next()));
        }
//        hero = players.get(3);
        for ( Heroes count: players) {
            System.out.println((players.indexOf(h) + 1) + " " + count.getName()
                    + " - The " + count.getType()
                    + " - level " + count.getLevel());
        }
    }
}
