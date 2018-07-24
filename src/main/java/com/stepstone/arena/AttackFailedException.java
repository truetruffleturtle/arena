package com.stepstone.arena;

public class AttackFailedException extends Exception {
    public AttackFailedException() {
        super("Unsuccessful attack");
    }
}
