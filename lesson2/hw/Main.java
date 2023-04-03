/*
3.	Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */

package lesson2.hw;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
        int[] Arr = { 9, 4, 8, 3, 12, 4, 10 };
        // сортируем массиа по возрастанию методом пирамидальной кучи
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(Arr));

        // сортируем методов пирамидальной сортировки (кучи)
        heapSort(Arr);

        System.out.println("Итоговый массив:");
        System.out.println(Arrays.toString(Arr));
    }

    // для i-го элемента (родителя) определить индекс левого потомка
    private static int leftChildIndex(int i) {
        return (2 * i + 1);
    }

    // для i-го элемента (родителя) определить индекс правого потомка
    private static int rightChildIndex(int i) {
        return (2 * i + 2);
    }

    // перестановка элементов массива с индексами i и j
    private static void change(int[] Arr, int i, int j) {
        int swap = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = swap;
    }

    // рекурсивный алгоритм heapify-down.
    // упорядочивание элементов-потомов по правилам Max-кучи (родитель больше
    // предков)
    private static void heapify(int[] Arr, int i, int size) {
        // получить левый и правый потомки узла с индексом `i`
        int left = leftChildIndex(i);
        int right = rightChildIndex(i);
        int largest = i;

        // из родителя и предков находим наибольший и ставим на место родителя
        if (left < size && Arr[left] > Arr[i])
            largest = left;
        if (right < size && Arr[right] > Arr[largest])
            largest = right;

        // если потомок больше родителя, то перестановка и рекурсивно проверка
        // низлежачего потомка
        if (largest != i) {
            change(Arr, i, largest);
            heapify(Arr, largest, size);
        }
    }

    // функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int popElement(int[] Arr, int size) {
        // если в куче нет элементов
        if (size <= 0) {
            return -1;
        }
        int top = Arr[0];

        // заменяем корень кучи последним элементом массива
        Arr[0] = Arr[size - 1];
        // вызовите heapify-down на корневом узле
        heapify(Arr, 0, size - 1);
        return top;
    }

    // функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void heapSort(int[] Arr) {
        // строим приоритетную очередь и инициализируем ее заданным массивом
        int n = Arr.length;

        // строим кучу: вызываем heapify, начиная с последнего внутреннего
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(Arr, i, n);
            i--;
        }

        // несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            Arr[n - 1] = popElement(Arr, n);
            n--;
        }
    }
}
