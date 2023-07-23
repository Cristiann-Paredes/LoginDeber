import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class usuarios {
    public JPanel rootPanel;
    JTextField Ingreusuario;
    private JButton SALIRButton;

    public usuarios(){
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1;
                frame1 = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame1.setVisible(false);

                JFrame frame2 = new JFrame("Login");
                login salir = new login ();
                frame2.setContentPane(salir.rootPanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);

            }
        });
    }
}


