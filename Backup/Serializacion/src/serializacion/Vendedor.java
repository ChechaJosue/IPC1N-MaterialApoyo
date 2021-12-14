
package serializacion;

import java.io.Serializable;

public class Vendedor implements Serializable {
    
    private int dpi, ventas;
    private String nombre, correo, password;
    private char genero;

    // Constructores
    
    public Vendedor() {
    }
    
    public Vendedor(int dpi, int ventas, String nombre, String correo, String password, char genero) {
        this.dpi = dpi;
        this.ventas = ventas;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.genero = genero;
    }
    
    public boolean login(String correo, String password){
        return this.correo.equals(correo) && this.password.equals(password);
    }
    
    public int getDpi() {
        return dpi;
    }

    public int getVentas() {
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public char getGenero() {
        return genero;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString(){
        return "\nDPI: " + this.dpi + "\nNombre: " + this.nombre
             + "\nVentas: " + this.ventas + "\nGenero: " + this.genero
             + "\nCorreo: " + this.correo + "\nPassword: " + this.password;
    }
}
