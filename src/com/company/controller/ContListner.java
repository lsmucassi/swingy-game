package com.company.controller;

import com.company.model.Enemies;
import com.company.model.Hereos;

import java.util.Random;

public class ContListner {

    Hereos hero = new Hereos();
    Enemies enemy = new Enemies();
    Random rand = new Random();

    int takenDamage;
    int damageMade;
    int heroHealth = hero.getHealth();
    int enemyHealth = enemy.getEnyHealth();

    public void doFight() {

        takenDamage = rand.nextInt(enemy.getEnyDamage());
        damageMade = rand.nextInt(hero.getAttackDamage());

        heroHealth -= takenDamage;
        enemyHealth -= damageMade;

        if (heroHealth <= 1 && enemyHealth <= 1) {
            if (takenDamage < damageMade) {
                heroHealth = 1;
            } else
                enemyHealth = 1;
        }

        if (heroHealth <= 0) { heroHealth  = 0; }
        if (enemyHealth <= 0) { enemyHealth = 0; }

    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getDamageMade() {
        return damageMade;
    }

    public int getTakenDamage() {
        return takenDamage;
    }
}
