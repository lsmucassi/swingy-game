package com.company.model;

public class Hereos {

    int health = 10;
    int attackDamage = 10;
    int level = 1;
    int exp = 0;
    int hitPoint = 0;
    int X, Y;

    //get
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getHealth() {
        return health;
    }

    public int getExp() {
        return exp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    //set
    public void setLevel(int lev) {
        this.level = lev;
    }

    public void setHitPoint(int hp) {
        this.hitPoint = hp;
    }

    public void setHealth(int hlt) {
        this.health = hlt;
    }

    public void setExp(int expr) {
        this.exp = expr;
    }

    public void setAttackDamage(int attDmg) {
        this.attackDamage = attDmg;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }
}
