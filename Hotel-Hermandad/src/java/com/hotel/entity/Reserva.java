package com.hotel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraSalida;

    @ManyToOne
    private Cliente cliente;

    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable (
       name="detalle_reserva_habitacion",
       joinColumns = {@JoinColumn(name="id_habitacion", referencedColumnName="id")},
       inverseJoinColumns = {@JoinColumn(name="id_reserva", referencedColumnName="id")}
    )
    private List<Habitacion> habitaciones;

    public Reserva() {

    }

    public Reserva(Long id, Date fechaHoraRegistro, Date fechaHoraSalida, Cliente cliente, Habitacion habitacion) {
        this.id = id;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.fechaHoraSalida = fechaHoraSalida;
        this.cliente = cliente;
    }

    public Reserva(Date fechaHoraRegistro, Date fechaHoraSalida, Cliente cliente, Habitacion habitacion) {
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.fechaHoraSalida = fechaHoraSalida;
        this.cliente = cliente;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
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
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
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
