import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

    public class login {
        JPanel rootPanel;
        private JPasswordField contra;
        private JTextField usuario;
        private JButton registrar;
        private JButton iniciar;
        private boolean contenido = true;
        private boolean usser;
        private boolean passw;
        public String usuario1;
        public String contra1;


        public login() {

            iniciar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    usuario1 = usuario.getText();// Obtenemos el nombre de usuario ingresado.
                    contra1 = new String(contra.getPassword());// Obtenemos la contraseña ingresada convertido en String.
                    // Inicializamos las variables "usser" y "passw" como "false".
                    usser = false;
                    passw = false;

                    try {
                        // Abrimos el archivo "usuarios.dat".
                        FileInputStream dat = new FileInputStream("usuarios.dat");

                        while (contenido) {

                            ObjectInputStream oos = new ObjectInputStream(dat);// Creamos un ObjectInputStream para leer objetos del archivo.
                            datos informacionUsuario = (datos) oos.readObject();// Leemos un objeto "datos" del archivo.
                            if (informacionUsuario != null) {

                                // Obtenemos el nombre de usuario y la contraseña del objeto.
                                String user1 = informacionUsuario.getUsuario();
                                String contr1 = new String(informacionUsuario.getContrase());

                                // Comparamos si el nombre de usuario y la contraseña ingresados coinciden con los almacenados en el archivo.
                                if (usuario1.equals(user1) && contra1.equals(contr1)) {
                                    System.out.println("Ingrese correcto");

                                    // Si las credenciales son correctas, establecemos "usser" y "passw" a "true" y salimos del ciclo.
                                    usser = true;
                                    passw = true;
                                    break;
                                } else {
                                    System.out.println("Login Correcto");
                                    usuario.setText("");
                                    contra.setText("");
                                }
                            } else {
                                // Si llegamos al final del archivo (objeto nulo), salimos del ciclo.
                                contenido = false;
                            }
                        }

                        //Lee el archivo para verificar.
                        if (usser == true && passw == true) {
                            // Obtenemos el JFrame actual al que pertenece el botón "iniciar".
                            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                            // Hacemos que el JFrame actual se vuelva invisible.
                            frame.setVisible(false);

                            // Creamos un nuevo JFrame llamado "usserFrame" para mostrar la ventana de bienvenida.
                            JFrame usserFrame = new JFrame("Bienvenido");

                            // Creamos una instancia de la clase "usuarios".
                            usuarios usuari = new usuarios();
                            usuari.Ingreusuario.setText(usuario1);
                            usserFrame.setContentPane(usuari.rootPanel);
                            usserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            usserFrame.pack();
                            usserFrame.setVisible(true);
                        }

                    } catch (FileNotFoundException ex) {
                        // Si el archivo "usuarios.dat" no se encuentra, lanzamos una RuntimeException con el error.
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        // Si ocurre un error de entrada/salida, mostramos un mensaje de error mediante JOptionPane.
                        JOptionPane.showMessageDialog(rootPanel, "Ingreso incorrecto. Intente nuevamente ....");
                    } catch (ClassNotFoundException ex) {
                        // Si ocurre un error de clase no encontrada al leer el objeto, lanzamos una RuntimeException con el error.
                        throw new RuntimeException(ex);
                    }
                }
            });

        // Agregamos un boton registrar
            registrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenemos el JFrame "loginFrame" al que pertenece el botón "registrar" mediante SwingUtilities.getWindowAncestor.
                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                    loginFrame.setVisible(false);// Hacemos que el JFrame "loginFrame"
                    JFrame registroFrame = new JFrame("Registro");// Creamos un nuevo JFrame llamado "registroFrame"
                    formulario registro = new formulario();// Creamos una instancia de la clase "formulario" donde esta nuestra interfaz form
                    registroFrame.setContentPane(registro.rootPanel);
                    registroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    registroFrame.pack();
                    // Hacemos que el JFrame "registroFrame" sea visible, mostrando así la ventana de registro al usuario.
                    registroFrame.setVisible(true);
                }
            });

        }
        //Main principal de nuestra ventana Login
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame("Login");
                    frame.setContentPane(new login().rootPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        }
    }



