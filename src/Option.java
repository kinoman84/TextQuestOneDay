import java.util.Calendar;

/**
 * Created by kinoman on 01.04.2016.
 */
public class Option {

    String description;
    Situation aftermath;
    int minuts;

    public Option(String description, Situation situation, int minuts){
        this.description = description;
        this.aftermath = situation;
        this.minuts = minuts;
    }

    public String getDescription() {
        return description;
    }

    public Situation getAftermath() {
        return aftermath;
    }

    public Calendar editTime(Calendar calendar){
        calendar.add(calendar.MINUTE,minuts);
        return calendar;
    }
}
