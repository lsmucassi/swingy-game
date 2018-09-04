package com.lmucassi.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Characters {

    private int life = 100;
    private int hitPoint = 10;
    private int level = 0;
    private int exp = 0;
    private int attack = 0;
    private int def = 0;
    private String weap1 = "";
    private String weap2 = "";
    private String name = "";
    private String type = "";
    private String clan = "";

    public Characters() {}
}
