package com.stepstone.arena;

public interface Fightable {
    AttackResult attack();
    void dodge(Integer potentialDamage);
}
