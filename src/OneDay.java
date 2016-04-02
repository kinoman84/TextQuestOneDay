import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by kinoman on 01.04.2016.
 */
public class OneDay {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel situationLabel;
    private JPanel buttonsPanel;
    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;
    private Situation currentSituation;
    private Box buttonsBox;
    private Box labelsBox;
    private JLabel labelTime;
    private Calendar time = Calendar.getInstance();

/*
    static {
        SitutionsSet.create();
    }
    */




    public static void main(String[] args) {
        OneDay game = new OneDay();
        game.startGame();
        System.out.println("Меин завершон");
    }

    private void createGUI(){

        time.set(2008,7,9,7,0);
        mainFrame = new JFrame("One Day");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        situationLabel = new JLabel();
        labelTime = new JLabel("Время: " + time.getTime());

        labelsBox = new Box(BoxLayout.Y_AXIS);
        labelsBox.add(situationLabel);
        labelsBox.add(labelTime);

        buttonsBox = new Box(BoxLayout.Y_AXIS);

        mainPanel.add(labelsBox);
        mainPanel.add(buttonsBox);

        insertSituation(SitutionsSet.situations.get(1));

        mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setVisible(true);

    }

    private void insertSituation(Situation situation){

        int count = buttonsBox.getComponentCount();

        if (count > 0){
            for (int i = 0 ; i < count; i++){
                buttonsBox.remove(0);
            }
        }



        currentSituation = situation;

        situationLabel.setText(currentSituation.getDescription());



        if(currentSituation.getOptions() != null) {

            for (Option option : currentSituation.getOptions()) {
                JButton button = new JButton(option.getDescription());
                button.addActionListener(new NextSituationListener(option));
                buttonsBox.add(button);

            }
        } else {
            buttonsBox.add(new JLabel("Нет опций"));
        }
        System.out.println(buttonsBox.getComponentCount());

        //System.out.println(buttonsBox.getComponent(0));
    }



    public void startGame(){
        createGUI();

    }

    public class NextSituationListener implements ActionListener {

        private Situation nextSituation;
        Option option;

        public NextSituationListener (Option option){
            this.nextSituation = option.getAftermath();
            this.option = option;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(nextSituation != currentSituation) //без этой провернки игра зависала(скорее всего из-за рекурсии)
                insertSituation(nextSituation);
                time = option.editTime(time);
                labelTime.setText("Время: " + time.getTime());

        }

    }
}
