import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by kinoman on 01.04.2016.
 */
public class Situation {
    int id;
    String description;
    ArrayList<Option> options;


    public Situation(int id, String description){
        this.id = id;
        this.description = description;

    }

    public void addOption(Option option){
        if (options == null)
            options = new ArrayList<Option>();
        options.add(option);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Option> getOptions(){
        return options;
    }


}
