package seminars;

import java.io.FileNotFoundException;
import java.util.Scanner;

// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
// необходимо повторно запросить у пользователя ввод данных.
// 2. Если необходимо, исправьте данный код
// (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
// 3. Дан следующий код, исправьте его там, где требуется
// (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
// 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class sem_2_homework {

////    Task 1
//    public static Float IMPOSSIBLE_VALUE = Float.MIN_VALUE;
//
//    public static Float getFloat(String userInput) {
//        try {
//            return Float.parseFloat(userInput);
//        } catch (Exception e) {
//            return IMPOSSIBLE_VALUE;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        Float userFloat = IMPOSSIBLE_VALUE;
//        while (userFloat == IMPOSSIBLE_VALUE) {
//            System.out.println("Please input float ");
//            userFloat = getFloat(scanner.nextLine());
//            if (userFloat == IMPOSSIBLE_VALUE) {
//                System.out.println("You have entered crap, please try again");
//            }
//            else{System.out.println("Your float input is " + userFloat);}
//
//        }
//        scanner.close();
//    }

//    task 2

//    public static void main(String[] args) {
//        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        try {
//            int d = 0;
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching Arithmetic exception: " + e);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Catching ArrayIndexOutOfBoundsException: " + e);
//        } catch (Exception e) {
//            System.out.println("Catching generic exception: " + e);
//        }
//    }

//    task 3
//    public static void main(String[] args) throws Exception {
//        try {
//            int a = 90;
//            int b = 3;
//            System.out.println(a / b);
//            printSum(23, 234);
//            int[] abc = { 1, 2 };
//            abc[3] = 9;
//        } catch (NullPointerException ex) {
//            System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//            System.out.println("Массив выходит за пределы своего размера!");
//        }
//        catch (Throwable ex) {
//            System.out.println("Что-то пошло не так...");
//        }
//    }
//    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//        System.out.println(a + b);
//    }

//    task 4
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert something: ");
        String input = new String(scan.nextLine());
        if (input.length() != 0){
            System.out.println("Your input is " + input);
        }
        else{
            throw new RuntimeException("Input is empty");
        }
        scan.close();
    }
}


