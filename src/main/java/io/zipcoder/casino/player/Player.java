package io.zipcoder.casino.player;

public class Player {
    private int money;
    private String name;
    private int numberOfWins;
    private int numberOfLosses;

    public Player(int money, String name) {
        this.money = money;
        this.name = name;
    }
    public int getMoney() {
        return money;
    }

    public void reduceMoney(int amountToBeReduced) {
        money = money - amountToBeReduced;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public String getName() {
        return name;
    }

}
