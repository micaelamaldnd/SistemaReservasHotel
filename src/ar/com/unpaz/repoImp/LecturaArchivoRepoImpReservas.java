package ar.com.unpaz.repoImp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Habitacion;
import ar.com.unpaz.model.Reserva;
import ar.com.unpaz.repo.LecturaArchivoRepoReservas;

public class LecturaArchivoRepoImpReservas implements LecturaArchivoRepoReservas{
	private List<Habitacion> habitaciones;
	
	public LecturaArchivoRepoImpReservas(List<Habitacion> habitaciones) {
		super();
		this.habitaciones = habitaciones;
	}
	
	@Override
	public List<Reserva> obtenerReservas() {
		List<Reserva> reservas = new ArrayList<>();
		File sfile = new File("reservas.txt");
		FileReader sfilereader;
		try {
			sfilereader = new FileReader(sfile);
			BufferedReader sbuffer = new BufferedReader(sfilereader);
			String linea = "";
			while((linea = sbuffer.readLine())!= null) {
				String [] array = linea.split(";");
				
				
				 Habitacion habitacion = habitaciones.stream()
		                    .filter(h -> h.getIdHabitacion().equals(array[2]))
		                    .findFirst()
		                    .orElse(null);

				 reservas.add(new Reserva(array[0], array[1], habitacion));	
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return reservas;
	}

}
