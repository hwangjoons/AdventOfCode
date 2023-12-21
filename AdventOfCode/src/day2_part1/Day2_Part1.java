package day2_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2_Part1 {
    // private int gameIDTotal = 0;

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

    private static boolean find(int start, int end, String str) {
        System.out.println("--------------------");
        System.out.println(str.charAt(start));
        System.out.println(str.charAt(end));
        System.out.println(str);

        for (int i = start; i <= end; i++) {
            boolean isTwoDigit = false;
            if (Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i + 1))) {
                int twoDigitNum = Integer.parseInt(str.substring(i, i + 2));
                if (str.charAt(i + 3) == 'r') {
                    System.out.println(twoDigitNum);
                    if (twoDigitNum > 12) return false;
                } else if (str.charAt(i + 3) == 'g') {
                    System.out.println(twoDigitNum);
                    if (twoDigitNum > 13) return false;
                } else if (str.charAt(i + 3) == 'b') {
                    System.out.println(twoDigitNum);
                    if (twoDigitNum > 14) return false;
                }
            }
            // if (Character.isDigit(str.charAt(i))) {
            //     if (Character.isDigit(str.charAt(i + 1))) isTwoDigit = true;

            //     if (str.charAt(i + 2) == 'r') {
            //         System.out.println(Character.getNumericValue(str.charAt(i)));
            //         if (Character.getNumericValue(str.charAt(i)) > 12) return false;
            //     } else if (str.charAt(i + 2) == 'g') {
            //         System.out.println(Character.getNumericValue(str.charAt(i)));
            //         if (Character.getNumericValue(str.charAt(i)) > 13) return false;
            //     } else if (str.charAt(i + 2) == 'b') {
            //         System.out.println(Character.getNumericValue(str.charAt(i)));
            //         if (Character.getNumericValue(str.charAt(i)) > 14) return false;
            //     }
            // }
        }
        return true;
    }

    public static void main(String[] args) {
        String filepath = "AdventOfCode\\src\\file\\day2.txt";
        int gameIDTotal = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int idRightIdx = 5;

                //get game id
                for (int i = 5; i <= 7; i++ ) {
                    if (line.charAt(i) == ':') break;
                    idRightIdx = i;
                }
                String currNum = line.substring(5, idRightIdx + 1);
                int currID = Integer.parseInt(currNum);
                

                //starting after ':\'
                int left = idRightIdx + 3;
                int semiColonPos = 0;

                // int rCubeInventory = 12;
                // int gCubeInventory = 13;
                // int bCubeInventory = 14;
                boolean possible = true;

                for (int i = idRightIdx + 3; i < line.length(); i++) {
                    if (line.charAt(i) == ';' || i + 1 == line.length()) {
                        semiColonPos = i;
                        if (!find(left, semiColonPos, line)) {
                            possible = false;
                        };
                        left = i + 2;
                    }
                    // System.out.println(possible);
                    // System.out.println(rCubeInventory);
                    // System.out.println(gCubeInventory);
                    // System.out.println(bCubeInventory);

                    if (!possible) {
                        // System.out.println(gameIDTotal);
                        break;
                    }
                }

                if (possible) gameIDTotal += currID;
            }

            System.out.println(gameIDTotal);
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
