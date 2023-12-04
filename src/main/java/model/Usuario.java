package model;

public class Usuario {
    private String nombre;
    private int edad;
    private String rut;
    private int peso;
    private double estatura;
    private String email;
    private String telefono;
    private String direccion;
    private String sexo;
    public Usuario(String nombre, int edad, String rut,String sexo,int peso, double estatura, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
        this.sexo = sexo;
        this.peso = peso;
        this.estatura = estatura;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }
    public String getRut() {
        return this.rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getSexo() {
        return this.sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getPeso() {
        return this.peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public double getEstatura() {
        return this.estatura;
    }
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return this.telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return this.direccion;
    }
}

