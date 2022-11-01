package mondaca_TP_RAC;

import java.util.Random;

public class Auto {
    private String matricula;
    private String modelo;
    private String marca;
    private String color;
    private double precio;
    private boolean reservado;
    
    public Auto() {
    }
    public Auto(String mod, String mar, String c, double p, boolean r) {
        this.matricula = generarMatricula();
        this.modelo = mod;
        this.marca = mar;
        this.color = c;
        this.precio = p;
        this.reservado = r;
    }
    
    public String generarMatricula(){
        Random random = new Random();
        char c1 = (char)(random.nextInt(26)+ 'A');
        char c2 = (char)(random.nextInt(26)+ 'A');
        char c3 = (char)(random.nextInt(26)+ 'A');
        char c4 = (char)(random.nextInt(26)+ 'A');
        String p = String.valueOf(c1) + String.valueOf(c2);
        p = p + " " + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
        p = p + " " + String.valueOf(c3) + String.valueOf(c4);
        return p;
    }
    
    public void mostrarAuto() {
        System.out.println("    |-AUTO-|");
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Color: " + this.color);
        System.out.println("Precio/dia: $" + this.precio);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
    
}
