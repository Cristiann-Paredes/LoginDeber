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
                // Creamos una nueva instancia de la clase "datos" para almacenar la información del usuario.
                datos user = new datos();

                User = ingrenombre.getText();// Obtenemos el nombre de usuario ingresado por el usuario
                user.setUsuario(User);
                passw = String.valueOf(contrase.getPassword());// Obtenemos la contraseña ingresada por el usuario
                user.setContrase(passw);

                try {
                    // Abrimos un archivo llamado "usuarios.dat"
                    FileOutputStream nombreF = new FileOutputStream("usuarios.dat", true);
                    ObjectOutputStream obd = new ObjectOutputStream(nombreF);
                    obd.writeObject(user);

                    // Limpiamos los campos de texto "ingrenombre" y "contrase".
                    ingrenombre.setText("");
                    contrase.setText("");
                } catch (FileNotFoundException ex) {
                    // Mostramos un mensaje de error en un campo de texto llamado "mensaje".
                    mensaje.setText("ERROR: NO SE ENCUENTRA EL ARCHIVO");
                } catch (IOException ex) {
                    // Si hay un problema al guardar el archivo y mostramos un mensaje de error en "mensaje".
                    mensaje.setText("ERROR: NO SE PUDO GUARDAR EL ARCHIVO");
                } catch (Exception ex) {
                    mensaje.setText("ERROR DESCONOCIDO: " + ex.getMessage());
                }
            }
        });


        // Agregamos un ActionListener al botón "iniciar" para escuchar eventos de clic.
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenemos el JFrame "registrar"
                JFrame registrar = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                registrar.setVisible(false);

                // Creamos un nuevo JFrame llamado "loginframe" para la ventana de inicio de sesión.
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
