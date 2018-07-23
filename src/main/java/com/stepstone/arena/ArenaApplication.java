package com.stepstone.arena;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.List;

//@SpringBootApplication
public class ArenaApplication {

    public static void main(String[] args) {
//		SpringApplication.run(ArenaApplication.class, args);

//		Troll troll = new Troll(100, 20, 50, 30, 200, 30, 5, 200);
//		System.out.println(troll);

        CreatureFactory cf = new CreatureFactory();

        List<Creature> list = cf.randomCreatureList(2);


//		System.out.println(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Creature " + i + ":\n" + list.get(i));
//        }
//
//        Iterator<Creature> iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//
        for (Creature c : list) {
            System.out.println(c);
        }

        Creature creature1 = list.get(0);
        Creature creature2 = list.get(1);

        int rounds = 20;
        while (rounds > 0) {
            FightService.fight(creature1, creature2);
            if (creature1.isAlive() && creature2.isAlive()) {
                FightService.fight(creature2, creature1);
                if (!(creature1.isAlive() && creature2.isAlive())) {
                    break;
                }
            } else {
                break;
            }
            rounds--;
        }

        if (rounds == 0) {
            System.out.println("It's a TIE!");
        } else {
            if (creature1.isAlive()) {
                System.out.println(creature1.getCreatureType() + " is the winner!");
            } else {
                System.out.println(creature2.getCreatureType() + " is the winner!");
            }
        }

        System.out.println(creature1);
        System.out.println(creature2);
    }
}
