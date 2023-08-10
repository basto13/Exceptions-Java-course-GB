package seminars;

//2. Реализуйте метод, принимающий целочисл. массив.
//Если длина массива больше определенного значения, то возвращается -1 в качестве кода ошибки.
// Иначе возвращается длина массива.

//3. Метод принимает аргументом целочисл. двумерный массив
//Посчитать сумму всех элементов массива
//При этом 2 ограничения: метод должен работать только с квадратными массивами (кол-во строк == кол-во столбцов)
//в каждой ячейке значение равно 0 или 1
//При нарушении ограничений - RuntimeException с сообщением об ошибке.

public class sem_1_tasks {
    public static void main(String[] args) {
//        task 1
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Integer [] array = new Integer[]{1, null, 3, 4, 5};
//        System.out.println(sizeArray(arr, 3));

//        task 2
//        printException(array_task_2(arr, 3, 3));

//        task 3
        int[][] arr_3 = new int[][]{{0,1,1},{0,1,0},{0,1,0}};
        System.out.println("Task 3 result is " + array_task_3(arr_3));

//        task 4
        checkArray(array);
    }

    //    task 1 functions
    public static int sizeArray(int[] arr, int min) {
        int a = arr.length;
        if (a < min) {
            return -1;
        }
        return a;
    }

    //    task 2 functions
    public static int array_task_2(int[] arr, int value, int min) {
        if (arr == null) {
            return -3;
        }
        if (arr.length < min) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -2;
    }

    public static void printException(int code) {
        switch (code) {
            case -3:
                System.out.println("null result");
                break;
            case -2:
                System.out.println("no match found");
                break;
            case -1:
                System.out.println("array is too short");
                break;
        }
        System.out.println("value's index is " + code);
    }

    //    task 3 functions

    public static int array_task_3(int[][] arr) {
        if (arr.length != arr[0].length) {
            throw new RuntimeException("Array is not square");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    throw new RuntimeException("Array has wrong value");
                }
                sum = sum + arr[i][j];
            }
        }
        return sum;
    }

    public static void checkArray(Integer[] arr){
        String err_index = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null){
                err_index = err_index + " " + i;
            }
        }
        if (err_index != ""){
            throw new RuntimeException("Indexes with null are " + err_index);
        }
        else{
            System.out.println("Array has no null value");
        }
    }
}


