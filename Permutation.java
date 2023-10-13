package Data_Sttructure_and_Algorithm.Backtracking_Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        backtrackIDisplay();
        System.out.println();
        backtrackIIDisplay();
    }

    private static void backtrackIIDisplay() {
        BacktrackII backtrackII = new BacktrackII();
        int[] nums = {11, 34, 54, 56, 43, 23, 41, 65, 87, 83};
        List<List<Integer>> lists = backtrackII.permutationsII(nums);
        for (List<Integer> list : lists) {
            System.out.print(list + " ");
        }
    }

    private static void backtrackIDisplay() {
        BacktrackI backtrackI = new BacktrackI();
        int[] nums = {12, 23, 34, 45, 56, 67, 54, 32, 21, 98};
        List<List<Integer>> lists = backtrackI.permutationsI(nums);
        for (List<Integer> list : lists) {
            System.out.print(list + " ");
        }
    }
}

class BacktrackI {
    /* 回溯算法：全排列 I */
    void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素且不允许重复选择相等元素
            if (!selected[i]) {
                // 尝试：做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
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
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        // 遍历所有选择
        Set<Integer> duplicated = new HashSet<Integer>();
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素 且 不允许重复选择相等元素
            if (!selected[i] && !duplicated.contains(choice)) {
                // 尝试：做出选择，更新状态
                duplicated.add(choice); // 记录选择过的元素值
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /* 全排列 II */
    List<List<Integer>> permutationsII(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }
}