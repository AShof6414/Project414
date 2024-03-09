import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arrayForSubset = {1, 3, 5, 0, 11, 17, 9};
        int targetSum = 10;

        System.out.println("Array for subset: " + arrayToString(arrayForSubset));
        System.out.println("Target sum: " + targetSum);
        
        boolean subsetExists = findSubset(arrayForSubset, targetSum);
        if (subsetExists) {
            System.out.println("Subset Exists:");
            System.out.println(subsetToString(findSubsetElements(arrayForSubset, targetSum)));
        } else {
            System.out.println("No subset exists for the target sum.");
        }
    }

    public static boolean findSubset(int[] array, int targetSum) {
        boolean[][] dp = new boolean[array.length + 1][targetSum + 1];
        
        for (int i = 0; i <= array.length; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= array.length; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (j < array[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - array[i - 1]];
                }
            }
        }
        
        return dp[array.length][targetSum];
    }

    public static List<Integer> findSubsetElements(int[] array, int targetSum) {
        List<Integer> subset = new ArrayList<>();
        int i = array.length;
        int j = targetSum;
        
        while (i > 0 && j > 0) {
            if (array[i - 1] <= j && findSubset(array, targetSum)) {
                subset.add(array[i - 1]);
                j -= array[i - 1];
            }
            i--;
        }
        
        return subset;
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String subsetToString(List<Integer> subset) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < subset.size(); i++) {
            sb.append(subset.get(i));
            if (i < subset.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

//OUTPUT
//Array for subset: [1, 3, 5, 0, 11, 17, 9]
//Target sum: 10
//Subset Exists:
//[9, 0, 1]

