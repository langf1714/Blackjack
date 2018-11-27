package blackjack;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
    
public class Blackjack {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("CSC-280 Blackjack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BlackjackPanel panel = new BlackjackPanel();
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
}

class BlackjackPanel extends JPanel {
        
    private ImageIcon image1, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen;
    private JButton draw, stop, tally;
    private JLabel player1, player2, text, pic;
    private int num1, num2, sum1 = 0, sum2 = 0, flag = 0;
    
    public BlackjackPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        image1 = new ImageIcon(getClass().getResource("Empty.gif"));
        
        one = new ImageIcon(getClass().getResource("01.gif"));
        two = new ImageIcon(getClass().getResource("02.gif"));
        three = new ImageIcon(getClass().getResource("03.gif"));
        four = new ImageIcon(getClass().getResource("04.gif"));
        five = new ImageIcon(getClass().getResource("05.gif"));
        six = new ImageIcon(getClass().getResource("06.gif"));
        seven = new ImageIcon(getClass().getResource("07.gif"));
        eight = new ImageIcon(getClass().getResource("08.gif"));
        nine = new ImageIcon(getClass().getResource("09.gif"));
        ten = new ImageIcon(getClass().getResource("10.gif"));
        eleven = new ImageIcon(getClass().getResource("11.gif"));
        twelve = new ImageIcon(getClass().getResource("12.gif"));
        thirteen = new ImageIcon(getClass().getResource("13.gif"));
        
        player1 = new JLabel("Player One's score: " + sum1);
        player2 = new JLabel("Player Two's score: " + sum2);
        text = new JLabel("Player One, it's your turn!");
        
        pic = new JLabel(image1);
        
        draw = new JButton("Draw a Card");
        draw.addActionListener(new ButtonListener());
        stop = new JButton("Stop");
        stop.addActionListener(new StopListener());
        tally = new JButton("Tally Points");
        tally.addActionListener(new TallyListener());
        
        add(player1);
        add(player2);
        add(Box.createRigidArea(new Dimension (0, 20)));
        add(pic);
        add(Box.createVerticalGlue());
        add(Box.createRigidArea(new Dimension (0, 20)));
        add(text);
        add(draw);
        add(stop);
        add(tally);
        
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(400, 400));
        
    }
    
    public class ButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            
        ImageIcon[] array = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen};
            
        if (flag == 0) {
            Random rand = new Random();
            
            num1 = rand.nextInt(13);
            
            for(int i = 0; i < array.length; i++) {
                if (num1 == i) {
                    pic.setIcon(array[i]);
                }
            }
            
            sum1 = sum1 + (num1 + 1);
            player1.setText("Player One's score: " + sum1);
            text.setText("To draw another card, press Draw. To end your turn, press Stop.");
        }
        
        if (flag == 1) {
            Random rand = new Random();
            
            num2 = rand.nextInt(13);
            
            for(int i = 0; i < array.length; i++) {
                if (num2 == i) {
                    pic.setIcon(array[i]);
                }
            }
            
            sum2 = sum2 + (num2 + 1);
            player2.setText("Player Two's score: " + sum2);
            text.setText("To draw another card, press Draw. To end your turn, press Stop.");
        }
        
        }
    }
    
    public class StopListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            
            text.setText("Player Two, it's your turn!");
            pic.setIcon(image1);
            
            flag = flag + 1;
        }
    }
    
    public class TallyListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            
            if (sum1 < 21 && sum2 < 21) {
                text.setText("Player one is the winner!");
            } else {
                text.setText("Player two is the winner!");
            }
            
            if (sum1 > 21 && sum2 > 21) {
                text.setText("The game is a tie!");
            }
            
            if (sum1 > 21 && sum2 <= 21) {
                text.setText("Player two is the winner!");
            }
            
            if (sum2 > 21 && sum1 <= 21) {
                text.setText("Player one is the winner!");
            }
            
        }
    }
}
