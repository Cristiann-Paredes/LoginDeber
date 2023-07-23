import java.io.Serializable;

public class DatosUs implements Serializable {
    private String usuario;
    private String contrase;

    public DatosUs(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrase = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrase() {
        return contrase;
    }

    public void setContrase(String contrase) {
        this.contrase = contrase;
    }

    public DatosUs() {
    }
}
