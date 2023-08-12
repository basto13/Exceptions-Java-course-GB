package seminars;

import java.io.*;

public class sem_2_tasks {
    public static void main(String[] args){
        String filename = "C:\\dev\\GeekBrains\\frontend course\\second term\\Exceptions\\src\\seminars\\file_2_sem.txt";
        try{
            printFile(readFile(filename), filename);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String[][] readFile(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int fileSize = 0;
        String currentLine = reader.readLine();
        while (currentLine != null){
            fileSize ++;
            currentLine = reader.readLine();
        }
        reader.close();

        reader = new BufferedReader(new FileReader(filename));
        String[][] result = new String[fileSize][2];
        for (int i = 0; i < fileSize; i++) {
            String[] temp = reader.readLine().split("=");
            if(!temp[1].equals("?")){
                try{
                    int a = Integer.parseInt(temp[1]);
                }
                catch(Exception e){
                    System.out.println("? in value");
                    e.printStackTrace();
                }
            }
            else{
                temp[1] = String.valueOf(temp[0].length());
            }

            result[i][0] = temp[0];
            result[i][1] = temp[1];
        }
        while (currentLine != null){
            currentLine = reader.readLine();
        }
        reader.close();
        return result;
    }

    public static void printFile(String[][] arr, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < arr.length; i++) {
            StringBuilder temp = new StringBuilder(arr[i][0] + "=" + arr[i][1] +"\n");
            writer.write(temp.toString());
        }
        writer.close();
    }
}
