package strings;

public class ReverseWords
{
    public static void main(String[] args) {

        String str = "Java is fun";

        String [] words = str.split(" "); // kidhar space a raha udhar sa split kar do

        System.out.println("words => "+ words);

        StringBuilder result = new StringBuilder();

        for(String word: words)
        {
            StringBuilder sb = new StringBuilder(word);
            result.append(sb.reverse().append(" "));
        }

        System.out.println(result.toString());


    }
}
