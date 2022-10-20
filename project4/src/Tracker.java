import javax.sound.midi.Track;

public class Tracker {
    //Lazy Instantiation of a Singleton
    private static Tracker instance = null;

    //if the trackers wasn't instantiated then instantiate it
    public static Tracker getInstance(){
        if(instance == null){
            instance = new Tracker();
        }
        return instance;
    }

    //Prints out the information of a turn
    public void publish(String days){
        System.out.println(days);
    }
}
