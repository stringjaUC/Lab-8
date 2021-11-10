import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
class GuessingGame implements ActionListener{
  JTextField userGuess;
  JButton guess;
  JButton playAgain;
  JLabel enterGuess;
  JLabel hotCold;
  JLabel lastGuess;
  Random r = new Random();
  int randomInt; 

  GuessingGame(){
    randomInt = r.nextInt(100) + 1;
    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,130);
    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");
    playAgain = new JButton("Play Again!");
    guess = new JButton("Guess");
    userGuess.addActionListener(this);
    playAgain.addActionListener(this);
    guess.addActionListener(this);
    enterGuess = new JLabel("Enter your guess:");
    hotCold = new JLabel("");
    lastGuess = new JLabel("");
    frame.add(enterGuess);
    frame.add(userGuess);
    frame.add(guess);
    frame.add(hotCold);
    frame.add(lastGuess);
    frame.add(playAgain);
    frame.setVisible(true);
  }
public void actionPerformed(ActionEvent ae) {

    int guess = Integer.parseInt(userGuess.getText());

    if (ae.getActionCommand().equals("Guess")) {
      hotCold.setText("");
      if (guess > randomInt) {
        hotCold.setText("Too high!");
      } else if (guess < randomInt) {
        hotCold.setText("Too low!");
      } else {
        hotCold.setText("You got it!");
      }
      lastGuess.setText("Last guess was " + userGuess.getText());
    }

    else if (ae.getActionCommand().equals("Play Again")) {
      Random r = new Random();
      randomInt = r.nextInt(100) + 1;
      hotCold.setText("");
      lastGuess.setText("");
      enterGuess.setText("Enter your guess:");
      userGuess.setText("");
    }
  
    else{
      hotCold.setText("You pressed Enter. Please press the Game Button.");
    }
    
  }

}




  
