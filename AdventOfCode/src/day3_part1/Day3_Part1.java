package day3_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3_Part1 {

    private static void check(int row, int start, int end) {

    }
    
    public static void main(String[] args) {
        String filepath = "AdventOfCode\\src\\file\\day3.txt";
        
        ArrayList<String> data = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                data.add(line);
            }
            // System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }  

        for (int row = 0; row < data.size(); row++) {
            for (int idx = 0; idx < data.get(row).length(); idx++) {
                System.out.println(data.get(row).charAt(idx));
                if (Character.isDigit(data.get(row).charAt(idx))) {
                    boolean rightNowNum = true;
                    int endIdx = idx;
                    while (rightNowNum) {
                        if (Character.isDigit(data.get(row).charAt(idx + 1))) {
                            endIdx += 1;
                        } else {
                            rightNowNum = false;
                        }
                    }

                    check(row, idx, endIdx);
                }
            }
        }
        
    }
}
