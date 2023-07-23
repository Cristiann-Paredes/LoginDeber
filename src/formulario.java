import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class formulario {

    public JPanel rootPanel;
    private JTextField ingrenombre;
    private JPasswordField contrase;
    private JButton registar;
    private JButton iniciar;
    private String User;
    private String passw;
    private JTextField mensaje;

    public formulario() {
        registar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datos user = new datos();
                User = ingrenombre.getText();
                user.setUsuario(User);
                passw = String.valueOf(contrase.getPassword());
                user.setContrase(passw);

                try {
                    FileOutputStream nombreF = new FileOutputStream("usuarios.dat", true);
                    ObjectOutputStream obd = new ObjectOutputStream(nombreF);
                    obd.writeObject(user);
                    ingrenombre.setText("");
                    contrase.setText("");
                } catch (FileNotFoundException ex) {
                    mensaje.setText("ERROR: NO SE ENCUENTRA EL ARCHIVO");
                } catch (IOException ex) {
                    mensaje.setText("ERROR: NO SE PUDO GUARDAR EL ARCHIVO");
                } catch (Exception ex) {
                    mensaje.setText("ERROR DESCONOCIDO: " + ex.getMessage());
                }

            }
        });

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registrar = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                registrar.setVisible(false);

                JFrame loginframe = new JFrame("Login");
                login login = new login();
                loginframe.setContentPane(login.rootPanel);
                loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginframe.pack();
                loginframe.setVisible(true);

            }
        });
    }

}
