package modelo;

public class Usuario {
    private  int IdUsuario;
    private String nombreUsuario;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edadUsuario;
    private  String sexoUsuario;
    private String telefonoUsuario;
    private String emailUsuario;

    public Usuario(int idUsuario, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, int edadUsuario, String sexoUsuario, String telefonoUsuario, String emailUsuario) {
        IdUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edadUsuario = edadUsuario;
        this.sexoUsuario = sexoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Usuario(String nombreUsuario, String apellidoPaterno, String apellidoMaterno, int edadUsuario, String sexoUsuario, String telefonoUsuario, String emailUsuario) {
        //this.IdUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edadUsuario = edadUsuario;
        this.sexoUsuario = sexoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Usuario(){

    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "Id de usuario: " + IdUsuario + "\n " +
                "Nombre de usuario: " + nombreUsuario + "\n" +
                "Apellido paterno: " + apellidoPaterno + "\n" +
                "Apellido materno: " + apellidoMaterno + "\n" +
                "Edad usuario: " + edadUsuario + "\n" +
                "Sexo usuario: " + sexoUsuario + "\n" +
                "Tel usuario: " + telefonoUsuario + "\n" +
                "Correo usuario: " + emailUsuario;
    }
}
