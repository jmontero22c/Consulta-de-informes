package model.vo;

public class ProyectoBancoVo {
    private int ID;
    private String Constructora;
    private String Ciudad;
    private String Clasificacion;
    private int Estrato;
    private String Lider;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getConstructora() {
        return Constructora;
    }

    public void setConstructora(String constructora) {
        Constructora = constructora;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        Clasificacion = clasificacion;
    }

    public int getEstrato() {
        return Estrato;
    }

    public void setEstrato(int estrato) {
        Estrato = estrato;
    }

    public String getLider() {
        return Lider;
    }

    public void setLider(String lider) {
        Lider = lider;
    }

    @Override
    public String toString() {
        return String.format("%3d %-25s %-20s %-15s %7d %-30s",
                ID, Constructora, Ciudad, Clasificacion, Estrato, Lider);

    }

}
