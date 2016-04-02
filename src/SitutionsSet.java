import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kinoman on 01.04.2016.
 */
public class SitutionsSet {
    public static HashMap<Integer,Situation> situations = new HashMap<Integer,Situation>();

    static {
        //System.out.println("создаюсь");
        situations.put(1, new Situation(1,"Вы открыли глаза, Вы находтесь в своей постели"));
        situations.put(2, new Situation(2,"Поспав ещё некорое время вы проснулись"));
        situations.put(3, new Situation(3,"Вы встали с кровати"));
        situations.put(4, new Situation(4,"Вы сели на кровать"));

        //Вы открыли глаза, Вы находтесь в своей постели
        situations.get(1).addOption(new Option("Поспать ещё немного",situations.get(2),10));
        situations.get(1).addOption(new Option("Встать с кровати",situations.get(3),1));
        situations.get(1).addOption(new Option("Сесть на кровать",situations.get(4),1));

        //Поспав ещё некорое время вы проснулись
        situations.get(2).addOption(situations.get(1).getOptions().get(0));
        situations.get(2).addOption(situations.get(1).getOptions().get(1));
        situations.get(2).addOption(situations.get(1).getOptions().get(2));

    }
}
