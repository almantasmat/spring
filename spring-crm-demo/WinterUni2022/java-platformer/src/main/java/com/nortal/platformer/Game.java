package com.nortal.platformer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {

    public static void main(String[] args) {
        Game game = new Game("src/main/resources/platforms.csv");
        game.run();
    }

    private Integer points = 500;
    private Platform activePlatform;
    private final String gameFile;

    public Game(String gameFile) {
        this.gameFile = gameFile;
    }

    public void run() {
        List<Platform> platforms = readPlatforms();
        int moves = 0;                                                                    //moves that needs for finish a game
     //  System.out.println(platforms);                                                   //just for check what we read from file :)
        Integer lastPlatformIndex = platforms.get(platforms.size()-1).getIndex();        //last platform in List index
        activePlatform = platforms.get(0);
        points = points - platforms.get(0).getCost();
        Integer lastFreePlatformIndex = activePlatform.getIndex();                       //last platform that we unlock
        moves++;
        if ((platforms.get(0).getCost() + platforms.get(1).getCost()) > points){   //We dont have points to move until 2 platform and we canot go back to have more points
            System.out.println("Wrong data");
            moves = 0;
            System.exit(0);
        }
        while (!activePlatform.getIndex().equals(lastPlatformIndex)){
            Platform nextPlatform = findNextPlatform(activePlatform, platforms, lastFreePlatformIndex);
            jumpTo(nextPlatform);
            if (activePlatform.getIndex() > lastFreePlatformIndex){                     //when we unlock new platform change lastFreePlatform index
                lastFreePlatformIndex = activePlatform.getIndex();
            }
            moves++;
        }
        System.out.println("To finish game we need to do " + moves + " moves");

        // TODO: Implement your mighty algorithm and jump to oblivion.

    }

    /**
     * Reads platforms from csv file and returns the as list.
     *
     * @return platforms - Platforms as list
     */
    private List<Platform> readPlatforms() {
        List<Platform> platforms = new ArrayList<>();
        String line;
        String[] values;
        Integer index = 0;
        Integer cost = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(gameFile));
            line = br.readLine();
            line = br.readLine();
            while (line != null){
                values = line.split(", ");
                index = Integer.parseInt(values[0]);
                cost = Integer.parseInt(values[1]);
                Platform platform = new Platform(index, cost);
                platforms.add(platform);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
        return platforms;
    }

   private Platform findNextPlatform(Platform activePlatform, List<Platform> platforms, Integer lastFreePlatformIndex){
       Platform nextPlatform = new Platform();                                      //new emty platform
        int activePlatformIndex = activePlatform.getIndex();
        if(activePlatformIndex < lastFreePlatformIndex){
            nextPlatform = platforms.get(activePlatformIndex + 1);
            points = points + nextPlatform.getCost();
        }else {
            if(points > platforms.get(activePlatformIndex + 1).getCost()){
                nextPlatform = platforms.get(activePlatformIndex + 1);
                points = points - nextPlatform.getCost();
            }else {
                nextPlatform = platforms.get(activePlatformIndex -1);
                points = points + nextPlatform.getCost();
            }
        }

       return nextPlatform;
   }

    /**
     * Invoke this function to jump to next platform.
     *
     * @param platform - Platform that you are going to jump to.
     */
    public void jumpTo(Platform platform) {
        activePlatform = platform;
    }
}
