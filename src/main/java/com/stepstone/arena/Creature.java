package com.stepstone.arena;

import java.util.Random;

public class Creature implements Fightable{
    private Integer strength;
    private Integer dexterity;
    private Integer initiative;
    private Integer velocity;
    private Integer endurance;
    private Integer numberOfAttacks;
    private Integer numberOfDodges;
    private Integer lifePoints;
    private CreatureType creatureType;

    private Random random = new Random();

    public Integer getStrength() {
        return strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public Integer getNumberOfAttacks() {
        return numberOfAttacks;
    }

    public Integer getNumberOfDodges() {
        return numberOfDodges;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

    public Creature(Integer strength, Integer dexterity, Integer initiative, Integer velocity, Integer endurance, Integer numberOfAttacks, Integer numberOfDodges, Integer lifePoints, CreatureType creatureType) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.initiative = initiative;
        this.velocity = velocity;
        this.endurance = endurance;
        this.numberOfAttacks = numberOfAttacks;
        this.numberOfDodges = numberOfDodges;
        this.lifePoints = lifePoints;
        this.creatureType = creatureType;
    }

    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    private int random(int min, int max) {
        return min + random.nextInt(max + 1 - min);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "strength=" + strength +
                ", dexterity=" + dexterity +
                ", initiative=" + initiative +
                ", velocity=" + velocity +
                ", endurance=" + endurance +
                ", numberOfAttacks=" + numberOfAttacks +
                ", numberOfDodges=" + numberOfDodges +
                ", lifePoints=" + lifePoints +
                ", creatureType=" + creatureType +
                '}';
    }

    @Override
    public Integer attack() {
        if (this.dexterity > random(1, 10)) {
            int dmg = this.strength + random(0, 3);
            System.out.println("Successful attack: " + dmg + " damage!");
            return dmg;
        }
        System.out.println("Attack failed");
        return 0;
    }

    @Override
    public void dodge(Integer potentialDamage) {
        if (this.initiative > random(1, 10)) {
            System.out.println("Successful dodge!");
            return;
        }

        int dmg = potentialDamage - this.endurance;

        if (dmg > 0) {
            this.lifePoints -= dmg;
        }

        if (!isAlive()) {
            System.out.println(this.creatureType + " is dead");
        }
    }
}
