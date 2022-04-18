package com.springDemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    //create an array of strings
    private String[] data = {
            "kruopstumas yra kelias i sekme",
            "kelione yr atlygis",
            "miegas raktas i sekme"
    };
    //    create a random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        //    pick random string from aray
        int index = random.nextInt(data.length);
        String fortune = data[index];
        return fortune;
    }
}
