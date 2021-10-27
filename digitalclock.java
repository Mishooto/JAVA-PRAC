import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

//creating a subclass of jframe
public class digitalclock extends JFrame {

    JLabel jlabClock ;
    //reference to the clock thread
    CloqueThread ct;

    public digitalclock(){
        jlabClock = new JLabel("");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlabClock.setFont(new Font("Helvetica",Font.CENTER_BASELINE,80));
        add(jlabClock);
        setSize(1200,1200);
        setLocationRelativeTo(null);
        ct = new CloqueThread(this);
        setVisible(true);
    }

    public static void main(String[] args){
        new digitalclock();
    }
}
