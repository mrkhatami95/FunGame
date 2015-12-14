import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by MR on 12/25/2014.
 */
public class FunGame extends JFrame
{
    private JButton button;
    private int number;
    private JPanel panel;
    private Random dice;
    private int point = 1000;

    public int getPoint() {
        return point;
    }

    private void setPoint(int point) {
        this.point = point;
    }

    FunGame()
    {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        button = new JButton("Click Here!");
        dice = new Random();
        panel = new JPanel();
        panel.add(button);
        add(panel);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int i=0,j=1;
                while(i < j)
                {

                    number = 1 + dice.nextInt(6);
                    String guess = JOptionPane.showInputDialog("Enter Your Guess Number : ", null);
                    if ((Integer.parseInt(guess) < 1))
                    {
                        JOptionPane.showMessageDialog(null, "Enter a number Greater 0!");

                    } else if((Integer.parseInt(guess) == number))
                    {
                        JOptionPane.showMessageDialog(null, "you won 1,000 $", "winner!"
                                , JOptionPane.INFORMATION_MESSAGE);
                        point += 1000;
                        setPoint(point);
                        JOptionPane.showMessageDialog(null, getPoint() + "$ !", "Total Point"
                                , JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "loser!", "you lose 100$"
                                , JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Key was : " + number, "Correct Answer!"
                                , JOptionPane.INFORMATION_MESSAGE);
                        point -= 100;
                        setPoint(point);
                        JOptionPane.showMessageDialog(null, getPoint() + "$ !", "Total Point"
                                , JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(getPoint() < 100) {
                        JOptionPane.showMessageDialog(null, "Your Point Isn't Enough!", "Game Over!"
                                , JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                    int a = JOptionPane.showConfirmDialog(null, "Do you want continue ?", "Try Again!"
                            , JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) j++;
                }
            }
        });
    }

    public static void main(String[] args)
    {
        new FunGame().setVisible(true);
    }
}
