package com.stepstone.arena;

public class AttackResult {
    private BodyPart bodyPart;
    private Integer potentialDamage;
    private Integer attackNo;

    public AttackResult(BodyPart bodyPart, Integer potentialDamage, Integer attackNo) {
        this.bodyPart = bodyPart;
        this.potentialDamage = potentialDamage;
        this.attackNo = attackNo;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public Integer getPotentialDamage() {
        return potentialDamage;
    }

    public Integer getAttackNo() {
        return attackNo;
    }
}
