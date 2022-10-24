
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
import static reactiontest.Constants.*;


class Test3 implements ActionListener, Constants, Runnable{
        ScheduledExecutorService scheduler;
        int score;
        int num;
        int temp_num;
        // Test3Frame elements
        JFrame Test_frame;
        JButton start_test_button;
        JLabel score_label;
        JLabel number_label;
        JButton buttons[][];
    Test3(){
        Test_frame = new JFrame ("Test 3");
        // Test_3_frame tuning
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
        buttons = new JButton[10][1];
        int num = 0;
        for (int i = 0; i < 10; i++) {
            for (int u = 0; u < 1; u++) {
                buttons[i][u] = new JButton();
                Test_frame.add(buttons[i][u]);
                buttons[i][u].setBounds (50+i*50, 100+u*50, 50, 50);
                buttons[i][u].setText(Integer.toString(num++));
                buttons[i][u].addActionListener(this);
            }
        }
    }
    void RemoveButtonsGrid(){
        Test_frame.remove(number_label);
        for (int i = 0; i < 10; i++) {
            for (int u = 0; u < 1; u++) {
                Test_frame.remove(buttons[i][u]);
            }
        }
        Test_frame.repaint();
    }
    void Test3Calc(boolean result){
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
        if (event.getSource() != start_test_button) {
            for (int i = 0; i < 10; i++) {
                for (int u = 0; u < 1; u++) {
                    if (event.getSource() == buttons[i][u]){
                        if (buttons[i][u].getText().equals(number_label.getText())) {
                            Test3Calc(true);
                        } else {
                            Test3Calc(false);
                        }
                    }
                }
            }
        }       
    }
}