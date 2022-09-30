import java.util.Observable;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class Logger extends Observable {
    private String inputs;
    private String filename;

    public Logger(String inputs){
        this.inputs = inputs;
    }

    public String getInputs(){
        return inputs;
    }
    public void setInputs(String Input){
        this.inputs += Input;
        setChanged();
        notifyObservers();
    }
    public void createFile(int count){
        try {
            File myObj = new File("Logger-"+count+".txt");
            filename = myObj.getName();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void writeFile(String input){
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(input);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Tracker(String days){
        //We returned back info to logger
        System.out.println(days);
    }
}