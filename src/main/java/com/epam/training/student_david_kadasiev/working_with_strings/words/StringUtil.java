package com.epam.training.student_david_kadasiev.working_with_strings.words;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;


public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if(words == null || sample == null || sample.isEmpty())
            return 0;

        sample = sample.strip();
        int count = 0;
        for(String word : words){
            word = word.strip();
            if(word.equalsIgnoreCase(sample))
                count++;
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if(text == null || text.isEmpty() || text.matches("[,.;: ?!]*"))
            return null;

        text = text.replaceAll("[,.;: ?!]+", " ");
        text = text.strip();

        StringTokenizer tokens = new StringTokenizer(text, " ");
        String[] str = new String[tokens.countTokens()];
        int i = 0;
        while (tokens.hasMoreTokens()) {
            str[i++] = tokens.nextToken();
        }
        return str;
    }

    public static String convertPath(String path, boolean toWin) {
        if(path == null || path.isEmpty())
            return null;

        if(toWin) {
            if (isCorrectWindowsPath(path)) {
                return path;
            }
            if (!isCorrectUnixPath(path)) {
                return null;
            }
            if (path.startsWith("~")) {
                path = path.replaceFirst("~", "C:\\\\User");
            }
            if (path.startsWith("/")) {
                path = path.replaceFirst("/", "C:\\\\");
            }
            return path.replaceAll("/", "\\\\");
        }else {
            if(isCorrectUnixPath(path)){
                return path;
            }
            if(!isCorrectWindowsPath(path)){
                return null;
            }
            if(path.startsWith("C:\\User")){
                path = path.replaceFirst("C:\\\\User", "~");
            }
            if(path.startsWith("C:\\")){
                path = path.replaceFirst("C:\\\\", "/");
            }
            return path.replaceAll("\\\\", "/");
        }

    }

    private static boolean isCorrectUnixPath(String path){
        return path.matches("^~?[/.\\w\\s]*");
    }

    private static boolean isCorrectWindowsPath(String path){
        return path.matches("^(C:)?[\\\\.\\w\\s]*");
    }

    public static String joinWords(String[] words) {
        if(words == null || words.length == 0)
            return null;

        StringJoiner str = new StringJoiner(", ", "[", "]");

        for(String word : words){
            if(!word.isEmpty()){
                str.add(word);
            }
        }
        return str.toString().equals("[]") ? null : str.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}