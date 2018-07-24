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
//        for (Creature c : list) {
//            System.out.println(c);
//        }

        Creature creature1 = list.get(0);
        Creature creature2 = list.get(1);

        System.out.println(creature1);
        System.out.println(creature2);

        FightService.fight(creature1, creature2);

        System.out.println(creature1);
        System.out.println(creature2);
    }
}
