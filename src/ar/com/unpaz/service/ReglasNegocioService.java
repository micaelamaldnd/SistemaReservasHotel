package ar.com.unpaz.service;

import ar.com.unpaz.model.Reserva;

public interface ReglasNegocioService {
	boolean esReservaEconomica(Reserva reserva);
	boolean esReservaNormal(Reserva reserva);
	boolean esReservaPremium(Reserva reserva);
	String clasificarReserva(Reserva reserva);
}
