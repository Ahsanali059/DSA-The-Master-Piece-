package strings;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuringChar
{
    public static char getMaxOccuringChar(String str)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : str.toCharArray())
        {
            // getOrDefault ek safe method ha jis mai NullPointer Exception nahi ati
            // agar value mil jati ha tu wo return karta ha agar nahi milti tu default value jo ka is case mai 0 ha
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0) + 1);
        }

        char result = ' ';
        int maxChracterCount = -1;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
        {
            if(entry.getValue() > maxChracterCount)
            {
                maxChracterCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
