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
//      clearScreen();
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

    public void startSc()  {
        System.out.println("\n\033[32m#########################################################################\033[0m\n");
        System.out.println("  Welcome to the adventure of heroes");
        System.out.println("  You are a warrior in a land of the unknown, You are faced with a lot of monsters in the Valley");
        System.out.println("  It is your duty to protect the village before this monsters attack, day and night you must keep watch and patrol");
        System.out.println("  Fight or Flee, it's all up to you hero");
        System.out.println("  a lot of rewards awaits those eho serves the village right, may the spirit of all heroes be with you\n");
        System.out.println("\033[32m#########################################################################\033[0m");
        System.out.println("\n");
    }

    public void endSc() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\033[34m $ Thank you for playing this game \033[0m");
        System.out.println("\033[34m $ Feel free to come back and play again\033[0m");
        System.out.println("------------------------------------------------------------------------------------");
    }
}
