package com.lmucassi.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Heroes extends Characters {

    int X, Y;

    public Heroes getHero(String details) {
        Heroes hero = new Heroes();
        String[] detail = details.split(",");

        hero.setName(detail[0]);
        hero.setType(detail[1]);
        hero.setLevel(Integer.parseInt((detail[2])));
        hero.setExp(Integer.parseInt((detail[3])));
        hero.setClan(detail[4]);
        hero.setAttack(Integer.parseInt((detail[5])));
        hero.setDef(Integer.parseInt((detail[5])));
        hero.setWeap1(detail[6]);
        hero.setWeap2(detail[7]);
        hero.setHitPoint(Integer.parseInt(detail[8]));
        return (hero);
    }


}
