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

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.addAll(Arrays.asList(3, 2, 1, 7, 6, 5, 4));
        MyHeap myHeap = new MyHeap();
        for (int i = 0; i < 7; i++) {
            System.out.print(myHeap.peek(queue) + " "); /* 7 for 7 times */
        }

        System.out.println();

        int[] arr = {4, 10, 3, 5, 1, 9, 2};
        Queue<Integer> maxHeap1 = myHeap.buildMaxHeap1(arr);
        Queue<Integer> maxHeap2 = myHeap.buildMaxHeap2(arr);
        Integer peek1 = maxHeap1.peek();
        Integer peek2 = maxHeap2.peek();
        System.out.println(peek1); /* 4 */
        System.out.println(peek2); /* 10 */
        for (Integer heap : maxHeap1) {
            System.out.print(heap + " ");
        }
        System.out.println();
        for (Integer heap : maxHeap2) {
            System.out.print(heap + " ");
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

    /* 从一个数组建立最大堆 */
    Queue<Integer> buildMaxHeap1(int[] arr) {
        Queue<Integer> maxHeap = new LinkedList<>();
        for (int num : arr) {
            maxHeap.add(num);
            siftUp(maxHeap.size() - 1, maxHeap);
        }
        return maxHeap;
    }

    /* 从节点 i 开始，从底至顶堆化 */
    void siftUp(int i, Queue<Integer> topHeap) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (topHeap.peek() <= topHeap.toArray(new Integer[0])[parent]) {
                break;
            }
            swap(i, parent, topHeap);
            i = parent;
        }
    }

    /* 从一个数组建立最大堆 */
    Queue<Integer> buildMaxHeap2(int[] arr) {
        Queue<Integer> maxHeap = new LinkedList<>();
        for (int num : arr) {
            maxHeap.add(num);
        }
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(i, maxHeap);
        }
        return maxHeap;
    }

    /* 从节点 i 开始，从顶至底堆化 */
    void siftDown(int i, Queue<Integer> topHeap) {
        int heapSize = topHeap.size();
        while (true) {
            int maxIndex = i;
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < heapSize && topHeap.toArray(new Integer[0])[leftChild] > topHeap.toArray(new Integer[0])[maxIndex]) {
                maxIndex = leftChild;
            }

            if (rightChild < heapSize && topHeap.toArray(new Integer[0])[rightChild] > topHeap.toArray(new Integer[0])[maxIndex]) {
                maxIndex = rightChild;
            }

            if (maxIndex == i) {
                break;
            }

            swap(i, maxIndex, topHeap);
            i = maxIndex;
        }
    }

    /* 交换堆中的两个元素 */
    void swap(int i, int j, Queue<Integer> topHeap) {
        Integer[] arr = topHeap.toArray(new Integer[0]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        topHeap.clear();
        topHeap.addAll(Arrays.asList(arr));
    }
}
