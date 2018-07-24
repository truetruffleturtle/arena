package com.stepstone.arena;

import java.util.*;

public class CreatureFactory {

    private static final List<CreatureType> VALUES =
            Collections.unmodifiableList(Arrays.asList(CreatureType.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    Creature generate(CreatureType creatureType, Integer strength, Integer dexterity, Integer initiative, Integer velocity, Integer endurance, Integer numberOfAttacks, Integer numberOfDodges, Integer lifePoints) {
        switch (creatureType) {
            case ELF:
                return new Elf(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
            case ORC:
                return new Orc(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
            case DWARF:
                return new Dwarf(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
            case HUMAN:
                return new Human(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
            case TROLL:
                return new Troll(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
            case HALFLING:
                return new Halfling(strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
        }

        return null;
    }

    Creature randomCreature() {
        Integer strength = random(1, 15);
        Integer dexterity  = random(1, 10);
        Integer initiative  = random(1, 5);
        Integer velocity = random(1, 60);
        Integer endurance = random(1, 3);
        Integer numberOfAttacks = random(1, 5);
        Integer numberOfDodges = random(1, 5);
        Integer lifePoints  = 100;

        return generate(randomCreatureType(), strength, dexterity, initiative, velocity, endurance, numberOfAttacks, numberOfDodges, lifePoints);
    }

    List<Creature> randomCreatureList(int listSize) {
        List<Creature> creaturesList = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            creaturesList.add(randomCreature());
        }

        return creaturesList;
    }

    private CreatureType randomCreatureType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    private int random(int min, int max) {
        return min + RANDOM.nextInt(max + 1 - min);
    }

}
