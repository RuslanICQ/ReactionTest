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
import javax.swing.JTextField;

class Test6 implements ActionListener, Constants{
        ScheduledExecutorService scheduler;
        int score;
        // Test3Frame elements
        JFrame Test_frame;
        JButton start_test_button;
        JLabel score_label;
    Test6(){
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
   
   
   
   
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == start_test_button) {
            
        }
        if ((event.getSource() != start_test_button)) {
        
        }       
    }
}