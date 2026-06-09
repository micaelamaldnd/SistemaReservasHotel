package ar.com.unpaz.model;

public abstract class Habitacion {
	private String idHabitacion;
	private int capacidad;
	private double precioNoche;

	
	public Habitacion(String idHabitacion, int capacidad, double precioNoche) {
		this.idHabitacion = idHabitacion;
		this.capacidad = capacidad;
		this.precioNoche = precioNoche;
	}


	public Habitacion() {}

	
	public abstract double calcularPrecioFinal();
	
	
	public String getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}

	@Override
	public String toString() {
		return "\nID Habitacion = " + idHabitacion +
				"\nCapacidad = " + capacidad + 
				"\nPrecio por noche = " + precioNoche;
	}
	
	
}
