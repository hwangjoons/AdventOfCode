package day3_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3_Part1 {

    private static boolean check(ArrayList<String> board, int row, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (matrixCheck(board, row - 1, i)) {
                return true;
            } else if (matrixCheck(board, row + 1, i)) {
                return true;
            } else if (matrixCheck(board, row, i - 1)) {
                return true;
            } else if (matrixCheck(board, row, i + 1)) {
                return true;
            } else if (matrixCheck(board, row - 1, i - 1)) {
                return true;
            } else if (matrixCheck(board, row - 1, i + 1)) {
                return true;
            } else if (matrixCheck(board, row + 1, i - 1)) {
                return true;
            } else if (matrixCheck(board, row + 1, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matrixCheck(ArrayList<String> board, int row, int col) {
        boolean rCheck = row >= 0 && row < board.size();
        boolean cCheck = col >= 0 && col < board.get(0).length();

        if (!rCheck || !cCheck) {
            return false;
        }

        if (board.get(row).charAt(col) != '.' && !Character.isDigit(board.get(row).charAt(col))) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        String filepath = "AdventOfCode\\src\\file\\day3.txt";
        
        ArrayList<String> data = new ArrayList<>();
        
        int partSum = 0;

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
        // System.out.println(data.size());

        // System.out.println(data.get(0).length());
        for (int row = 0; row < data.size(); row++) {
            for (int idx = 0; idx < data.get(row).length(); idx++) {
                // System.out.println(data.get(row).charAt(idx));
                if (Character.isDigit(data.get(row).charAt(idx))) {
                    boolean rightNowNum = true;
                    int endIdx = idx;
                    int beg = idx;
                    while (rightNowNum && idx < data.get(row).length() - 1) {
                        if (Character.isDigit(data.get(row).charAt(idx + 1))) {
                            endIdx += 1;
                            idx += 1;
                        } else {
                            rightNowNum = false;
                        }
                    }

                    if (check(data, row, beg, endIdx)) {
                        int currSum = Integer.parseInt(data.get(row).substring(beg, endIdx + 1));
                        // System.out.println(currSum);
                        partSum += currSum;
                    }
                }
            }
        }
        System.out.println(partSum);     
    }
}
