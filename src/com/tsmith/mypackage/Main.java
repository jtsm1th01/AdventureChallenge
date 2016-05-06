package com.tsmith.mypackage;

import java.util.*;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You're sitting in front of your computer learning Java."));
        locations.put(1, new Location(1, "You're standing in the front of a small brick building."));
        locations.put(2, new Location(2, "You're at the top of a hill."));
        locations.put(3, new Location(3, "You're inside a well house for a small spring."));
        locations.put(4, new Location(4, "You're in a valley beside a stream."));
        locations.put(5, new Location(5, "You're in the forest."));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("Q", 0);

        Map<String, String> altDirection = new HashMap<>();
        altDirection.put("NORTH", "N");
        altDirection.put("SOUTH", "S");
        altDirection.put("EAST", "E");
        altDirection.put("WEST", "W");
        altDirection.put("QUIT", "Q");

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc==0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Avail exits: ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length()>1) {
                String[] words = direction.split(" ");

                for(String word : words) {
                    if (altDirection.containsKey(word)) {
                        direction = altDirection.get(word);
                    }
                }
            }
            if(exits.containsKey(direction)) {
                    loc = exits.get(direction);
                } else {
                    System.out.println("You can't go that way.");
                }
            }
        }
    }

