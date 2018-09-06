package com.lmucassi.app.controller;

import java.util.List;
import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemies;
import com.lmucassi.app.model.Heroes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    int isFound = 0;
    ErrException err = new ErrException();
    public Process() {}

    //get players.txt
    public void loadPlayer(Heroes h) {

        int er = 1;
        String fileName = "/goinfre/lmucassi/Documents/swingy-game/src/main/java/com/lmucassi/app/players.txt";
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

        Scanner Cha = new Scanner(System.in);

        while ( er == 1) {
            if (isFound == 1) {
                System.out.println("\t \033[34m - C : Would you like to create a hero \033[0m");
                System.out.println("\t \033[31m - S : Choose from the list [ select a number ] \033[0m");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("\033[32m $ Enter command \033[0m");
                System.out.print("\033[32m $  \033[0m");

                String nextCha = Cha.nextLine();
                if (nextCha.equals("C") || nextCha.equals("c")) {
                    createHero(h);
                    er = 0;
                } else if (nextCha.equals("S") || nextCha.equals("s")) {
                    //select player an set
                    er = 0;
                } else {
                    err.checkMovErr(nextCha);
                }
            }
        }
    }

    //create hero
    public void createHero(Heroes h) {
        int doneCreat = 1;
        List<String> list = new ArrayList<String>();
        Scanner Cha = new Scanner(System.in);
//        String getH;

        //enter Hero characteristics
        while (doneCreat == 1) {
            System.out.println("\n\033[32m $ Enter Hero's Name: \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Class: \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Level between 0 - 2 : \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Level Experience: \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Clan : \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Attack Strength: \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Defence Strength : \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's First Weapon : \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Second Weapon: \033[0m");
            System.out.print("\033[32m $  \033[0m");
//            getH = Cha.nextLine();
            list.add(Cha.nextLine());

          doneCreat = 0;
        }
        System.out.println("------------------------------------------------------------------------------------");
            System.out.println(" " + list.get(0)
                    + " - The " + list.get(1)
                    + " - level " + list.get(2));
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
