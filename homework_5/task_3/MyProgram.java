/*
Задача №3
=========================================================
*Реализовать алгоритм пирамидальной сортировки (HeapSort)
=========================================================
*/

package homework_5.task_3;

import java.util.Arrays;

public class MyProgram {
    public int[] heapSort(int[] arr) {
        int size = arr.length;
        int[] sorted = Arrays.copyOf(arr, size);
        for (int i = size / 2 - 1; i >= 0; i--) {
            this.heapify(sorted, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = sorted[0];
            sorted[0] = sorted[i];
            sorted[i] = temp;
            this.heapify(sorted, i, 0);
        }
        return sorted;
    }

    public void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            this.heapify(arr, size, largest);
        }
    }

    public void run() {
        int[] arr = {32, 12, 6, 64, 2, 1};
        int[] sortedList = this.heapSort(arr);
        System.out.println(Arrays.toString(sortedList));
    }

    public static void main(String[] args) {
        MyProgram program = new MyProgram();
        program.run();
    }
}