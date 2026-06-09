package ar.com.unpaz.serviceImp;

import ar.com.unpaz.model.Reserva;
import ar.com.unpaz.service.ReglasNegocioService;

public class ReglasNegocioServiceImp implements ReglasNegocioService{

	@Override
	public boolean esReservaEconomica(Reserva reserva) {
		if  (reserva.getHabitacion().calcularPrecioFinal() < 50000) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean esReservaNormal(Reserva reserva) {
		if  (reserva.getHabitacion().calcularPrecioFinal() >= 50000 || reserva.getHabitacion().calcularPrecioFinal() <= 90000) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean esReservaPremium(Reserva reserva) {  
		if  (reserva.getHabitacion().calcularPrecioFinal() > 90000) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String clasificarReserva(Reserva reserva) {
		if (this.esReservaEconomica(reserva)) return "ECONOMICA";
		if (this.esReservaNormal(reserva)) return "NORMAL";
		if (this.esReservaPremium(reserva)) return "PREMIUM";
		return null;
	}
}
