package com.stepstone.arena;

public enum BodyPart {
    HEAD(5, 3),
    LEFT_ARM(10, 1),
    RIGHT_ARM(10, 1),
    TRUNK(30, 0),
    LEFT_LEG(5, 2),
    RIGHT_LEG(5, 2);

    int probability;
    int bonus;

    BodyPart(int probability, int bonus) {
        this.probability = probability;
        this.bonus = bonus;
    }

    public int getProbability()
    {
        return probability;
    }

    public int getBonus()
    {
        return bonus;
    }
}
