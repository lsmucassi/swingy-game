package com.lmucassi.app.controller;

import java.util.List;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemies;
import com.lmucassi.app.model.Heroes;
import com.lmucassi.app.view.CliView;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class Process {
    int isFound = 0;
    Heroes hero = new Heroes();
    int mapSize;
    CliView _cli = new CliView();
    private ArrayList<Heroes> heroes;
    ErrException err = new ErrException();

    public Process() {
    }

    //get players.txt
    public Heroes loadPlayer(Heroes h) {

        int er = 1;
        String fileName = "/goinfre/lmucassi/Documents/swingy-game/src/main/java/com/lmucassi/app/players.txt";
        File file = new File(fileName);

        try {
            Scanner inFile = new Scanner(file);

            heroes = listPlayers(inFile, h);
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

        while (er == 1) {
            if (isFound == 1) {
                System.out.println("\t \033[34m - C : Would you like to create a hero \033[0m");
                System.out.println("\t \033[33m - S : Choose from the list [ select a number ] \033[0m");
                System.out.println("\t \033[31m - X : Exit \033[0m");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("\033[32m $ Enter command \033[0m");
                System.out.print("\033[32m $  \033[0m");

                String nextCha = Cha.nextLine();
                if (nextCha.equals("C") || nextCha.equals("c")) {
                    createHero();
                    er = 0;
                } else if (nextCha.equals("S") || nextCha.equals("s")) {
                    System.out.println("\033[32m $ Select a hero number \033[0m");
                    System.out.print("\033[32m $  \033[0m");
                    nextCha = Cha.nextLine();
                    this.hero = heroes.get(Integer.parseInt(nextCha) - 1);
                    er = 0;
                } else if (nextCha.equals("X") || nextCha.equals("x")) {
                    _cli.endSc();
                    err.checkMovErr(nextCha);
                } else {
                    err.checkMovErr(nextCha);
                }
            }
        }
        return this.hero;
    }

    //create hero
    public void createHero() {
        int doneCreat = 1;
        Heroes hero = new Heroes();
        Scanner Cha = new Scanner(System.in);

        //enter Hero characteristics
        while (doneCreat == 1) {
            System.out.println("\n\033[32m $ Enter Hero's Name: \033[0m");
            System.out.print("\033[32m $  \033[0m");
            this.hero.setName(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Class: \033[0m");
            System.out.print("\033[32m $  \033[0m");
            this.hero.setType(Cha.nextLine());

            System.out.println("\n\033[32m $ Enter Hero's Clan : \033[0m");
            System.out.print("\033[32m $  \033[0m");
            this.hero.setClan(Cha.nextLine());
            this.hero.setLevel(0);
            this.hero.setExp(500);
//            this.hero.setWeap1(getWeapon(hero.getLevel()));
//            this.hero.setDef(getDefense(hero.getWeapon()));

            doneCreat = 0;
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(" " + hero.getName()
                + " - The " + hero.getType()
                + " - level " + hero.getClan());
    }

    public String getWeapon(int level) {
        String[] weapons = {"weapon"};

        switch (level) {
            case 1:
                return weapons[0];
        }
        return null;
    }

    public int getAttackStrength(String weapon) {
        switch (weapon) {
            case "weapon":
                return 42;
        }
        return -1;
    }

    //list available players.txt
    public ArrayList<Heroes> listPlayers(Scanner ls, Heroes h) {
        ArrayList<Heroes> players = new ArrayList<>();

        while (ls.hasNext()) {
            players.add(h.getHero(ls.next()));
        }
//        hero = players.txt.get(3);
        for (Heroes count : players) {
            System.out.println((players.indexOf(count) + 1) + " - " + count.getName()
                    + " - The " + count.getType()
                    + " - level " + count.getLevel());
        }
        return players;
    }
}
