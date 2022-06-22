package ec.edu.epn.git.supermercado;

public class Proveedor {
    public String name;
    public String company;
    public String days;

    public Proveedor(String name, String company, String days) {
        this.name = name;
        this.company = company;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public String toString() {
        String salida;
        salida = "Nombre: " + name + "\nEmpresa: " + company +"\nDias de Visita: " + days;
        return salida;
    }
}
