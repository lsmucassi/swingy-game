package com.company.view;

import com.company.controller.ContListner;
import com.company.model.Enemies;
import com.company.model.ErrorVal;
import com.company.model.Game;
import com.company.model.Hereos;

import java.util.Random;
import java.util.Scanner;

public class CliView {

    boolean isGameOn = true;
    Game game = new Game();
    Hereos hero = new Hereos();
    Enemies enemy = new Enemies();
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    ContListner cont = new ContListner();
    ErrorVal checkErr = new ErrorVal();

    int heroHealth = hero.getHealth();
    int enemyHealth = enemy.getEnyHealth();
    int hitPoint = hero.getHitPoint();
    int exp = hero.getExp();
    int level = hero.getLevel();
    int stage = game.getStage();
    String eny = enemy.getEnemy(game.getStage());


    public void startSc() {
        System.out.println("  Welcome to the adventure of hereos");
        System.out.println("  You are a warrior in a land of the unknown, the king called you and gave you a task");
        System.out.println("  Over night the King's daughter, the princes was kidnapped by The Mighty Giyante Drago");
        System.out.println("  As a warrior you the King trusts that you will save his daughter ");
        System.out.println("and if you do the king will make you a knight");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t#\tLet's Begin \t#");

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\033[33m $ This is the beginning of your journey to saving the princess\033[0m");
        System.out.println("\t\033[34m \033[34m$ You are now faced with \033[0m" + eny);
    }

    public void endSc() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[34m $ Thank you for playing this game \033[0m");
        System.out.println("\033[34m $ Feel free to come back and play \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void stats() {
        System.out.println("\t\033[34m $ You are at stage: \033[0m" + stage);
        System.out.println("\t\033[34m $ You are level: \033[0m" + level);
        System.out.println("\t\033[34m $ You have hit point: \033[0m" + hitPoint + "\033[34m XP\033[0m");
        System.out.println("\t\033[34m $ Your health is : \033[0m" + heroHealth);
        System.out.println("\t\033[34m $ Your experience is \033[0m" + exp + "\033[34m XP\033[0m");
    }

    public void playExit() {
        System.out.println("\t \033[34m - A : Play again \033[0m");
        System.out.println("\t \033[31m - X : Exit \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");

        String nextIn = in.nextLine();

        if (nextIn.equals("A") || nextIn.equals("a")) {
            System.out.println("A was pressed");
        } else if (nextIn.equals("X") || nextIn.equals("x")) {
            checkErr.checkErr(nextIn);
        } else {
            checkErr.checkErr(nextIn);
        }
    }

    public void checkCom() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\033[32mWhat would you like to do: \033[0m");
        System.out.println("\t\033[34m- 0 : Fight with \033[0m" + eny);
        System.out.println("\t\033[34m- 1 : Go North\033[0m");
        System.out.println("\t\033[34m- 2 : Go East\033[0m");
        System.out.println("\t\033[34m- 3 : Go South\033[0m");
        System.out.println("\t\033[34m- 4 : Go West\033[0m");
        System.out.println("\t\033[34m- 5 : Run\033[0m");
        System.out.println("\t\033[31m- 6 : Exit\033[0m");
    }

    public void checkWin() {

        if (heroHealth < 1) {
            checkErr.checkErr("d");
            playExit();
        } else if (enemyHealth < 1) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\t\t\033[31m#########################################################################\034[0m");
            System.out.println("\t \033[33m$ You defeated \033[0m" + eny +
                    "\033[33m, you can now go to the next level\033[0m \n");
            System.out.println("\t\t\033[31m#########################################################################\034[0m");
            level++;
            stats();
            System.out.println("------------------------------------------------------------------------------------");
            playExit();
        }
    }

    public void gameCli() {

        startSc();

        while (isGameOn) {
            if ( game.getStage() == 0) {
                STAGE:
                while (enemy.getEnyHealth() > 0 ) {
                    checkCom();

                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println(" \033[32m$ Enter command\033[0m");
                    System.out.print("\033[32m $  \033[0m");

                    String nextIn = in.nextLine();

                    if (nextIn.equals("0")) {

                        cont.doFight();

                        int damageMade = cont.getDamageMade();
                        int takenDamage = cont.getTakenDamage();

                        heroHealth = cont.getHeroHealth();
                        enemyHealth = cont.getEnemyHealth();

                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You attacked \033[0m" + eny + "\033[33m with \033[0m" + damageMade);
                        System.out.println("\t \033[33m$ \033[0m" + eny + "\033[33m attacked you back with \033[0m" + takenDamage);
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[34m$ Your health is : \033[0m" + heroHealth);
                        System.out.println("\t \033[34m$ " + eny +"'s health is : \033[0m" + enemyHealth);

                        if (heroHealth <= 0) {
                            System.out.println("------------------------------------------------------------------------------------");
                            System.out.println("\t \033[33m$ You took in a lot of damage from \033[0m" + eny);
                            System.out.println("------------------------------------------------------------------------------------");
                            break ;

                        } else if (enemyHealth <= 0) {
                            hitPoint += 1000;
                            exp += 5;
                            stage++;
                            break;
                        }

                    } else if (nextIn.equals("1")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go North\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("2")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go East\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("3")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go South\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("4")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go West\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("5")) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ Ey Yoh, why are you running ? huh\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");

                    } else if (nextIn.equals("6")){
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You are leaving the world of the unknown\033[0m");
                        System.out.println("------------------------------------------------------------------------------------");
                        stats();
                        isGameOn = false;
                        break ;

                    } else {
                        checkErr.checkErr(nextIn);
                        System.out.println("\t \033[33m $ Try values from 0 - 6 \033[0m");
                        System.out.println("------------------------------------------------------------------------------------");
                        continue STAGE;
                    }
                }
            }
            checkWin();
        }
        endSc();
    }
}