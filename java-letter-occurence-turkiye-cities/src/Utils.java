import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Utils {

    public static void printLetterOccurrence(List<String> cities) {
        HashMap<String, Integer> letterOccurrenceMap = new HashMap<>();

        for (String city : cities) {
            for (char letter : city.toLowerCase(new Locale("tr","TR")).toCharArray()) {
                if (letterOccurrenceMap.containsKey(String.valueOf(letter))) {
                    letterOccurrenceMap.put(String.valueOf(letter), letterOccurrenceMap.get(String.valueOf(letter)) + 1);
                } else {
                    letterOccurrenceMap.put(String.valueOf(letter), 1);
                }
            }
        }

        letterOccurrenceMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
