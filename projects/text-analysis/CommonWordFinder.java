import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Class that is used to find the most common words in a text using
 * the Hashmap, AVL tree, or BST data structures.
 * @author Max Rome UNI: amr2386
 * @version 1.0 December 16, 2022
 */

public class CommonWordFinder {

    public static void main(String[] args) {

        // Check if there is the correct number of arguments
        if (args.length != 2 && args.length != 3) {
            System.err.print("Usage: java CommonWordFinder <filename> <bst|avl|hash> [limit]");
            System.exit(1);
        }

        // Check if the input file exists
        if (!new File(args[0]).exists()) {
            System.err.print("Error: Cannot open file '" + args[0] + "' for input.");
            System.exit(1);
        }

        // Check if the data structure is valid
        if (!(args[1].equals("bst") || args[1].equals("avl") || args[1].equals("hash"))) {
            System.err.println("Error: Invalid data structure '" + args[1] + "' received.");
            System.exit(1);
        }

        // Default the limit to 10
        int limit = 10;

        // If there is a third argument check if it is a valid
        // positive integer for the limit, if not, throw an error
        if (args.length == 3) {
            try {
                limit = Integer.parseInt(args[2]);
                // Checks if argument is positive
                if (Integer.parseInt(args[2]) <= 0) {
                    System.err.println("Error: Invalid limit '" + args[2] + "' received.");
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid limit '" + args[2] + "' received.");
                System.exit(1);
            }
        }

        // Check the data structure in use and assign map to the appropriate data structure
        MyMap<String, Integer> map = null;
        if (args[1].equals("bst")) {
            map = new BSTMap<>();
        } else if (args[1].equals("avl")) {
            map = new AVLTreeMap<>();
        } else if (args[1].equals("hash")) {
            map = new MyHashMap<>();
        }

        // Parse through the file and input words as well as
        // their respective occurrences into the map
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String currentWord = "";
            int c = reader.read();
            int i = 1;
            while (c != -1) {
                char ch = (char) c;
                ch = Character.toLowerCase(ch);

                // If the character is a letter, single quote, or hyphen add it to the current word
                // Only add the hyphen if it's not the first character of the word
                if ((Character.isLetter(ch) || ch == '\'') || (ch == '-' && currentWord.length() > 0)) {
                    currentWord += String.valueOf(ch);
                }

                // If the character is a space or end-of-line, add the current word
                // to the list of words (if it's not empty) and increment the occurrences accordingly
                else if ((ch == ' ' || ch == '\n') && currentWord.length() > 0) {
                    if (map.get(currentWord) != null) {
                        map.put(currentWord, map.get(currentWord) + 1);
                    } else {
                        map.put((currentWord), 1);
                    }
                    currentWord = "";
                }

                // Read the next character
                c = reader.read();
            }

            // Add the final word to the list of words (if it's not empty)
            if (map.get(currentWord) != null) {
                map.put(currentWord, map.get(currentWord) + 1);
            } else {
                map.put((currentWord), 1);
            }
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred reading '" + args[0] + "'.");
            System.exit(1);
        }
        System.out.println("Total unique words: " + map.size());

        // Iterate through the map and add the entries into an array
//        Iterator<Entry<String, Integer>> it = map.iterator();
//        Entry[] array = new Entry[map.size()];
//        int n = 0;
//        while (it.hasNext() && n < map.size()) {
//            array[n] = it.next();
//            n++;
//        }
//
//        // Sort the array in descending order on the number of occurrences
//        // and if two values are the same sort alphabetically
//        Arrays.sort(array, new Comparator<Entry>() {
//            public int compare(Entry e1, Entry e2) {
//                int valueDiff = Integer.compare(value(e2), value(e1));
//                if (valueDiff != 0) {
//                    return valueDiff;
//                }
//                return key(e1).compareTo(key(e2));
//            }
//        });
//
//        // Makes sure the limit does not exceed the map size, so it does not
//        // create an out-of-bounds error when looping in the output
//        if(limit > map.size()) {
//            limit = map.size();
//        }
//
//        // The maximum integers for the length of word and occurrences of a word
//        int maxStringLength = 0;
//        int maxValue = 0;
//
//        // Loops through array to find the maxStringLength and maxValue
//        for(int d = 0; d < limit; d++) {
//
//            // Sets max value of occurrences if it is greater than the previous max
//            if (maxValue < value(array[d])) {
//                maxValue = value(array[d]);
//            }
//
//            // Sets max length of string if it is greater than the previous max
//            if (maxStringLength < key(array[d]).length()) {
//                maxStringLength = key(array[d]).length();
//            }
//        }
//
//        // Output
//        for(int i = 0; i < limit; i++) {
//
//            // Creates spaces before the index
//            for(int y = 0; y < String.valueOf(limit).length() - String.valueOf(i + 1).length(); y++) {
//                System.out.print(" ");
//            }
//            System.out.print((i + 1) + ". " + key(array[i]));
//
//            // Creates spaces after word, adjusting to the max word length
//            for(int s = 0; s < maxStringLength - key(array[i]).length(); s++) {
//                System.out.print(" ");
//            }
//
//            // Creates spaces after word, adjusting to the max value digit length
//            for(int v = 0; v < String.valueOf(maxValue).length() - String.valueOf((value(array[i]))).length() + 1; v++) {
//                System.out.print(" ");
//            }
//            System.out.print(value(array[i]) + System.lineSeparator());
//        }

        // Convert map entries to array for sorting
        Entry[] array = new Entry[map.size()];
        int index = 0;
        Iterator<Entry<String, Integer>> iterator = map.iterator();
        while (iterator.hasNext()) {
            array[index++] = iterator.next();
        }

        // Sort the array in descending order on the number of occurrences
        // and if two values are the same sort alphabetically
        Arrays.sort(array, new Comparator<Entry>() {
            public int compare(Entry e1, Entry e2) {
                int valueDiff = Integer.compare(value(e2), value(e1));
                if (valueDiff != 0) {
                    return valueDiff;
                }
                return key(e1).compareTo(key(e2));
            }
        });

        // Makes sure the limit does not exceed the map size, so it does not
        // create an out-of-bounds error when looping in the output
        if(limit > map.size()) {
            limit = map.size();
        }

        // The maximum integers for the length of word and occurrences of a word
        int maxStringLength = 0;
        int maxValue = 0;

        // Loops through array to find the maxStringLength and maxValue
        for(int d = 0; d < limit; d++) {

            // Sets max value of occurrences if it is greater than the previous max
            if (maxValue < value(array[d])) {
                maxValue = value(array[d]);
            }

            // Sets max length of string if it is greater than the previous max
            if (maxStringLength < key(array[d]).length()) {
                maxStringLength = key(array[d]).length();
            }
        }

        // Output
        for(int i = 0; i < limit; i++) {

            // Creates spaces before the index
            for(int y = 0; y < String.valueOf(limit).length() - String.valueOf(i + 1).length(); y++) {
                System.out.print(" ");
            }
            System.out.print((i + 1) + ". " + key(array[i]));

            // Creates spaces after word, adjusting to the max word length
            for(int s = 0; s < maxStringLength - key(array[i]).length(); s++) {
                System.out.print(" ");
            }

            // Creates spaces after word, adjusting to the max value digit length
            for(int v = 0; v < String.valueOf(maxValue).length() - String.valueOf((value(array[i]))).length() + 1; v++) {
                System.out.print(" ");
            }
            System.out.print(value(array[i]) + System.lineSeparator());
        }
    }

    /**
     * Returns the key element of an entry by turning the entry object
     * into a string and looping through until it finds a comma and then
     * uses the substring method to return the appropriate key.
     * @param e The current entry. Ex. (<hello, 2>)
     * @return key String (the word element) of an entry
     */
    private static String key(Entry e) {
        int last = 0;
        String s = e.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                last = i;
            }
        }
        return s.substring(1, last);
    }

    /**
     * Returns the value element of an entry by turning the entry object
     * into a string and looping through until it finds a space and then
     * uses the substring method to return the appropriate value.
     * @param e The current entry. Ex. (<hello, 2>)
     * @return value integer (occurrences of a word element) of an entry
     */
    private static int value(Entry e) {
        int start = 0;
        String s = e.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                start = i;
            }
        }
        return Integer.parseInt(s.substring(start + 1, s.length() - 1));
    }
}
