package com.stepstone.arena;

public class FightService {

    static void fight(Creature attacker, Creature defender) {
        attack(attacker, defender);

        if(defender.isAlive()){
            attack(defender, attacker);
        }
    }

    private static void attack(Creature attacker, Creature defender){
        Integer potentialDamage = attacker.attack();
        defender.dodge(potentialDamage);
    }
}
