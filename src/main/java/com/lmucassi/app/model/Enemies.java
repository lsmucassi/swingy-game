package com.lmucassi.app.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Random;

@Getter
@Setter

public class Enemies extends Characters{

    public Enemies(){}

    String[] enemies = {"Wolfy", "Spirit Bear", "Slimy Swampy", "Giyante Drago"};
    String eny = enemies[new Random().nextInt(enemies.length)];

}
