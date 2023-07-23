import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

    public class login {
        private JPasswordField contras;
        private JTextField usuario;
        private JButton registrar;
        private JButton iniciar;
        JPanel rootPanel;
        private boolean cont = true;
        private boolean us;
        private boolean ca;
        public String username;
        public String password;

        public login() {

            iniciar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Verificar las credenciales (aquí deberías implementar tu lógica de autenticación)
                    username = usuario.getText();
                    password = new String(contras.getPassword());
                    us = false;
                    ca = false;

                    try{
                        FileInputStream dat = new FileInputStream("USUARIOS.dat");
                        while(cont){
                            ObjectInputStream oos = new ObjectInputStream(dat);
                            datosUsuarios info = (datosUsuarios) oos.readObject();
                            if (info != null){
                                String usuariov = info.getusuario();
                                String contrav = new String(info.getContrasenia());
                                //System.out.println(usuariov + " " + contrav + " " + password); PROBADOR PARA COMPARAR CREDENCIALES
                                if(username.equals(usuariov) && password.equals(contrav)){
                                    System.out.println("entro"); // PROBAR ENTRA A ESTA CONDICION
                                    us = true;
                                    ca = true;
                                    break;
                                }
                                else{
                                    System.out.println("entro-2"); // PROBAR SI ENTRA A ESTA OTRA
                                    usuario.setText("");
                                    contras.setText("");
                                }
                            }

                            else{
                                cont = false;

                            }
                        }
                        if( us == true && ca == true){
                            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                            frame.setVisible(false);

                            JFrame usserFrame = new JFrame("USUARIO");
                            usuarios usserventana = new usuarios();
                            usserventana.datostxt.setText(username);
                            usserFrame.setContentPane(usserventana.rootPanel);
                            usserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            usserFrame.pack();
                            usserFrame.setVisible(true);
                        }

                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPanel, "Credenciales inválidas. Inténtalo de nuevo.");
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });

            registrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Cerrar la ventana actual de login
                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                    loginFrame.setVisible(false);

                    // Abrir la ventana de registro
                    JFrame registroFrame = new JFrame("Registro");
                    registros registroVentana = new registros();
                    registroFrame.setContentPane(registroVentana.rootPanel);
                    registroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    registroFrame.pack();
                    registroFrame.setVisible(true);
                }
            });
        }

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




