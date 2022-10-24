package reactiontest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Test2 implements ActionListener, Constants, Runnable{
        ScheduledExecutorService scheduler;
        long start_time;
        long stop_time;
        // Test1Frame elements
        JFrame Test_frame;
        JButton start_test_button;
        JLabel score_label;
        JButton button;
    Test2(){
        Test_frame = new JFrame ("Test 2");
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
        score_label = new JLabel("--- ms");
        Test_frame.add(score_label);
        score_label.setBounds (200, 10, 500, 30);             
    }
    void MakeColoredButton(){
        button = new JButton ("Wait for RED");
        Test_frame.add(button);
        button.setBounds (200, 100, 200, 200);
        button.setBackground(Color.red);
            button.addActionListener(this); 
    }
    void ChangeColor(){
        if (button.getBackground()==Color.red) {
            button.setBackground(Color.yellow);
        } else {
            button.setBackground(Color.red);
            start_time = System.currentTimeMillis();
        }
    }
    void RemoveColoredButton(){
        Test_frame.remove(button);
        Test_frame.repaint();
    }
    
    public void run() {
       ChangeColor();
    }
    
    public void actionPerformed(ActionEvent event) {
    if (event.getSource() == start_test_button) {
            if (start_test_button.getText()=="START") {
                MakeColoredButton();
                start_test_button.setText("STOP");
                scheduler = Executors.newSingleThreadScheduledExecutor();
                scheduler.scheduleAtFixedRate(this, 0, RN.RNum(5)+1, TimeUnit.SECONDS);
            } else {
                start_test_button.setText("START");
                RemoveColoredButton();
                scheduler.shutdown();
            }
    }
    if (event.getSource() == button) {
        if (button.getBackground()==Color.red){
            scheduler.shutdown();
            scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(this, 0, RN.RNum(5)+1, TimeUnit.SECONDS);
            stop_time = System.currentTimeMillis();
            //System.out.println(stop_time-start_time);
            score_label.setText(stop_time-start_time + " ms");
        } else {
            score_label.setText("Do not hurry !!!");
        }
    }
    }
}

