import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCombinationSorting {
    public static void main(String[] args) {
        String input = "[ [1,2,4] , [2,3,5] , [3,6] ]";
        List<Integer> combinedList = combineAndSortLinkedLists(input);
        System.out.println(combinedList);
    }

    public static List<Integer> combineAndSortLinkedLists(String input) {
        List<Integer> combinedList = new LinkedList<>();

        // Remove the brackets and split the input by commas
        String[] lists = input.replaceAll("[\\[\\]\\s]", "").split(",");

        // Iterate over each list
        for (String list : lists) {
            String[] numbers = list.split(",");
            // Add each number to the combined list
            for (String number : numbers) {
                combinedList.add(Integer.parseInt(number));
            }
        }

        // Sort the combined list in ascending order
        Collections.sort(combinedList);

        return combinedList;
    }
}

