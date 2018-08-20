package com.company;

import com.company.controller.ContListner;
import com.company.model.Hereos;
import com.company.view.CliView;

public class Main {

    public static void main(String[] args) {
        CliView cli = new CliView();
        Hereos hero = new Hereos();

//        cli.gameCli();

        ContListner contListner =  new ContListner(cli, hero);

        contListner.startGame();
	    /*
	    for each(player) {
            int def = player.armor;
        } */

    }
}
