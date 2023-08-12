package seminars;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//        Урок 3. Продвинутая работа с исключениями в Java
//        1. Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
//        Фамилия Имя Отчество датарождения номертелефона пол
//
//        Форматы данных:
//        фамилия, имя, отчество - строки
//        датарождения - строка формата dd.mm.yyyy
//        номертелефона - целое беззнаковое число без форматирования
//        пол - символ латиницей f или m.
//
//        2. Приложение должно проверить введенные данные по количеству.
//        Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
//        что он ввел меньше и больше данных, чем требуется.
//
//        3. Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//        Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//        Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
//        пользователю выведено сообщение с информацией, что именно неверно.
//
//        4. Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//        в него в одну строку должны записаться полученные данные, вида
//              <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//        5. Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//        6. Не забудьте закрыть соединение с файлом.
//
//        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
//        пользователь должен увидеть стектрейс ошибки.

public class sem_3_homework {
    public static String[] getData() throws Exception {
        System.out.println("Insert family name, name and father name, birth date (format dd.mm.yyyy), phone number (without spaces or symbols) and sex(f or m) splited by space");
        String record;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            record = bf.readLine();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            throw new Exception("Mistake in console", e);
        }
        String[] array = record.split(" ");

        if (array.length != 6) {
            throw new Exception("Wrong parameters number. Try again");
        }
        return array;
    }

    public static Person convertData(String[] array) throws Exception {
        String familyName = array[0];
        String name = array[1];
        String fatherName = array[2];
        String date = array[3];
        String phone = array[4];
        String sex = array[5];
        if (!checkDate(date)) {
            throw new RuntimeException("Wrong birth date format");
        }
        if (!checkNumber(phone)) {
            throw new NumberFormatException("Wrong phone");
        }
        if (!checkSex(sex)) {
            throw new RuntimeException("Sex is wrong. You should choose 'f' or 'm'");
        }

        return new Person(familyName, name, fatherName, date, phone, sex);
        //System.out.println(familyName + " " + name + " " + fatherName + " " + date + " " + phoneNumber + " " + sex);
    }

    public static boolean checkDate(String birthDate) throws ParseException {
        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(birthDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkSex(String sex) {
        try {
            return (sex.equalsIgnoreCase("m") | sex.equalsIgnoreCase("f"));
        } catch (Exception e) {
            return false;
        }
    }

    public static void writeData(Person person) throws FileSystemException {
        String fileName = person.familyName.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0) {
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", person.familyName, person.name, person.fatherName, person.date, person.phone, person.sex));
        } catch (IOException e) {
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }
    }

    public static void main(String[] args) throws Exception {
        Person person = convertData(getData());
        writeData(person);
    }
}
