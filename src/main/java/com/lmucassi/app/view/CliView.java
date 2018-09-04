package com.lmucassi.app.view;

import com.lmucassi.app.model.Heroes;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

@Getter
@Setter

public class CliView {

    public boolean isGameOn = true;
    Scanner in = new Scanner(System.in);

    public CliView() {

    }

    public void printMap(int mapSize, Heroes hero) {
//        clearScreen();
        hero.setX(mapSize / 2);
        hero.setY(mapSize / 2);

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (hero.getX() == x && hero.getY() == y)
                    System.out.print(" &");
                else
                    System.out.print(" .");
            }
            System.out.println();
        }
    }

    public void startSc() {
        System.out.println("\033[32m#########################################################################\033[0m");
        System.out.println("  Welcome to the adventure of heroes");
        System.out.println("  You are a warrior in a land of the unknown, the king called you and gave you a task");
        System.out.println("  Over night the King's daughter, the princes was kidnapped by The Mighty Giyante Drago");
        System.out.println("  As a warrior you the King trusts that you will save his daughter ");
        System.out.println("  and if you do the king will make you a knight");
        System.out.println("\033[32m#########################################################################\033[0m");
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t#\tLet's Begin \t#");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("\t\033[33m $ This is the beginning of your journey to saving the princess\033[0m");
        System.out.println("\t\033[34m \033[34m$ You are now faced with \033[0m" /* + eny */);
    }

    public void endSc() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[34m $ Thank you for playing this game \033[0m");
        System.out.println("\033[34m $ Feel free to come back and play \033[0m");
        System.out.println("------------------------------------------------------------------------------------");
    }
}
