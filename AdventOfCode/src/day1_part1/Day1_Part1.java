/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jhwang
 */
public class Day1_Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filePath = "src\\file\\day1.txt";
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                for (int left = 0; left < line.length(); left++) {
                    if (Character.isDigit(line.charAt(left))) {
                        sum += Character.getNumericValue(line.charAt(left)) * 10;
                        break;
                    }
                    
                }
                System.out.println(sum);

                for (int right = line.length() - 1; right >= 0; right--) {
                    if (Character.isDigit(line.charAt(right))) {
                        sum += Character.getNumericValue(line.charAt(right));
                        break;
                    }
                }
                System.out.println(sum);

            }

            System.out.println(sum);
            // return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
