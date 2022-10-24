package reactiontest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class Test1 extends TimerTask implements ActionListener, Constants{
        int score = 0;
        Timer timer;
        // Test1Frame elements
        JFrame Test_frame;
        JButton start_test_button;
        JLabel score_label;
        JButton buttons[][];
    Test1(){
        Test_frame = new JFrame ("Test 1");
        // Test_1_frame tuning
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
        score_label = new JLabel("SCORE: "+Integer.toString(score));
        Test_frame.add(score_label);
        score_label.setBounds (200, 10, 500, 30);
    }
    void MakeButtonsGrid(){
        buttons = new JButton[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int u = 0; u < rows; u++) {
                buttons[i][u] = new JButton();
                Test_frame.add(buttons[i][u]);
                buttons[i][u].setBounds (50+i*50, 100+u*50, 50, 50);
                buttons[i][u].setText("O");
                buttons[i][u].addActionListener(this);
            }
        }
        buttons[RN.RNum(cols-1)][RN.RNum(rows-1)].setText("X");
    }
    void RefreshButtonsGrid(){
        for (int i = 0; i < cols; i++) {
            for (int u = 0; u < rows; u++) {
                buttons[i][u].setText("O");
            }
        }
        buttons[RN.RNum(cols-1)][RN.RNum(rows-1)].setText("X"); 
    }
    void RemoveButtonsGrid(){
        for (int i = 0; i < cols; i++) {
            for (int u = 0; u < rows; u++) {
                Test_frame.remove(buttons[i][u]);
            }
        }
        Test_frame.repaint();
    }
    void Test1Calc(boolean result){
        if (result) score_label.setText("SCORE: "+Integer.toString(++score));
        else
            score_label.setText("SCORE: "+Integer.toString(--score));
    }
    
    public void run() {
       RefreshButtonsGrid();
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == start_test_button) {
            if (start_test_button.getText()=="START") {
                MakeButtonsGrid();
                score = 0;
                score_label.setText("SCORE: "+Integer.toString(score));
                start_test_button.setText("STOP");
                timer = new Timer();
                timer.schedule(this, 0, 2000);
            } else {
                start_test_button.setText("...");
                start_test_button.setEnabled(false);
                RemoveButtonsGrid();
                timer.cancel();               
            }
        }
        if (event.getSource() != start_test_button) {
            for (int i = 0; i < cols; i++) {
                for (int u = 0; u < rows; u++) {
                    if (event.getSource() == buttons[i][u])
                        if (buttons[i][u].getText() == "X") {
                            Test1Calc(true);
                            buttons[i][u].setText("O");
                        } else Test1Calc(false);
                }
            }
            //RefreshButtonsGrid();
        }       
    }
}

