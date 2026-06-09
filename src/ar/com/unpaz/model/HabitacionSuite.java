package ar.com.unpaz.model;

public class HabitacionSuite extends Habitacion {

	public HabitacionSuite() {
		super();
	}

	public HabitacionSuite(String idHabitacion, int capacidad, double precioNoche) {
		super(idHabitacion, capacidad, precioNoche);
	}

	@Override
	public double calcularPrecioFinal() {
		return getPrecioNoche() * 1.20;
	}

	@Override
	public String toString() {
		return " Suite" + super.toString();
	}

}
