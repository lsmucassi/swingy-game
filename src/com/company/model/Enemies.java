package com.company.model;

public class Enemies  {

    String[] enemies = {"Wolfy", "Spirit Bear", "Slimy Swampy", "Giyante Drago"};
    int enemyHealth = 10;
    int enemyDamage = 10;
//    String enemy = "";

    //set
    public void setEnemy(int stage) {
//        return enemies[stage];
    }

    public void setEnyHealth(int enHlt) {
        this.enemyHealth = enHlt;
    }

    public void setEnyDamage(int enDmg) {
        this.enemyDamage = enDmg;
    }

    //get
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
