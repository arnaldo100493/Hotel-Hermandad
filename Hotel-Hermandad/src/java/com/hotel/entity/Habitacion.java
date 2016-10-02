package com.hotel.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nomenclatura", length = 10, nullable = false, insertable = true, unique = true, updatable = false)
    private String nomenclatura;

    @Column(name = "descripcion", length = 100, insertable = true, updatable = true)
    private String descripcion;

    @Column(name = "precio", nullable = false, insertable = true, updatable = true)
    private double precio;

    @Column(name = "estado", nullable = false, insertable = true, updatable = true)
    private String estado;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "detalle_reserva_habitacion",
            joinColumns = { @JoinColumn(name = "id_reserva", referencedColumnName="id") },
            inverseJoinColumns = { @JoinColumn(name = "id_habitacion", referencedColumnName="id") }
    )
    private List<Reserva> reservas;

    @OneToOne
    private TipoHabitacion tipoHabitacion;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable (
       name="detalle_servicio_habitacion",
       joinColumns = {@JoinColumn(name="id_servicio", referencedColumnName="id")},
       inverseJoinColumns = {@JoinColumn(name="id_habitacion", referencedColumnName="id")}
    )
    private List<Servicio> servicios;

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicio) {
        this.servicios = servicio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    
    
    public Habitacion() {

    }

    public Habitacion(String nomenclatura, String descripcion, double precio, boolean estado) {
        this.id = null;
        this.nomenclatura = nomenclatura;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Habitacion(Long id, String nomenclatura, String descripcion, double precio, boolean estado) {
        this.id = id;
        this.nomenclatura = nomenclatura;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

}
