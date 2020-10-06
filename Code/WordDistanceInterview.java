import java.util.ArrayList;
import java.util.Arrays;
public class WordDistanceInterview {
    // Find path of one-character changes from start word to end word in a list of Strings
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog", "com", "cam", "bar"};

        System.out.println(pathExists(words, "hot", "bar"));
    }

    public static boolean pathExists(String[] wordArr, String start, String end) {
        ArrayList<String> words = new ArrayList<String>();
        words.addAll(Arrays.asList(wordArr));

        boolean found = false;

        //ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> fronteer = new ArrayList<String>();
        fronteer.add(start);
        words.remove(start);

        while(!fronteer.isEmpty() && found == false) {
            String currWord = fronteer.remove(0);
            if(currWord.equals(end)) {
                found = true;
                break;
            }
            for(int i=0; i<words.size(); i++) {
                String word = words.get(i);
                if(closeWords(currWord, word)) {
                    words.remove(word);
                    fronteer.add(word);
                }
            }
        }
        return found;
    }

    public static boolean closeWords(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        System.out.println("Words: "+a+", "+b);
        int differences = 0;
        int index = 0;
        while(index < a.length() && index < b.length() && differences < 2) {
            if(a.charAt(index) == b.charAt(index)) {
                index++;
                continue;
            }
            else {
                differences++;
            }
            index++;
        }
        if(differences < 2) {
            System.out.println("CLOSE \n");
        }
        else {
            System.out.println("FAR \n");
        }
        return differences < 2;
    }
}
