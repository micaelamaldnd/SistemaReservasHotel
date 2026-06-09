package ar.com.unpaz.inicio;

import java.util.List;
import java.util.Scanner;

import ar.com.unpaz.model.Habitacion;
import ar.com.unpaz.model.Reserva;
import ar.com.unpaz.repo.LecturaArchivoRepoHabitaciones;
import ar.com.unpaz.repo.LecturaArchivoRepoReservas;
import ar.com.unpaz.repoImp.LecturaArchivoRepoImpHabitaciones;
import ar.com.unpaz.repoImp.LecturaArchivoRepoImpReservas;
import ar.com.unpaz.service.LecturaArchivoServiceReserva;
import ar.com.unpaz.service.ReservasService;
import ar.com.unpaz.serviceImp.LecturaArchivoServiceImpReserva;
import ar.com.unpaz.serviceImp.ReservasServiceImp;

public class Main {

	public static void main(String[] args) {
		LecturaArchivoRepoHabitaciones lectura = new LecturaArchivoRepoImpHabitaciones();
		List <Habitacion> habitaciones = lectura.obtenerHabitaicones();
		
		LecturaArchivoRepoReservas repositorioReservas = new LecturaArchivoRepoImpReservas(habitaciones);
		
		
		LecturaArchivoServiceReserva listaReservas = new LecturaArchivoServiceImpReserva(repositorioReservas);
		List<Reserva> reservas = listaReservas.listarReservas();
		
		ReservasService gestor = new ReservasServiceImp(reservas);
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion;
		
		do {
			
			System.out.println("\n========== SISTEMA DE RESERVAS DE HOTEL ==========\n");

			System.out.println("1.  Listar todas las reservas");
			System.out.println("2.  Listar clientes");
			System.out.println("3.  Mostrar reservas mayores a $50.000");
			System.out.println("4.  Mostrar clientes en mayúsculas");
			System.out.println("5.  Mostrar reservas Premium");
			System.out.println("6.  Contar habitaciones Suite");
			System.out.println("7.  Primera reserva superior a $90.000");
			System.out.println("8.  Verificar si existe habitación para 4 personas");
			System.out.println("9.  Mostrar reserva más cara");
			System.out.println("10. Mostrar reserva más barata");
			System.out.println("11. Mostrar facturación total");
			System.out.println("12. Mostrar precio promedio");
			System.out.println("13. Ordenar reservas de mayor a menor precio final");
			System.out.println("14. Mostrar reservas económicas");
			System.out.println("15. Mostrar reservas Premium (clasificación)");
			System.out.println("16. Contar reservas Premium");
			System.out.println("17. Mostrar cliente y tipo de reserva");
			System.out.println("18. Cantidad de reservas por cliente");
			System.out.println("19. Cliente con mayor cantidad de reservas");
			System.out.println("20. Cantidad de reservas por tipo de habitación");
			System.out.println("21. Tipo de habitación más reservada");
			System.out.println("22. Reporte Final");

			System.out.println("23. Salir");

			System.out.print("\nElija una opción: ");
			
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcion) {
			
			case 1:
				gestor.listarReservas();
				break;
				
			case 2: 
				gestor.listarNombresClientes();
				break;
				
			case 3:
				gestor.reservasMayoresA50mil();
				break;
				
			case 4: 
				System.out.println(gestor.nombresClientesMAYUS());
				break;
				
			case 5:
				System.out.println(gestor.reservasPremium());
				break;
				
			case 6:
				System.out.println("Cantidad: " + gestor.cantHabitacionesSuite());
				break;
				
			case 7:
				System.out.println(gestor.primeraReservaSuperior90mil());
				break;
				
			case 8:
			    System.out.println("¿Existe habitación para 4 personas?: "
			            + gestor.habitacion4p());
			    break;

			case 9:
			    System.out.println("Reserva más cara:");
			    System.out.println(gestor.masCara());
			    break;

			case 10:
			    System.out.println("Reserva más barata:");
			    System.out.println(gestor.masBarata());
			    break;

			case 11:
			    System.out.println("Facturación total: $"
			            + gestor.facturacionTotal());
			    break;

			case 12:
			    System.out.println("Precio promedio: $"
			            + gestor.promedioPrecio());
			    break;
				
			case 13: 
				gestor.mayorAmenorPrecioFinal();
				break;
				
			case 14:
				gestor.listarReservasEconomicas();
				break;
				
			case 15:
			    gestor.listarReservasPremium();
			    break;

			case 16:
			    System.out.println("Cantidad de reservas Premium: "
			            + gestor.cantReservasPremium());
			    break;

			case 17:
				gestor.clienteXtipoReserva();
				break;
				
			case 18:
				System.out.println(gestor.cantReservasxCliente());
				break;
				
			case 19:
			    System.out.println("Cliente con mayor cantidad de reservas: "
			            + gestor.clienteConMayorReserva());
			    break;
				
			case 20:
				System.out.println(gestor.cantReservasxHabitacion());
				break;
			
			case 21:
				System.out.println("El tipo de habitacion mas reservada es: " + gestor.tipoHabitacionMasReservada());
				break;
				
			case 22:
			    System.out.println("\n----- REPORTE FINAL -----\n");
			    gestor.reporteFinal();
			    break;

			case 23:
			    System.out.println("Saliendo del sistema...");
			    return;
				
				
			default:
				System.out.println("Opcion invalida");
			
			}
			
		} while(opcion != 23);
		scanner.close();
		
	}

}
