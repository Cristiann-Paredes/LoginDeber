import java.io.Serializable;

public class datos implements Serializable {

    // Definimos dos variables privadas de instancia para almacenar el nombre de usuario y la contraseña.
    private String usuario;
    private String contrase;

    // Constructor de la clase
    public datos(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrase = contrasenia;
    }

    // Método getter y setter del usuario.
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Método getter y stter para  la contraseña.
    public String getContrase() {
        return contrase;
    }
    public void setContrase(String contrase) {
        this.contrase = contrase;
    }

    // Constructor sin argumentos para la clase datos.
    public datos() {
    }
}
