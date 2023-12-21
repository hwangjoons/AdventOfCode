package day2_part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2_Part2 {
    private static void identifyRGB(int currDigit, int currLetter, int redInventory, int greenInventory, int blueInventory) {
        
        if (currLetter == 'r') {
            redInventory -= currDigit;
        } 

        if (currLetter == 'g') {
            greenInventory -= currDigit;
        }

        if (currLetter == 'b') {
            blueInventory -= currDigit;
        }
    }

    private static void check(String[] currentRound, int[] powers) {
        powers[0] = 1;
    }

    public static void main(String[] args) {
        String filepath = "AdventOfCode\\src\\file\\day2.txt";
        int powerSum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] game = line.split(":");
                String[] gameName = game[0].split(" ");
                int gameID = Integer.parseInt(gameName[1]);

                String[] gameRounds = game[1].split(";");
                
                int redPower = Integer.MAX_VALUE;
                int greenPower = Integer.MAX_VALUE;
                int bluePower = Integer.MAX_VALUE;
                
                int[] powers = { redPower, greenPower, bluePower};

                check(gameRounds, powers);
                System.out.println(powers[0]);

                // for (String gameRound : gameRounds) {
                //     String[] roundInfo = gameRound.split(",");
                    
                //     for (String rounds : roundInfo) {
                //         String[] roundDetail = rounds.split(" ");
                //         // int cubeNum = Integer.parseInt(roundDetail[0]);
                //         String cubeNum = roundDetail[1];
                //         String cubeColor = roundDetail[2];
                //         System.out.println(cubeColor);
                //     }
                // }
            }

            // System.out.println(gameIDTotal);
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
