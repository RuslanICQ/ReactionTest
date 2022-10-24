package reactiontest;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Test4 implements ActionListener, Constants, Runnable{
        ScheduledExecutorService scheduler;
        int score;
        int num_1;
        int num_2;
        int oper;
        // Test3Frame elements
        JFrame Test_frame;
        JButton start_test_button;
        JLabel score_label;
        JLabel text_label;
        JButton button_yes;
        JButton button_no;
        Font font;
    Test4(){
        Test_frame = new JFrame ("Test 4");
        // Test_4_frame tuning
        Test_frame.setSize(600,700);
        Test_frame.setLocationRelativeTo(null); // Frame in the center
        Test_frame.setResizable(false);
        Test_frame.setVisible (true);
        Test_frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        //set layout      
        Test_frame.setLayout (null);
        //add components
        start_test_button = new JButton ("START");
        Test_frame.add(start_test_button);
        start_test_button.setBounds (10, 10, 100, 30);
            start_test_button.addActionListener(this);
        score_label = new JLabel("SCORE: "+score);
        Test_frame.add(score_label);
        score_label.setBounds (200, 10, 500, 30);
    }
    void MakeButtonsGrid(){
        button_yes = new JButton ("YES");
        Test_frame.add(button_yes);
        button_yes.setBounds (200, 150, 100, 30);
            button_yes.addActionListener(this);
        button_no = new JButton ("NO");
        Test_frame.add(button_no);
        button_no.setBounds (300, 150, 100, 30);
            button_no.addActionListener(this);
        text_label = new JLabel(".......");
        font = new Font("Arial", Font.BOLD, 24);
        text_label.setFont(font);
        Test_frame.add(text_label);
        text_label.setBounds (250, 100, 500, 30);
    }
    void RemoveButtonsGrid(){
        Test_frame.remove(button_yes);
        Test_frame.remove(button_no);
        Test_frame.remove(text_label);
        Test_frame.repaint();
    }
    void Test4Calc(boolean result){
    if (result){
        if (oper == 0){
            if (num_1>num_2)
                //System.out.println("+");
                score_label.setText("SCORE: "+Integer.toString(++score));
            else
                //System.out.println("-");
                score_label.setText("SCORE: "+Integer.toString(--score));
        }
        if (oper == 1){
            if (num_1<num_2)
                //System.out.println("+");
                score_label.setText("SCORE: "+Integer.toString(++score));
            else
                //System.out.println("-");
                score_label.setText("SCORE: "+Integer.toString(--score));
        } 
    } else {
        if (oper == 0){
            if (num_1>num_2)
                //System.out.println("-");
                score_label.setText("SCORE: "+Integer.toString(--score));
            else
                //System.out.println("+");
                score_label.setText("SCORE: "+Integer.toString(++score));
        }
        if (oper == 1){
            if (num_1<num_2)
                //System.out.println("-");
                score_label.setText("SCORE: "+Integer.toString(--score));
            else
                //System.out.println("+");
                score_label.setText("SCORE: "+Integer.toString(++score));
        } 
    }
    }
    public void run() {
        button_yes.setEnabled(true);
        button_no.setEnabled(true);
        num_1 = RN.RNum(1000);
        num_2 = RN.RNum(1000);
        if (num_1 == num_2){
            num_1 = (num_1%999)+1;
        }
    oper = RN.RNum(2);
    if (oper == 0) 
        text_label.setText(Integer.toString(num_1)+">"+Integer.toString(num_2));
    if (oper == 1) 
        text_label.setText(Integer.toString(num_1)+"<"+Integer.toString(num_2));
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == start_test_button) {
            if (start_test_button.getText()=="START") {
                MakeButtonsGrid();
                start_test_button.setText("STOP");
                scheduler = Executors.newSingleThreadScheduledExecutor();
                scheduler.scheduleAtFixedRate(this, 0, 5000, TimeUnit.MILLISECONDS);
            } else {
                start_test_button.setText("START");
                RemoveButtonsGrid();
                scheduler.shutdown();
                score_label.setText("SCORE: "+Integer.toString(0));
            }
        }
        if (event.getSource() == button_yes){
            button_yes.setEnabled(false);
            button_no.setEnabled(false);
            Test4Calc(true); 
        }
        if (event.getSource() == button_no){
            button_yes.setEnabled(false);
            button_no.setEnabled(false);
            Test4Calc(false); 
        }
    }
}
