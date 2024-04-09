package al.cherbourg_photographers.utils;

import java.util.HashSet;
import java.util.Set;

public class StringHandler {
    private static final Set<String> excludedWords = new HashSet<>();

    static {
        excludedWords.add("sous");
        excludedWords.add("sur");
        excludedWords.add("de");
        excludedWords.add("du");
    }
    public static String capitalizeFirstLetters(String text) {
        String[] words = text.split("(?<=[\\s-])|(?=[\\s-])"); // séparation des mots à chaque espace ou tiret

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (excludedWords.contains(word.toLowerCase())){ // si mot fait partie de la liste d'exclusion
                    result.append(word);
                } else if (word.matches("[\\s-]")) { // si mot est espace ou tiret
                    result.append(word); // ajout espace ou tiret
                } else if (word.toLowerCase().startsWith("d'")) { // si mot commence par "d'"
                    result.append("d'").append(Character.toUpperCase(word.charAt(2))).append(word.substring(3));
                } else {
                    String firstLetter = word.substring(0,1).toUpperCase();
                    String otherLetters = word.substring(1);
                    result.append(firstLetter).append(otherLetters);
                }
            }
        }
        return result.toString();
    }
}
