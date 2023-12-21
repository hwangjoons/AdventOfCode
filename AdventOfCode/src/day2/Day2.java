package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author jhwang
 */
// final  class letters {
//     HashMap<Character, HashMap<String, Integer>> lettersMap = new HashMap<>();
    
//     final void 
// }

public class Day2 {

    /**
     * @param args the command line arguments
     */
    // HashMap<Character, HashMap<String, Integer>> lettersMap = new HashMap<>();
    // HashMap<Character, HashMap<String, Integer>> lettersMap = createMap();

    private static HashMap<Character, HashMap<String, Integer>> createMap() {
        HashMap<String, Integer> hmapO = new HashMap<String, Integer>();
        hmapO.put("one", 1);
        
        HashMap<String, Integer> hmapT = new HashMap<String, Integer>();
        hmapT.put("two", 2);
        hmapT.put("three", 3);

        HashMap<String, Integer> hmapF = new HashMap<String, Integer>();
        hmapF.put("four", 4);
        hmapF.put("five", 5);

        HashMap<String, Integer> hmapS = new HashMap<String, Integer>();
        hmapS.put("six", 6);
        hmapS.put("seven", 7);

        HashMap<String, Integer> hmapE = new HashMap<String, Integer>();
        hmapE.put("eight", 8);

        HashMap<String, Integer> hmapN = new HashMap<String, Integer>();
        hmapN.put("nine", 9);

        HashMap<Character, HashMap<String, Integer>> hmap = new HashMap<Character, HashMap<String, Integer>>();
        hmap.put('o', hmapO);
        hmap.put('t', hmapT);
        hmap.put('f', hmapF);
        hmap.put('s', hmapS);
        hmap.put('e', hmapE);
        hmap.put('n', hmapN);
        
        System.out.println(hmap);
        return hmap;
    }
    private static String getSubStringOf5 (String str, int start) {
        return str.substring(start, Math.min(start + 5, str.length()));
    }

    private static boolean checkLetterIsNumber(String numberInLetter, String substr) {
        //two or three & substr = 'tvkmf'
        for (int i = 0; i < numberInLetter.length(); i++) {
            if (numberInLetter.charAt(i) != substr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String filePath = "src\\file\\day1.txt";

        HashMap<Character, HashMap<String, Integer>> lettersMap = createMap();

        System.out.println(lettersMap);
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                for (int left = 0; left < line.length(); left++) {
                    if (Character.isDigit(line.charAt(left))) {
                        sum += Character.getNumericValue(line.charAt(left)) * 10;
                        break;
                    } else if (lettersMap.containsKey(line.charAt(left))) {
                        HashMap<String, Integer> currMap = lettersMap.get(line.charAt(left));
                        boolean isItDone = false;

                        for (HashMap.Entry<String, Integer> entry : currMap.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            String lengthOfSubstr = getSubStringOf5(line, left);
                            System.out.println(key.length());
                            if (lengthOfSubstr.length() >= key.length() && checkLetterIsNumber(key, getSubStringOf5(line, left))) {
                                sum += value * 10;
                                isItDone = true;
                                break;
                            }
                        }

                        if (isItDone) break;
                    }
                }

                for (int right = line.length() - 1; right >= 0; right--) {
                    if (Character.isDigit(line.charAt(right))) {
                        sum += Character.getNumericValue(line.charAt(right));
                        break;
                    } else if (lettersMap.containsKey(line.charAt(right))) {
                        HashMap<String, Integer> currMap = lettersMap.get(line.charAt(right));
                        boolean isItDone = false;

                        for (HashMap.Entry<String, Integer> entry : currMap.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            // System.out.println(key);
                            // System.out.println("here is value");
                            // System.out.println(value);
                            // System.out.println(line);
                            // System.out.println(right);
                            // System.out.println(getSubStringOf5(line, right));
                            String lengthOfSubstr = getSubStringOf5(line, right);
                            if (lengthOfSubstr.length() >= key.length() && checkLetterIsNumber(key, getSubStringOf5(line, right))) {
                                sum += value;
                                isItDone = true;
                                break;
                            }
                        }

                        if (isItDone) break;
                    }
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
