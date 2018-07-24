package com.stepstone.arena;

import java.util.*;

public class Creature implements Fightable {
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
    public AttackResult attack() {
        System.out.println(this.creatureType + " attacks!");

        int damage = 0;
        int attackNumber = 0;
        BodyPart bodyPart = null;

        try {
            attackNumber++;

            bodyPart = getRandomBodyPart();
            System.out.println(bodyPart + " hit!");

            damage = this.strength + random(0, 3) + bodyPart.getBonus();
            System.out.println("Successful attack: " + damage + " points potential damage!");

        } catch (AttackFailedException ex) {
            System.out.println("First attack failed. Second attack!");

            if (this.dexterity > random(1, 10)) {
                attackNumber++;

                damage = this.strength + random(0, 3);
                System.out.println("Successful attack: " + damage + " points potential damage!");
            }else {
                System.out.println("Second attack failed");
            }
        }

        AttackResult result = new AttackResult(bodyPart, damage, attackNumber);

        return result;
    }

    @Override
    public void dodge(Integer potentialDamage) {

        if (this.initiative > random(1, 10)) {
            System.out.println(this.creatureType + " successfully dodged!");
            return;
        }

        int damage = (potentialDamage >= this.endurance) ? (potentialDamage - this.endurance) : 0;

        if (damage > 0) {

            this.lifePoints -= damage;

            if(this.lifePoints < 0) {
                this.lifePoints = 0;
            }

        } else {
            System.out.println(this.creatureType + " was not harmed");
        }
        System.out.println(this.creatureType + " has " + this.lifePoints + " life points");

        if (!isAlive()) {
            System.out.println(this.creatureType + " is dead");
        }
    }

    BodyPart getRandomBodyPart() throws AttackFailedException {

        int sum = 0;
        int r = random(1, 100);


        for (BodyPart part : BodyPart.values()) {
            sum += part.getProbability();

            if (sum > r) {
                return part;
            }
        }

        throw new AttackFailedException();

    }

}
