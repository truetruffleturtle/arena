package com.stepstone.arena;

public class Troll extends Creature {
    public Troll(Integer strength, Integer dexterity, Integer initiative, Integer velocity, Integer endurance, Integer numberOfAttacks, Integer numberOfDodges, Integer lifePoints) {
        super(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints, CreatureType.TROLL);
    }
}
