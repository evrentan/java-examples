import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaReplaceAllRegexExample {

    public static void main(String[] args) {
        String initialString = "lorem1ipsum2giving3temp4code5examples6every7Wednesday";

        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher matcher = digitPattern.matcher(initialString);
        String newString = matcher.replaceAll(" ");

        String regexLorem = "(lorem)";
        String regexIpsum = "(ipsum)";
        String regexTemp = "(temp)";
        System.out
            .println(
                newString
                    .replaceAll(regexLorem, "I")
                    .replaceAll(regexIpsum, "am")
                    .concat(" with #WeeklytempTips hashtag")
                    .replaceAll(regexTemp, "Java")
                    .concat(" from my Twitter account, @evrn_tan !!!")
            );
    }
}
