package seminars;

//          Tasks
//        1. Реализуйте метод,принимающий в качестве аргументов два целочисленных массива,и возвращающий новый массив,
//        каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//        Если длины массивов не равны,необходимо как-то оповестить пользователя.
//        2. *Реализуйте метод,принимающий в качестве аргументов два целочисленных массива,и возвращающий новый массив,
//        каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
//        Если длины массивов не равны,необходимо как-то оповестить пользователя.
//        Важно:При выполнении метода единственное исключение,которое пользователь может увидеть-RuntimeException,т.е.ваше

import java.util.Arrays;

public class sem_1_homework {

    public static void find_difference(int[] arr_1, int[] arr_2) {
        if (arr_1.length != arr_2.length) {
            throw new RuntimeException("arrays are not equal. Check its' lengths");
        }
        int[] diff_arr = new int[arr_1.length];
        for (int i = 0; i < arr_1.length; i++) {
            diff_arr[i] = arr_1[i] - arr_2[i];
        }
        System.out.println("differentiation of arrays values is " + Arrays.toString(diff_arr));
    }

    public static void find_division(int[] arr_1, int[] arr_2) {
        if (arr_1.length != arr_2.length) {
            throw new RuntimeException("arrays are not equal. Check its' lengths");
        }
        int[] div_arr = new int[arr_1.length];
        for (int i = 0; i < arr_1.length; i++) {
            if (arr_2[i] != 0) {
                div_arr[i] = arr_1[i] / arr_2[i];
            }else{
                throw new RuntimeException("Division on 0 is not possible");
            }
        }
        System.out.println("Divisions for arrays values are " + Arrays.toString(div_arr));
    }

    public static void main(String[] args) {
        int[] arr_1 = new int[]{5, 4, 6};
        int[] arr_2 = new int[]{5, 2, 0};

//        task_1
        find_difference(arr_1, arr_2);

//        task_2
        find_division(arr_1, arr_2);
    }

}
