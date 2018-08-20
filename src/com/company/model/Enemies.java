package com.company.model;

public class Enemies  {

    String[] enemies = {"Wolfy", "Spirit Bear", "Slimy Swampy", "Giyante Drago"};
    int enemyHealth = 10;
    int enemyDamage = 10;
//    String enemy = "";


    public String getEnemy(int stage) {
        return enemies[stage];
    }

    public int getEnyHealth() {
        return enemyHealth;
    }

    public int getEnyDamage() {
        return enemyDamage;
    }

}
