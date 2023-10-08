import java.util.ArrayList;
import java.util.List;

public class AllCombinationsOfSizeK {
  // Function to generate all combinations of size k from a range of numbers 1 to
  // n
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentCombination = new ArrayList<>();
    backtrack(1, n, k, currentCombination, result);
    return result;
  }

  // Backtracking function to generate combinations
  private void backtrack(int start, int n, int k, List<Integer> currentCombination, List<List<Integer>> result) {
    if (currentCombination.size() == k) {
      result.add(new ArrayList<>(currentCombination)); // Add a copy of the current combination
      return;
    }

    for (int i = start; i <= n; i++) {
      currentCombination.add(i);
      backtrack(i + 1, n, k, currentCombination, result);
      currentCombination.remove(currentCombination.size() - 1); // Backtrack by removing the last element
    }
  }

  public static void main(String[] args) {
    AllCombinationsOfSizeK combinationsOfSizeK = new AllCombinationsOfSizeK();
    int n = 4;
    int k = 2;
    List<List<Integer>> combinations = combinationsOfSizeK.combine(n, k);

    // Print the generated combinations
    for (List<Integer> combination : combinations) {
      System.out.println(combination);
    }
  }
}
