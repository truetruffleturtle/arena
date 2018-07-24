package com.stepstone.arena;

public class FightService {

    static final int ROUNDS_LIMIT = 1000;

    static void fight(Creature attacker, Creature defender) {

        System.out.println();
        System.out.println(attacker.getCreatureType() + " & " + defender.getCreatureType() + " start a fight!");
        System.out.println("It will be EPIC!");
        System.out.println();

        int roundsCounter = 1;
        do {
            System.out.println("---------- ROUND " + roundsCounter + "----------");

            attack(attacker, defender);

            if (defender.isAlive()) {
                attack(defender, attacker);
            }

            roundsCounter++;
            System.out.println();
        } while ((attacker.isAlive() && defender.isAlive()) && roundsCounter <= ROUNDS_LIMIT);

        if (roundsCounter > ROUNDS_LIMIT) {
            System.out.println("It's a TIE!");
        } else {
            if (attacker.isAlive()) {
                System.out.println(attacker.getCreatureType() + " is the winner!");
            } else {
                System.out.println(defender.getCreatureType() + " is the winner!");
            }
        }

    }

    private static void attack(Creature attacker, Creature defender) {
        AttackResult result = attacker.attack();
        Integer potentialDamage = result.getPotentialDamage();
        defender.dodge(potentialDamage);
    }
}
