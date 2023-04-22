import java.util.*;

public class CodeSmash_Team_Drie {
    public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        int codeIndex = 0;
        for (int i = 0; i < shoppingCart.size() && codeIndex < codeList.size(); i++) { // Loop stops either when it reaches the end of the list or when it has iterated over all the codes in codeList
            List<String> codeItems = codeList.get(codeIndex); // CodeItems variable is set to be the current sublist that is examined, starting from the first sublist at index 0
            int j = 0;
            while (j < codeItems.size() && (i + j) < shoppingCart.size()) { // CodeItems iterates over the codeItems and the ShoppingCart list stopping either when it reaches the end of one of the lists or when it finds a non-matching item
                if (codeItems.get(j).equals("anything") || codeItems.get(j).equals(shoppingCart.get(i + j))) { // this line check if the CodeItems of 'j' is 'anything' or if the second element in codeItems matches the second element in shoppingCart at index [i+1]. Without this if statement, example 4 in the document would return 0.
                    j++;
                } else {
                    break; // if it's not, then break the process
                }
            }
            if (j == codeItems.size()) { // when the for loop is done, codeIndex will be incremented and 'i' will be equal to i+= j-1, so it can continue going over the other elements of the list.
                codeIndex++;
                i += j - 1;
            }
        }
        if (codeIndex == codeList.size()) {
            return 1; // If secret code list is empty then it is assumed that the buyer is a winner
        }
        return 0;
    }

    public static void main(String[] args) {
        // Why List<List<String>>? Because we have list in a list - [[apple, apple],
        // [banana, anything, banana]]
        List<List<String>> codeList = new ArrayList<>();

        // Adding elements to list that needs to be fulfilled for a person to be a
        // winner
        codeList.add(Arrays.asList("apple", "apple")); // Sublist 1
        codeList.add(Arrays.asList("banana", "anything", "banana")); // Sublist 2
        // if we wanted to, we could have added as many sublists as needed

        // Creating a shoppingCart list
        List<String> shoppingCart = Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana");

        // Printing the output
        System.out.println(checkWinner(codeList, shoppingCart)); // output should be 1
    }
}