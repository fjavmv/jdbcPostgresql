package POJO;

public class Usuario {
    private  int idUsuario;
    private String nombreUsuario;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edadUsuario;
    private  String sexoUsuario;
    private String telefonoUsuario;
    private String emailUsuario;

    public Usuario(){

    }

     public Usuario(int idUsuario, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, int edadUsuario, String sexoUsuario, String telefonoUsuario, String emailUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edadUsuario = edadUsuario;
        this.sexoUsuario = sexoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Usuario(String nombreUsuario, String apellidoPaterno, String apellidoMaterno, int edadUsuario, String sexoUsuario, String telefonoUsuario, String emailUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edadUsuario = edadUsuario;
        this.sexoUsuario = sexoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Usuario(int idUsuario) {
         this.idUsuario = idUsuario;
    }


    public int getIdUsuario() {
        return idUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public int getEdadUsuario() {
        return edadUsuario;
    }
    public String getSexoUsuario() {
        return sexoUsuario;
    }
    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "Id de usuario: " + idUsuario + "\n " +
                "Nombre de usuario: " + nombreUsuario + "\n" +
                "Apellido paterno: " + apellidoPaterno + "\n" +
                "Apellido materno: " + apellidoMaterno + "\n" +
                "Edad usuario: " + edadUsuario + "\n" +
                "Sexo usuario: " + sexoUsuario + "\n" +
                "Tel??fono usuario: " + telefonoUsuario + "\n" +
                "Correo usuario: " + emailUsuario;
    }
}
