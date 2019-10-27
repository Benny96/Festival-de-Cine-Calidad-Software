package es.deusto.ingenieria.sd.eb.server.gateway;

/**
 * Variaci�n de Strategy hecha con Interfaz para login en vez de clase abstracta.
 * @author Be�at
 */
public interface IGatewayAuth {
	public int darAltaUsuario(String correo);
}
