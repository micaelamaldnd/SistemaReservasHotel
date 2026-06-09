package ar.com.unpaz.model;

public class HabitacionStandard extends Habitacion {
	
	public HabitacionStandard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HabitacionStandard(String idHabitacion, int capacidad, double precioNoche) {
		super(idHabitacion, capacidad, precioNoche);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularPrecioFinal() {
		return getPrecioNoche();
	}

	@Override
	public String toString() {
		return " Standard " + super.toString();
	}
}
