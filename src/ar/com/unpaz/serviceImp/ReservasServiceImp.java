package ar.com.unpaz.serviceImp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.unpaz.model.HabitacionStandard;
import ar.com.unpaz.model.HabitacionSuite;
import ar.com.unpaz.model.Reserva;
import ar.com.unpaz.service.ReservasService;
import ar.com.unpaz.service.*;

public class ReservasServiceImp implements ReservasService{
	private List <Reserva> reservas;
	private ReglasNegocioService reglas = new ReglasNegocioServiceImp();
	
	public ReservasServiceImp(List<Reserva> reservas) {
		super();
		this.reservas = reservas;
	}

	@Override
	public void listarReservas() {
		reservas.stream()
		.forEach(r -> System.out.println(r));
	}

	@Override
	public void listarNombresClientes() {
		reservas.stream().forEach(r -> System.out.println(r.getCliente()));
		
	}

	@Override
	public void reservasMayoresA50mil() {
		reservas.stream()
		.filter(r -> r.getHabitacion().calcularPrecioFinal() > 50000)
		.forEach(r -> System.out.println(r));
	}

	@Override
	public List<String> nombresClientesMAYUS() {
		List<String> nombresMayus = reservas.stream()
				.map(r -> r.getCliente().toUpperCase())
				.collect(Collectors.toList());

		return nombresMayus;
	}

	@Override
	public List<Reserva> reservasPremium() {
		List<Reserva> reservasPremium = reservas.stream()
				.filter(r -> reglas.esReservaPremium(r))
				.collect(Collectors.toList());
		
		return reservasPremium;
	}

	@Override
	public long cantHabitacionesSuite() {
		long cant = reservas.stream()
				.filter(r -> r.getHabitacion() instanceof HabitacionSuite)
				.count();

		return cant;
	}

	@Override
	public Reserva primeraReservaSuperior90mil() {
		Reserva primeraReserva = reservas.stream()
				.filter(r -> r.getHabitacion().calcularPrecioFinal() > 90000)
				.findFirst()
				.orElse(null);
				
		return primeraReserva;
	}

	@Override
	public boolean habitacion4p() {
		boolean hayHabitacion = reservas.stream()
				.anyMatch(r -> r.getHabitacion().getCapacidad() == 4);
		return hayHabitacion;
	}

	@Override
	public Reserva masCara() {
		Reserva masCara = reservas.stream()
				.max(Comparator.comparingDouble(r -> r.getHabitacion().calcularPrecioFinal()))
				.orElse(null);
		return masCara;
	}

	@Override
	public Reserva masBarata() {
		Reserva masBarata = reservas.stream()
				.min(Comparator.comparingDouble(r -> r.getHabitacion().calcularPrecioFinal()))
				.orElse(null);
		return masBarata;
	}

	@Override
	public double facturacionTotal() {
		double facturacionT = reservas.stream()
				.mapToDouble(r -> r.getHabitacion().calcularPrecioFinal())
				.sum();
		return facturacionT;
	}

	@Override
	public double promedioPrecio() {
		double promedio = reservas.stream()
				.mapToDouble(r -> r.getHabitacion().calcularPrecioFinal())
				.average()
				.orElse(0);
		return promedio;
	}

	@Override
	public void mayorAmenorPrecioFinal() {
		reservas.stream()
		.sorted((r1, r2) -> Double.compare( r2.getHabitacion().calcularPrecioFinal(),r1.getHabitacion().calcularPrecioFinal()))
		.forEach(r -> System.out.println(r));
	}

	@Override
	public void listarReservasEconomicas() {
		reservas.stream()
		.filter(r -> reglas.esReservaEconomica(r))
		.forEach(r -> System.out.println(r));
	}

	@Override
	public void listarReservasPremium() {
		reservas.stream()
		.filter(r -> reglas.esReservaPremium(r))
		.forEach(r -> System.out.println(r));		
	}

	@Override
	public long cantReservasPremium() {
		long cantP = reservas.stream()
				.filter(r -> reglas.esReservaPremium(r))
				.count();
		return cantP;
	}

	@Override
	public void clienteXtipoReserva() {
		reservas.stream()
		.forEach(r -> System.out.println( r.getCliente() + " -> " + reglas.clasificarReserva(r) + "\n"));
		
	}

	@Override
	public HashMap<String, Integer> cantReservasxCliente() {
		HashMap<String,Integer> mapaRC = new HashMap<>();
		for(Reserva r : reservas) {
			mapaRC.put(r.getCliente(), mapaRC.getOrDefault(r.getCliente(), 0) + 1);
		}
				
		return mapaRC;
	}

	@Override
	public String clienteConMayorReserva() {
		HashMap<String, Integer> mapa = this.cantReservasxCliente();
		
	    String mejorCliente = "";
	    int max = 0;

	    for(String cliente : mapa.keySet()) {

	        if(mapa.get(cliente) > max) {

	            max = mapa.get(cliente);
	            mejorCliente = cliente;
	        }
	    }

	    return mejorCliente;
	}

	@Override
	public HashMap<String, Integer> cantReservasxHabitacion() {
		HashMap<String, Integer> mapaRH = new HashMap<>();
		
		for (Reserva r : reservas) {
			if (r.getHabitacion() instanceof HabitacionSuite) {
				mapaRH.put("SUITE", mapaRH.getOrDefault("SUITE", 0) + 1 );
				}
			if (r.getHabitacion() instanceof HabitacionStandard) {
				mapaRH.put("STANDARD", mapaRH.getOrDefault("STANDARD", 0) + 1 );
			}
		}
		
		return mapaRH;
	}

	@Override
	public String tipoHabitacionMasReservada() {
		HashMap<String, Integer> mapaRH = this.cantReservasxHabitacion();
			// [SUITE = 3 , STANDARD = 6]
		
		
		String tipoHabitacion = "";
		int max = 0;
		
							//[SUITE, STANDAR]
		for (String tipoH : mapaRH.keySet()) {
			if (mapaRH.get(tipoH) > max) {
				max =  mapaRH.get(tipoH);
				tipoHabitacion = tipoH;
			}
		}
	
		return tipoHabitacion;
	}

	@Override
	public void reporteFinal() {
		long cantTotalReservas = reservas.stream()
				.count();
		
		System.out.println("Cantidad total de reservas: " + cantTotalReservas);
		System.out.println("Facturación total: $" + this.facturacionTotal());
		System.out.println("Precio promedio: $" + this.promedioPrecio() );
		System.out.println("Reserva más cara: " + this.masCara());
		System.out.println("Reserva más barata: " + this.masBarata());
		System.out.println("Cantidad de Suites: " + this.cantHabitacionesSuite());
		System.out.println("Cantidad de Premium: " + this.cantReservasPremium());
		System.out.println("Cliente con más reservas: " + this.clienteConMayorReserva());
		System.out.println("Tipo de habitación más reservada: " + this.tipoHabitacionMasReservada());
	}
	
	
	
	
	
	

}
