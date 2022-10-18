import java.util.Observable;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

/*
* Implement an Observer through java's library
* We pull data in a String called inputs and push the data to a text file
* Our tracker pulls data and prints it out to the terminal
 */
@Deprecated
public class Logger4 extends Observable {
    //Stores the data for Logger
    private String inputs;
    //Store the file name
    private String filename;

    //Initiate Logger
    public Logger4(String inputs){
        this.inputs = inputs;
    }
    //return the data stored
    public String getInputs(){
        return inputs;
    }
    //pass data to inputs and notify the observer about these new changes
    public void setInputs(String Input){
        this.inputs += Input;
        setChanged();
        notifyObservers();
    }
    //Create a txt.file
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
    //Write to the txt file
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
        //Take data and print it to the terminal
        System.out.println(days);
    }
}