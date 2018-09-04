package com.lmucassi.app;

import com.lmucassi.app.controller.Listener;
import com.lmucassi.app.model.Heroes;
import com.lmucassi.app.view.CliView;

public class Swingy {

    public static void main(String[] args) {
        CliView cli = new CliView();
        Heroes hero = new Heroes();
        Listener contListner =  new Listener(cli, hero);

        contListner.playGame();
    }
}
