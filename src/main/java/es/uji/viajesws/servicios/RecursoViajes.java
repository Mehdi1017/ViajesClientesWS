package es.uji.viajesws.servicios;


import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

import es.uji.viajesws.modelo.GestorViajes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.Vector;


@Path("viajes")
public class RecursoViajes {

	private GestorViajes gestor = null;

	/**
	 * Constructor por defecto
	 */
	public RecursoViajes() {
		super();
		gestor = new GestorViajes();
		System.out.println("construyo RecursoViajes");
	}

	/**
	 * Cuando cada cliente cierra su sesion volcamos los datos en el fichero para mantenerlos actualizados
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	public Response guardaDatos() {
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}


	/**
	 * Devuelve los viajes disponibles con un origen dado
	 *
	 * @param origen
	 * @return JSONArray de viajes con un origen dado. Vacío si no hay viajes disponibles con ese origen
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	public Response consultaViajes(String origen) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}

	/**
	 * El cliente codcli reserva el viaje codviaje
	 *
	 * @param codviaje
	 * @param codcli
	 * @return JSONObject con la información del viaje. Vacío si no existe o no está disponible
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	public Response reservaViaje(String codviaje, String codcli) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}

	/**
	 * El cliente codcli anula su reserva del viaje codviaje
	 *
	 * @param codviaje	codigo del viaje a anular
	 * @param codcli	codigo del cliente
	 * @return	JSON del viaje en que se ha anulado la reserva. JSON vacio si no se ha anulado
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	public Response anulaReserva(String codviaje,  String codcli) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}

	/**
	 * El cliente codcli oferta un Viaje
	 * @param codcli
	 * @param origen
	 * @param destino
	 * @param fecha
	 * @param precio
	 * @param numplazas
	 * @return	JSONObject con los datos del viaje ofertado. Vacio si no se oferta
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	public Response ofertaViaje(String codcli, String origen,
								String destino, String fecha,
								long precio, long numplazas) { // CABECERA POR COMPLETAR
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}




	/**
	 * El cliente codcli borra un viaje que ha ofertado
	 *
	 * @param codviaje	codigo del viaje a borrar
	 * @param codcli	codigo del cliente
	 * @return	JSONObject del viaje borrado. JSON vacio si no se ha borrado
	 */
	/* FALTAN ANOTACIONES JAX-RS */
	public Response borraViaje(String codviaje, String codcli) {
		/* POR IMPLEMENTAR */
		return null; // A MODIFICAR
	}



}
