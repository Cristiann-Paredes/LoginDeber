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
        private boolean cont = true;
        private boolean usser;
        private boolean passw;
        public String usuario1;
        public String contra1;


        public login() {

            iniciar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    usuario1 = usuario.getText();
                    contra1 = new String(contra.getPassword());
                    usser = false;
                    passw = false;

                    try{
                        FileInputStream dat = new FileInputStream("datos.dat");
                        while(cont){
                            ObjectInputStream oos = new ObjectInputStream(dat);
                            DatosUs info = (DatosUs) oos.readObject();
                            if (info != null){
                                String usuariov = info.getUsuario();
                                String contrav = new String(info.getContrase());

                                if(usuario1.equals(usuariov) && contra1.equals(contrav)){
                                    System.out.println("Ingrese correcto");
                                    usser = true;
                                    passw = true;
                                    break;
                                }
                                else{
                                    System.out.println("Login Correcto");
                                    usuario.setText("");
                                    contra.setText("");
                                }
                            }

                            else{
                                cont = false;

                            }
                        }
                        if( usser == true && passw == true){
                            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                            frame.setVisible(false);

                            JFrame usserFrame = new JFrame("Usuario");
                            usuarios usuari = new usuarios();
                            usuari.Ingreusuario.setText(usuario1);
                            usserFrame.setContentPane(usuari.rootPanel);
                            usserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            usserFrame.pack();
                            usserFrame.setVisible(true);
                        }

                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPanel, "Ingreso incorrecto. Intente nuevamente ....");
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });

            registrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                    loginFrame.setVisible(false);

                    JFrame registroFrame = new JFrame("Registro");
                    registros registro = new registros();
                    registroFrame.setContentPane(registro.rootPanel);
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



