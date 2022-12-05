package cliente;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AuxiliarViajesWS {
    private Client cliente;
    final private String URI = "http://localhost:8080/ViajesWS2/servicios/viajes/";
    public AuxiliarViajesWS(){
        cliente = ClientBuilder.newClient();
    }

    public void guardaDatos(){
        Response response = cliente.target(URI).path("guardaDatos").request(MediaType.TEXT_PLAIN).get();
    }
    public JSONArray consultaViajes(String origen) throws WebApplicationException {
        Response response = cliente.target(URI).path("consulta/" + origen).request(MediaType.APPLICATION_JSON).get();
        int estado = response.getStatus();
        JSONArray viajes = new JSONArray();
        if (estado == 200){
            viajes = response.readEntity(JSONArray.class);
            //System.out.println(viajes.getClass().getName());
            response.close();
            return viajes;
        } else if (estado == 404) {
            response.close();
            return viajes;
        }
        else {
            response.close();
            throw new WebApplicationException("Error detctado al obtener los viajes del origen " + origen);
        }
    }

    public JSONObject reservaViaje(String codviaje, String codcli){
        Response response = cliente.target(URI).path("reserva/").queryParam("codcli",  codcli).queryParam("codviaje", codviaje).request(MediaType.APPLICATION_JSON).put(Entity.text(""));
        JSONObject viaje = response.readEntity(JSONObject.class);
        return viaje;
    }

    public JSONObject anulaReserva(String codviaje, String codcli){
        Response response = cliente.target(URI).path("anulacion/").queryParam("codcli",  codcli).queryParam("codviaje", codviaje).request(MediaType.APPLICATION_JSON).delete();
        JSONObject viaje = response.readEntity(JSONObject.class);
        return viaje;
    }

    public JSONObject ofertaViaje(String codcli, String origen, String destino, String fecha, long precio, long numplazas){
        Response response = cliente.target(URI).path("oferta/").queryParam("codcli",  codcli).queryParam("origen", origen).queryParam("destino", destino).queryParam("fecha", fecha).queryParam("precio", precio).queryParam("numplazas", numplazas).request(MediaType.APPLICATION_JSON).post(Entity.text(""));
        JSONObject viaje = response.readEntity(JSONObject.class);
        return viaje;
    }
    public JSONObject borraViaje(String codviaje, String codcli){
        Response response = cliente.target(URI).path("borrado/").queryParam("codcli",  codcli).queryParam("codviaje", codviaje).request(MediaType.APPLICATION_JSON).delete();
        JSONObject viaje = response.readEntity(JSONObject.class);
        return viaje;
    }

}
