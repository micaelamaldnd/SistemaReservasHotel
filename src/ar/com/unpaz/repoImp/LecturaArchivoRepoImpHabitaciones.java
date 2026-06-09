package ar.com.unpaz.repoImp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Habitacion;
import ar.com.unpaz.model.HabitacionStandard;
import ar.com.unpaz.model.HabitacionSuite;
import ar.com.unpaz.repo.LecturaArchivoRepoHabitaciones;

public class LecturaArchivoRepoImpHabitaciones implements LecturaArchivoRepoHabitaciones{

	@Override
	public List<Habitacion> obtenerHabitaicones() {
		List<Habitacion> habitaciones = new ArrayList<>();
		File sfile = new File("habitaciones.txt");
		FileReader sfilereader;
		try {
			sfilereader = new FileReader(sfile);
			BufferedReader sbuffer = new BufferedReader(sfilereader);
			String linea = "";
			while((linea = sbuffer.readLine())!= null) {
				String [] array = linea.split(";");
				
				
				String id = array[0];
				int capacidad = Integer.parseInt(array[2]);
				double precio = Double.parseDouble(array[3]);
				
				String tipo = array[1];
				
				if (tipo.equalsIgnoreCase("STANDARD")) {
					habitaciones.add(new HabitacionStandard(id, capacidad, precio));				
				}
				
				if (tipo.equalsIgnoreCase("SUITE")) {
					habitaciones.add(new HabitacionSuite(id, capacidad, precio));
				}
			}
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return habitaciones;
	}

}
