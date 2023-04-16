import java.io.*;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Scanner;

public class Output {
    private FileOutputStream fileOutputStream;
    private Scanner scanner;
    private FileInputStream fileInputStream;
    private int count=0;
    public Output(){
        try {
            Path file = Path.of("src\\a.txt");
            File file1 = new File(file.toUri());
            fileOutputStream = new FileOutputStream(file1);
            fileInputStream=new FileInputStream(file1);
            scanner =new Scanner(fileInputStream);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void writeToFile (String[] str){

        try {
            write1_2_3(str[0],str[1],str[2]);
            write4(str[3]);
            write5(str[4]);
            write6(str[5]);
            fileOutputStream.write(";".getBytes());
        } catch (IOException e){
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Number of data is incorrect");
            e.printStackTrace();
        }

        this.count++;
    }
    private void write1_2_3(String name, String secondName, String fathername){
        try {
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write("|".getBytes());
            fileOutputStream.write(secondName.getBytes());
            fileOutputStream.write("|".getBytes());
            fileOutputStream.write(fathername.getBytes());
            fileOutputStream.write("|".getBytes());
        } catch (IOException e){
            System.out.println("Name, secondname or fathername format is incorrect");
        }
    }
    private void write4(String birthdayDate){
        try {
            Date birthday = new Date(birthdayDate.replace('.','/'));
            fileOutputStream.write(birthday.toString().getBytes());
            fileOutputStream.write("|".getBytes());
        } catch (IllegalArgumentException e) {
            System.out.println("Birthday format is incorrect");
        } catch (DateTimeException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void write5(String phone){
        try {
            fileOutputStream.write(Integer.parseInt(phone.toString()));
            fileOutputStream.write('|');
        } catch (IOException e){
            System.out.println("Phone number is incorrect");
        } catch (NumberFormatException e){
            System.out.println("Phone number is incorrect");
        }

    }

    private void write6(String gender){
        try{
            Output.gender gender1=null;
            if (gender.equalsIgnoreCase("m")){
                gender1= Output.gender.MALE;
            } else if (gender.equalsIgnoreCase("f")){
                gender1= Output.gender.FEMALE;
            }
            fileOutputStream.write(gender1.toString().getBytes());
            fileOutputStream.write("|".getBytes());
        } catch (IOException e){
            System.out.println("Gender is incorrect");
        } catch (NullPointerException e){
            System.out.println("Gender is incorrect");
        }
    }
    enum gender{
        MALE,
        FEMALE;
    }
    public void close(){
        try {
            fileOutputStream.close();
    } catch (IOException e){

        }
    }

//    public String[] readFile(){
//        StringBuilder[] temp = new StringBuilder[count];
//        try {
//            String file=scanner.nextLine();
//            temp=file.split(";");
//
//
//        } catch (Exception e){
//            System.out.println("Error reading from file");
//        }
//        String[] tempStr =new String[count];
//        for (int i=0;i<count;i++){
//            tempStr[i]=temp[i].toString();
//        }
//        return tempStr;
//    }
}
