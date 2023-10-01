package Data_Sttructure_and_Algorithm.Heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {
    public static void main(String[] args) {
        display();
    }

    private static void display() {
        // Initialize min-heap and max-heap
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Use a custom comparator for max-heap

        // Add elements to the max-heap
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);

        // Get the top element of the max-heap
        int maxHeapPeek = maxHeap.peek(); // 5

        // Remove elements from the max-heap (forming a descending sequence)
        while (!maxHeap.isEmpty()) {
            int element = maxHeap.poll();
            System.out.print(element + " ");
        }
        // Output: 5 4 3 2 1

        System.out.println();

        // Check the size of the max-heap
        int maxHeapSize = maxHeap.size(); // 0

        // Check if the max-heap is empty
        boolean isMaxHeapEmpty = maxHeap.isEmpty(); // true

        // Create a min-heap from a list of elements
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));

        // Get the top element of the min-heap
        int minHeapPeek = minHeap.peek(); // 1

        // Remove elements from the min-heap (forming an ascending sequence)
        while (!minHeap.isEmpty()) {
            int element = minHeap.poll();
            System.out.print(element + " ");
        }
        // Output: 1 2 3 4 5

        System.out.println();

        Queue<Integer> queue = new LinkedList<>(Arrays.asList(3, 2, 1, 7, 6, 5, 4));
        MyHeap myHeap = new MyHeap();
        for (int i = 0; i < 7; i++) {
            System.out.print(myHeap.peek(queue) + " ");
        }
    }
}

class MyHeap {
    /* 获取左子节点索引 */
    int left(int i) {
        return 2 * i + 1;
    }

    /* 获取右子节点索引 */
    int right(int i) {
        return 2 * i + 2;
    }

    /* 获取父节点索引 */
    int parent(int i) {
        return (i - 1) / 2; // 向下整除
    }

    /* 访问堆顶元素 */
    int peek(Queue<Integer> topHeap) {
        return topHeap.peek();
    }

    /* 元素入堆 */
    void push(int val, Queue<Integer> topHeap) {
        // 添加节点
        topHeap.add(val);
        // 从底至顶堆化
        siftUp(size() - 1);
    }

    /* 从节点 i 开始，从底至顶堆化 */
    void siftUp(int i, Queue<Integer> topHeap) {
        while (true) {
            // 获取节点 i 的父节点
            int p = parent(i);
            // 当“越过根节点”或“节点无须修复”时，结束堆化
            if (p < 0 || topHeap.get(i) <= topHeap.get(p))
                break;
            // 交换两节点
            swap(i, p);
            // 循环向上堆化
            i = p;
        }
    }

    /* 元素出堆 */
    int pop() {
        // 判空处理
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        // 交换根节点与最右叶节点（即交换首元素与尾元素）
        swap(0, size() - 1);
        // 删除节点
        int val = maxHeap.remove(size() - 1);
        // 从顶至底堆化
        siftDown(0);
        // 返回堆顶元素
        return val;
    }

    /* 从节点 i 开始，从顶至底堆化 */
    void siftDown(int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(ma))
                ma = l;
            if (r < size() && maxHeap.get(r) > maxHeap.get(ma))
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }
}
