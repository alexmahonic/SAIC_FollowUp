import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CountCombination {

    private int countCombination(List<Character> list) {
        int vowel_count = 0;
        int consonant_count = 0;
        HashSet<Character> vowel_set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        List<Character> vowel = new ArrayList<>();
        List<Character> consonant = new ArrayList<>();
        // count the total number of vowel chars and consonant chas, and split them to two separate arraylists
        for (Character ch : list) {
            if (vowel_set.contains(ch)) {
                vowel_count++;
                vowel.add(ch);
            } else {
                consonant_count++;
                consonant.add(ch);
            }
        }
        if (vowel_count > consonant_count || consonant_count - vowel_count > 1)
            return 0;
        return count(vowel) * count(consonant);

    }

    // Use DFS recursively to count the different combination with starting word list.get(i) without duplication
    // So I don't need to deduct the formula of the problem
    private int count(List<Character> list) {
        if (list.size() == 1)
            return 1;
        int res = 0;
        HashSet<Character> visited = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (!visited.contains(list.get(i))) {
                visited.add(list.get(i));
                List<Character> sub = new ArrayList<>();
                sub.addAll(list.subList(0, i));
                sub.addAll(list.subList(i + 1, list.size()));
                res += count(sub);
            }
        }
        return res;
    }

    public static void main(String[] arg) {
        Character[] l1 = new Character[]{'A', 'A', 'B', 'B', 'C'};
        List<Character> list1 = Arrays.asList(l1);

        Character[] l2 = new Character[]{'A', 'A', 'B', 'D', 'C'};
        List<Character> list2 = Arrays.asList(l2);

        Character[] l3 = new Character[]{'A', 'E', 'B', 'C', 'D'};
        List<Character> list3 = Arrays.asList(l3);
        CountCombination c = new CountCombination();

        System.out.println(c.countCombination(list1));
        System.out.println(c.countCombination(list2));
        System.out.println(c.countCombination(list3));
    }
}
