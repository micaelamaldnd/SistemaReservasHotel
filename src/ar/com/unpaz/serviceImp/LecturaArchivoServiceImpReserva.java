package ar.com.unpaz.serviceImp;

import java.util.List;

import ar.com.unpaz.model.Reserva;
import ar.com.unpaz.repo.LecturaArchivoRepoReservas;
import ar.com.unpaz.service.LecturaArchivoServiceReserva;

public class LecturaArchivoServiceImpReserva implements LecturaArchivoServiceReserva{
	
	private LecturaArchivoRepoReservas repo;
	
	public LecturaArchivoServiceImpReserva(LecturaArchivoRepoReservas repo) {
		super();
		this.repo = repo;
	}


	@Override
	public List<Reserva> listarReservas() {
		return repo.obtenerReservas();
	}

}
