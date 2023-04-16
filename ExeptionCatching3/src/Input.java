import java.util.Scanner;

public class Input {
    private Scanner in = new Scanner(System.in);
    public Input(){
    }

    public String[] inputPersonData(){
        String[] splitedStr=new String[6];
        String[] temp=in.nextLine().split(" ");
        try {
            for(int i=0;i<splitedStr.length;i++) {
                splitedStr[i]=temp[i];
            }
            return splitedStr;
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        } catch (NullPointerException e){
            return null;
        }
    }

}
