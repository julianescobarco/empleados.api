package co.empleados.api.models;

import co.empleados.api.validations.MayorEdadRestriccion;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Table(name = "empleado")
@Entity
public class Empleado {
    @Id
    @Column(name = "documento", unique = true, nullable = false)
    @NotNull(message = "El documento es obligatorio")
    private String documento;
    @Column(name = "tipo_documento")
    @NotNull(message = "El tipo de documento es obligatorio")
    private String tipoDocumento;
    @Column(name = "nombres")
    @NotNull(message = "Los nombres son obligatorios")
    private String nombres;
    @Column(name = "apellidos")
    @NotNull(message = "Los apellidos son obligatorios")
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    @Past(message = "La fecha de nacimiento debe ser menor a la fecha actual")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @MayorEdadRestriccion(message = "El empleado debe tener al menos 18 años de edad")
    private Date fechaNacimiento;
    @Column(name = "fecha_vinculacion")
    @Past(message = "La fecha de vinculación debe ser menor a la fecha actual")
    @NotNull(message = "La fecha de vinculación es obligatoria")
    private Date fechaVinculacion;
    @Column(name = "cargo")
    @NotNull(message = "El cargo es obligatorio")
    private String cargo;
    @Column(name = "salario")
    @NotNull(message = "El salario es obligatorio")
    @Min(value = 100, message = "El salario debe ser mayor o igual a 100")
    private double salario;

    @Transient
    private String tiempoVinculacion;
    @Transient
    private String edad;

    public Empleado() {
    }

    public Empleado(String documento, String tipoDocumento, String nombres, String apellidos, Date fechaNacimiento, Date fechaVinculacion, String cargo, double salario) {
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaVinculacion = fechaVinculacion;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTiempoVinculacion() {
        return tiempoVinculacion;
    }

    public void setTiempoVinculacion(String tiempoVinculacion) {
        this.tiempoVinculacion = tiempoVinculacion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "documento='" + documento + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaVinculacion=" + fechaVinculacion +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
