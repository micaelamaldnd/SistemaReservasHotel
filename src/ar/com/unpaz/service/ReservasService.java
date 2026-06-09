package ar.com.unpaz.service;

import java.util.HashMap;
import java.util.List;

import ar.com.unpaz.model.Reserva;

public interface ReservasService {
	void listarReservas ();
	void listarNombresClientes();
	void reservasMayoresA50mil();
	List<String> nombresClientesMAYUS();
	List<Reserva> reservasPremium();
	long cantHabitacionesSuite();
	Reserva primeraReservaSuperior90mil();
	
	boolean habitacion4p ();
	Reserva masCara();
	Reserva masBarata();
	double facturacionTotal();
	double promedioPrecio();
	void mayorAmenorPrecioFinal();
	void listarReservasEconomicas();
	void listarReservasPremium();
	long cantReservasPremium();
	void clienteXtipoReserva();
	
	HashMap<String,Integer> cantReservasxCliente();
	String clienteConMayorReserva();
	HashMap<String,Integer> cantReservasxHabitacion();
	String tipoHabitacionMasReservada();
	void reporteFinal();
	
	
	
}
