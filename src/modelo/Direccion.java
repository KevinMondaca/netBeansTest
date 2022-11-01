package modelo;

public class Direccion {
    private String calle;
    private int altura;
    private String barrio;
    private String pisoDto;
    
    public Direccion() {
    }
    public Direccion(String c, int a, String b, String p) {
        this.calle = c;
        this.altura = a;
        this.barrio = b;
        this.pisoDto = p;
    }

    @Override
    public String toString() {
        String s;
        if (this.pisoDto.isEmpty()) {
            s = this.calle + " " + this.altura + ", barrio " + this.barrio; 
        } else {
            s = this.calle + " " + this.altura + " piso " + this.pisoDto + ", barrio " + this.barrio;
        }
        return s;
    }
    
    public void mostrarDireccion() {
        System.out.println("Dirección:");
        System.out.println("  barrio: " + this.barrio);
        System.out.println("  calle: " + this.calle + " " + this.altura);
        if (this.pisoDto.length() != 0){
            System.out.println("  piso: " + this.pisoDto);
        }
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getBarrio() {
        return barrio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getPisoDto() {
        return pisoDto;
    }
    public void setPisoDto(String pisoDto) {
        this.pisoDto = pisoDto;
    }
    
}
