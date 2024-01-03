package day3_part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class Day3_Part2 {

    private static boolean check(List<List<Integer>> index, ArrayList<String> board, int row, int col) {
        int count = 0;
        System.out.println("----------------");

        System.out.println(board.get(row).charAt(col));
        System.out.println(row);
        System.out.println(col);
        System.out.println("----------------");
        if (matrixCheck(index, board, row - 1, col)) {
            count++;
        } 
        if (matrixCheck(index, board, row + 1, col)) {
            count++;
        }
        if (matrixCheck(index, board, row, col - 1)) {
            count++;
        }
        if (matrixCheck(index, board, row, col + 1)) {
            count++;
        } 
        if (matrixCheck(index, board, row - 1, col - 1)) {
            count++;
        } 
        if (matrixCheck(index, board, row - 1, col + 1)) {
            count++;
        } 
        if (matrixCheck(index, board, row + 1, col - 1)) {
            count++;
        } 
        if (matrixCheck(index, board, row + 1, col + 1)) {
            count++;
        }
        
        if (count > 1) return true;
        return false;
    }

    private static boolean matrixCheck(List<List<Integer>> index, ArrayList<String> board, int row, int col) {
        boolean rCheck = row >= 0 && row < board.size();
        boolean cCheck = col >= 0 && col < board.get(0).length();

        if (!rCheck || !cCheck) {
            return false;
        }

        if (Character.isDigit(board.get(row).charAt(col))) {
            // if (!Character.isDigit(board.get(row).charAt(col + 1))) {
                List<Integer> innerIndex = new ArrayList<>();
                innerIndex.add(row);
                innerIndex.add(col);
                index.add(innerIndex);
            // }
            return true;
        }

        return false;

    }

    private static void findInt(List<Integer> indexPair, ArrayList<String> board, int row, int col) {
        boolean rCheck = row >= 0 && row < board.size();
        boolean cCheck = col >= 0 && col < board.get(0).length();

        if (!rCheck || !cCheck) {
            return;
        }
        
        //find start
        for (int i = col; i >= 0; i--) {
            // System.out.println(row);
            if (!Character.isDigit(board.get(row).charAt(i))) {
                indexPair.add(i + 1);
                break;
            }
        }

        //find end
        for (int i = col; i < board.get(row).length(); i++) {
            if (!Character.isDigit(board.get(row).charAt(i))) {
                indexPair.add(i - 1);
                break;
            }
        }

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
            for (int col = 0; col < data.get(row).length(); col++) {

                if (data.get(row).charAt(col) == '*') {
                    List<List<Integer>> indices = new ArrayList<>();
                    
                    if (check(indices, data, row, col)) {
                        // System.out.println(indices);
                        for (int i = 0; i < indices.size(); i++) {
                            List<Integer> entireNumIdx = new ArrayList<>();
                            int currRow = indices.get(i).get(0);
                            int currCol = indices.get(i).get(1);
                            System.out.println(currRow);
                            System.out.println(currCol);
                            findInt(entireNumIdx, data, currRow, currCol);
                            System.out.println(entireNumIdx);
                            int currNum = Integer.parseInt(data.get(row).substring(entireNumIdx.get(0), entireNumIdx.get(1) + 1));
                            partSum += currNum;
                            System.out.println(partSum);
                        }
                    }

                    // boolean rightNowNum = true;
                    // int endIdx = idx;
                    // int beg = idx;
                    // while (rightNowNum && idx < data.get(row).length() - 1) {
                    //     if (Character.isDigit(data.get(row).charAt(idx + 1))) {
                    //         endIdx += 1;
                    //         idx += 1;
                    //     } else {
                    //         rightNowNum = false;
                    //     }
                    // }

                    // if (check(data, row, beg, endIdx)) {
                    //     int currSum = Integer.parseInt(data.get(row).substring(beg, endIdx + 1));
                    //     // System.out.println(currSum);
                    //     partSum += currSum;
                    // }
                }
            }
        }
        System.out.println(partSum);     
    }
}
