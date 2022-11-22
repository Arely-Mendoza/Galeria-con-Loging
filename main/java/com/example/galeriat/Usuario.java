package com.example.galeriat;

public class Usuario {
    int id;
    String nombre;
    String apellidos;
    String usuario;
    String password;

    public Usuario(String nombre, String apellidos, String usuario, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario'" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public boolean isNull(){
        if (nombre.equals("")&&apellidos.equals("")&&usuario.equals("")&&password.equals("")){
            return false;
        }else{
            return  true;
        }

    }
    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return apellidos;
    }

    public void setDireccion(String direccion) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {return usuario;}

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
