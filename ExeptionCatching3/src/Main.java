public class Main {
    public static void main(String[] args) {
        System.out.println("Enter personal data: ");
        Input createNewPerson = new Input();
        String[] temp=createNewPerson.inputPersonData();
        Output file = new Output();

        file.writeToFile(temp);
        file.close();
    }
}