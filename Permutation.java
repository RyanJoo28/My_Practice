package Data_Structure_and_Algorithm.Backtracking_Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        BacktrackI backtrackI = new BacktrackI();
        BacktrackII backtrackII = new BacktrackII();

        backtrackIDisplay(backtrackI);
        System.out.println();
        backtrackIIDisplay(backtrackII);
    }

    private static void backtrackIIDisplay(BacktrackII backtrackII) {
        int[] nums = {11, 34, 54, 56, 43, 23, 41, 65, 87, 83};
        List<List<Integer> > lists = backtrackII.permutationsII(nums);
        for (List<Integer> list : lists) {
            System.out.print(list + " ");
        }
    }

    private static void backtrackIDisplay(BacktrackI backtrackI) {
        int[] nums = {12, 23, 34, 45, 56, 67, 54, 32, 21, 98};
        List<List<Integer> > lists = backtrackI.permutationsI(nums);
        for (List<Integer> list : lists) {
            System.out.print(list + " ");
        }
    }
}

class BacktrackI {
    /* 回溯算法：全排列 I */
    void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // ... (rest of your code remains the same)
    }

    /* 全排列 I */
    List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }
}

class BacktrackII {
    /* 回溯算法：全排列 II */
    void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // ... (rest of your code remains the same)
    }

    /* 全排列 II */
    List<List<Integer>> permutationsII(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }
}