package reactiontest;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

class Test5 implements ActionListener, Constants, Runnable{
        ScheduledExecutorService scheduler;
        int score;
        int num;
        int temp_num;
        int attempts;
        String str = "";
        String number = "";
        // Test3Frame elements
        JFrame Test_frame;
        JButton start_test_button;
        JLabel score_label;
        JLabel number_label;
        JButton buttons[][];
        JButton enter_button;
        JTextField text_field;
    Test5(){
        Test_frame = new JFrame ("Test 5");
        // Test_5_frame tuning
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
        number_label = new JLabel("-");
        Font font = new Font("Arial", Font.BOLD, 24);
        number_label.setFont(font);
        Test_frame.add(number_label);
        number_label.setBounds (290, 60, 500, 30);
        enter_button = new JButton ("ENTER");
        Test_frame.add(enter_button);
        enter_button.setBounds (250, 220, 100, 30);
            enter_button.addActionListener(this);
        text_field = new JTextField ();
        Font font_2 = new Font("Arial", Font.BOLD, 24);
        text_field.setFont(font_2);
        Test_frame.add(text_field);
        text_field.setBounds (250, 100, 100, 30);
        buttons = new JButton[10][1];
        int num = 0;
        for (int i = 0; i < 10; i++) {
            for (int u = 0; u < 1; u++) {
                buttons[i][u] = new JButton();
                Test_frame.add(buttons[i][u]);
                buttons[i][u].setBounds (50+i*50, 150+u*50, 50, 50);
                buttons[i][u].setText(Integer.toString(num++));
                buttons[i][u].addActionListener(this);
            }
        }
    }
    void SetEnabledButtonsGrid(boolean status){
        text_field.setEnabled(status);
        enter_button.setEnabled(status);
        for (int i = 0; i < 10; i++) {
            for (int u = 0; u < 1; u++) {
                buttons[i][u].setEnabled(status);
            }
        }
    }
    void RemoveButtonsGrid(){
        Test_frame.remove(number_label);
        Test_frame.remove(text_field);
        Test_frame.remove(enter_button);
        for (int i = 0; i < 10; i++) {
            for (int u = 0; u < 1; u++) {
                Test_frame.remove(buttons[i][u]);
            }
        }
        Test_frame.repaint();
    }
    void Test5Calc(boolean result){
        if (result) score_label.setText("SCORE: "+Integer.toString(++score));
        else
            score_label.setText("SCORE: "+Integer.toString(--score));
    }
    public void run() {
        temp_num = RN.RNum(10);
        if (num == temp_num){
            num = (temp_num%9)+1;
        }else{
            num = temp_num;
        }
        number_label.setText(Integer.toString(num));
        if (attempts == 3) {
            scheduler.shutdown();
            attempts = 0;
            number_label.setText("-");
            SetEnabledButtonsGrid(true);
        } else {
            ++attempts;
            number = number + Integer.toString(num);
            SetEnabledButtonsGrid(false);  
        }
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == start_test_button) {
            if (start_test_button.getText()=="START") {
                MakeButtonsGrid();
                start_test_button.setText("STOP");
                scheduler = Executors.newSingleThreadScheduledExecutor();
                scheduler.scheduleAtFixedRate(this, 0, 1000, TimeUnit.MILLISECONDS);
            } else {
                start_test_button.setText("START");
                RemoveButtonsGrid();
                scheduler.shutdown();
            }
        }
        if (event.getSource() == enter_button) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(this, 0, 1000, TimeUnit.MILLISECONDS);
            if (str.equals(number)) Test5Calc(true);
            else Test5Calc(false);
            //System.out.println(text_field.getText());
            str = "";
            text_field.setText(str);
            number = "";
        }
        if ((event.getSource() != start_test_button)&(event.getSource() != enter_button)) {
            for (int i = 0; i < 10; i++) {
                for (int u = 0; u < 1; u++) {
                    if (event.getSource() == buttons[i][u]){
                        str = str + buttons[i][u].getText();
                        text_field.setText(str);
                    }
                }
            }
        }       
    }
}