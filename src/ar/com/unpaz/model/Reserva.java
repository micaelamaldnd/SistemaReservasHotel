package ar.com.unpaz.model;

public class Reserva {
	private String idReserva;
	private String cliente;
	private Habitacion habitacion;
	
	
	public Reserva(String idReserva, String cliente, Habitacion habitacion) {
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.habitacion = habitacion;
	}
	
	public Reserva() {}

	
	@Override
	public String toString() {
		return "\n------------ Reserva ------------" +
				"\nId Reserva = " + idReserva + 
				"\nCliente = " + cliente + 
				"\nHabitacion = " + habitacion;
	}
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
}
