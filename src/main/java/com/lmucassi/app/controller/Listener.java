package com.lmucassi.app.controller;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Enemies;
import com.lmucassi.app.model.Heroes;
import com.lmucassi.app.view.CliView;
import java.util.Scanner;

public class Listener {

    CliView _cli ;
    Heroes _hero ;
    Enemies enemy = new Enemies();
    Process pro = new Process();
    ErrException err = new ErrException();

    String eny = enemy.getEny();
    Scanner in = new Scanner(System.in);

    public Listener(CliView cli, Heroes hero) {
        this._cli = cli;
        this._hero = hero;

    }

    public void playGame() {
        _cli.startSc();
        startPlay();
        pro.loadPlayer(_hero);
        gameCli(enemy, _hero);
    }

    public void getStats() {
//      System.out.println("\t\033[34m $ You are at stage: \033[0m" + _hero.getStage());
        System.out.println("\t\033[34m $ You are level: \033[0m"   + _hero.getLevel());
        System.out.println("\t\033[34m $ You have hit point: \033[0m" + _hero.getHitPoint() + "\033[34m XP\033[0m" );
        System.out.println("\t\033[34m $ Your health is : \033[0m" + _hero.getLife());
        System.out.println("\t\033[34m $ Your experience is \033[0m" + _hero.getExp() + "\033[34m XP\033[0m");
    }

    public void startPlay() {
        int er = 1;

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t \033[34m - A : Play  \033[0m");
        System.out.println("\t \033[31m - X : Exit \033[0m");
        System.out.println("------------------------------------------------------------------------------------");


        Scanner Cha = new Scanner(System.in);

        while (er == 1) {
            System.out.println("\033[32m $ Enter command \033[0m");
            System.out.print("\033[32m $  \033[0m");
            String nextCha = Cha.nextLine();
            if (nextCha.equals("A") || nextCha.equals("a")) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("\t#\tLet's Begin \t#");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("\033[34m \033[34m$ Loading players \033[0m \n" /* + eny */);
                er = 0;
            } else if (nextCha.equals("X") || nextCha.equals("x")) {
                _cli.endSc();
                err.checkMovErr(nextCha);
            } else {
                err.checkMovErr(nextCha);
            }
        }
    }

    public void playExit() {
        System.out.println("\t \033[34m - A : Play again  \033[0m");
        System.out.println("\t \033[31m - X : Exit \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[32m $ Enter command \033[0m");
        System.out.print("\033[32m $  \033[0m");

        String nextIn = in.nextLine();

        if (nextIn.equals("A") || nextIn.equals("a")) {
            err.checkMovErr(nextIn);
        } else if (nextIn.equals("X") || nextIn.equals("x")) {
            err.checkMovErr(nextIn);
        } else {
            err.checkMovErr(nextIn);
        }
    }

    public void checkCom() {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\033[32mWhat would you like to do: \033[0m");
        System.out.println("\t\033[34m- 0 : Fight with \033[0m" /* + eny */);
        System.out.println("\t\033[34m- 1 : Go North\033[0m");
        System.out.println("\t\033[34m- 2 : Go East\033[0m");
        System.out.println("\t\033[34m- 3 : Go South\033[0m");
        System.out.println("\t\033[34m- 4 : Go West\033[0m");
        System.out.println("\t\033[34m- 5 : Run\033[0m");
        System.out.println("\t\033[31m- 6 : Exit\033[0m");

        /* System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You attacked \033[0m" + eny + "\033[33m with \033[0m" + damageMade);
                        System.out.println("\t \033[33m$ \033[0m" + eny + "\033[33m attacked you back with \033[0m" + takenDamage);
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[34m$ Your health is : \033[0m" + heroHealth);
                        System.out.println("\t \033[34m$ " + eny +"'s health is : \033[0m" + enemyHealth);
                         System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("\t \033[33m$ You chose to go North\033[0m");
                        System.out.println("------------------------------------------------------------------------------------"); */
    }

    public void doFight(Heroes _hero, CliView c) {
        c.printMap((2-1)*5+10-(2%2), _hero);
    }

    public void gameCli(Enemies enemy, Heroes hero) {
        System.out.println("\033[33m $ This is the beginning of your journey to" +
                " saving the princess\033[0m");

        Start:
        while (true) {
            while (this._hero.getX() < pro.getMapSize() && this._hero.getX() >= 0
                    && this._hero.getY() < pro.getMapSize() && this._hero.getY() >= 0) {

            }
        }
    }
}
