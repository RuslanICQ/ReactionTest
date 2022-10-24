
package reactiontest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Menu implements ActionListener{
        // MenuFrame elements
        JFrame Menu_frame;
        JLabel prog_name_label;  
        JButton test_1_button;
        JLabel test_1_label;  
        JButton test_2_button;
        JLabel test_2_label;  
        JButton test_3_button;
        JLabel test_3_label; 
        JButton test_4_button;
        JLabel test_4_label; 
        JButton test_5_button;
        JLabel test_5_label; 
        JButton test_6_button;
        JLabel test_6_label; 
    Menu(){
        Menu_frame = new JFrame ("Reaction Test Menu");
        // Menu_frame tuning
        Menu_frame.setSize(300,400);
        Menu_frame.setLocationRelativeTo(null); // Frame in the center
        Menu_frame.setResizable(false);
        Menu_frame.setVisible (true);
        Menu_frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        //set layout      
        Menu_frame.setLayout (null);
        prog_name_label = new JLabel("REACTION TESTS");
        Menu_frame.add(prog_name_label);
        prog_name_label.setBounds (90, 5, 250, 30); 
        //add components (Test 1)
        test_1_button = new JButton ("Test 1");
        Menu_frame.add(test_1_button);
        test_1_button.setBounds (10, 40, 100, 30);
            test_1_button.addActionListener(this);
        test_1_label = new JLabel("<html>Find X<br>among O-s.</html>");
        Menu_frame.add(test_1_label);
        test_1_label.setBounds (150, 40, 250, 30);        
        //add components (Test 2)
        test_2_button = new JButton ("Test 2");
        Menu_frame.add(test_2_button);
        test_2_button.setBounds (10, 80, 100, 30);
            test_2_button.addActionListener(this);
        test_2_label = new JLabel("<html>Tap red button<br>as fast as you can.</html>");
        Menu_frame.add(test_2_label);
        test_2_label.setBounds (150, 80, 250, 30); 
        //add components (Test 3)
        test_3_button = new JButton ("Test 3");
        Menu_frame.add(test_3_button);
        test_3_button.setBounds (10, 120, 100, 30);
            test_3_button.addActionListener(this);
        test_3_label = new JLabel("<html>Tap right button<br>as fast as you can.</html>");
        Menu_frame.add(test_3_label);
        test_3_label.setBounds (150, 120, 250, 30);
        //add components (Test 4)
        test_4_button = new JButton ("Test 4");
        Menu_frame.add(test_4_button);
        test_4_button.setBounds (10, 160, 100, 30);
            test_4_button.addActionListener(this);
        test_4_label = new JLabel("<html>Choose right decision<br>as fast as you can.</html>");
        Menu_frame.add(test_4_label);
        test_4_label.setBounds (150, 160, 250, 30);
        //add components (Test 5)
        test_5_button = new JButton ("Test 5");
        Menu_frame.add(test_5_button);
        test_5_button.setBounds (10, 200, 100, 30);
            test_5_button.addActionListener(this);
        test_5_label = new JLabel("<html>Remember and type<br>the right sequence.</html>");
        Menu_frame.add(test_5_label);
        test_5_label.setBounds (150, 200, 250, 30);
        //add components (Test 6)
        test_6_button = new JButton ("Test 6");
        Menu_frame.add(test_6_button);
        test_6_button.setBounds (10, 240, 100, 30);
            test_6_button.addActionListener(this);
        test_6_label = new JLabel("<html>111111111111<br>222222222222</html>");
        Menu_frame.add(test_6_label);
        test_6_label.setBounds (150, 240, 250, 30);
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == test_1_button) {
            new Test1();
        }
        if (event.getSource() == test_2_button) {
            new Test2();
        }
        if (event.getSource() == test_3_button) {
            new Test3();
        }
        if (event.getSource() == test_4_button) {
            new Test4();
        }
        if (event.getSource() == test_5_button) {
            new Test5();
        }
        if (event.getSource() == test_6_button) {
            new Test6();
        }
    }
}
