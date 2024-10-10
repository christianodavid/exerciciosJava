package com.coffeemachine.model;

public class CoffeeMachineModel {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachineModel() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        return water >= waterNeed && milk >= milkNeed && beans >= beansNeed && cups > 0;
    }

    public void makeCoffee(int waterNeed, int milkNeed, int beansNeed, int cost) {
        water -= waterNeed;
        milk -= milkNeed;
        beans -= beansNeed;
        cups--;
        money += cost;
    }

    public void fill(int waterAdd, int milkAdd, int beansAdd, int cupsAdd) {
        water += waterAdd;
        milk += milkAdd;
        beans += beansAdd;
        cups += cupsAdd;
    }

    public int takeMoney() {
        int takenMoney = money;
        money = 0;
        return takenMoney;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }
}
