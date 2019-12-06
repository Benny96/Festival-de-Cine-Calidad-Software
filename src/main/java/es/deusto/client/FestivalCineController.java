package es.deusto.client;

import es.deusto.client.gui.MenuAnonimo;
import es.deusto.client.remote.ServiceLocator;
import es.deusto.server.data.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del patrón de diseño Controller. Este bloque de código es quien coordina las funciones a proveer
 * para la interfaz del cliente, y está conectado con el ServiceLocator, el cual toma la información de la parte
 * servidora de la aplicación.
 * @author Grupo RMBJ
 * @version 2.0
 * @since 1.0
 */
public class FestivalCineController {

	private static FestivalCineController instance;
	private ServiceLocator rsl;
	private Client client;
	private WebTarget webTarget;

	public static FestivalCineController getInstance() {
		return instance;
	}

	private FestivalCineController(String[] args) {
		instance = this;

		rsl = new ServiceLocator();
		rsl.setService(args);
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/server", args[0], args[1]));
		//TODO: Modificar por Menu, dado que un usuario no tiene por qué estar registrado para usar la aplicación.
		//TODO: Sin embargo, este NO PODRÁ COMENTAR.
		//Inicio frame = new Inicio();
		//frame.setVisible(true);
		MenuAnonimo frame = new MenuAnonimo();
		frame.setVisible(true);
	}
	//TODO: TODAS LAS COSAS PUESTAS A CONTINUACION EN ESTE METODO SE MANTIENEN PARA AYUDAR EN EL TESTEO Y DEBUG.
	public void generateFixtures(){

		// TODO: Pensar manera de meter primer usuario como admin.
		System.out.println("Generating Fixtures when beginning execution:");
		System.out.println("_____________________________________________");
		System.out.println("Register a user for the first time: admin");
		FestivalCineController.getInstance().registerUser("admin", "admin");
		System.out.println("Change the password as the user is already registered: admin");
		FestivalCineController.getInstance().registerUser("admin", "admin");
		System.out.println("* Message coming from the server: '"
				+ FestivalCineController.getInstance().sayMessage("admin", "admin", "This is test 1!") + "'");
		System.out.println("* Message coming from the server: '"
				+ FestivalCineController.getInstance().sayMessage("admin", "admin", "This is test 2!") + "'");

		MessageList messages = FestivalCineController.getInstance().getUserMessages("admin");
		for (Message m : messages.getMessages()) {
			System.out.println(m);
		}

		//TODO: SE VA A SUPRIMIR LA PERSISTENCIA DE ACTORES DIRECTAMENTE PARA PERSISTIRLOS CUANDO HAYA PELICULAS.
		//TODO: SE PODRIA PENSAR EN UNA "CACHE" DE ACTORES PARA DESPUES PERSISTIRLOS EN PELICULAS. ESTA "CACHE" SERIA
		//TODO: UNA NUEVA CLASE PARA ACTORES (POR EJEMPLO, ACTORCASTINGDTO).
		System.out.println("Registering some peliculas:");
		List<ActorDTO> randomActors = new ArrayList<ActorDTO>();
//		randomActors.add(new ActorDTO("ID1", "Nicholas", "Cage", 50));
//		randomActors.add(new ActorDTO("ID2", "Perico", "Cage", 120));

		System.out.println("Registering an actor for the first time: Nicholas Cage");
		FestivalCineController.getInstance().registerActor("ID1", "Nicholas", "Cage", 50);
		FestivalCineController.getInstance().registerActor("ID1", "Pepe", "Juanito", 57);
		FestivalCineController.getInstance().registerActor("ID2", "Perico", "Cage", 120);


		//TODO: MOLARIA PODER USAR EL ID DEL ACTOR PARA BUSCARLO... EXTRA.
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(1));

		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
						" mayores clasicos de la historia", "drama",145, 1935,"Alguien","MIURL",
				"Muchos y variados","clasicos",randomActors);
		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
						" mayores clasicos de la historia", "drama",145, 1954,"Alguien","MIURL",
				"Muchos y variados","clasicos",randomActors);

		randomActors.clear();
//		randomActors.add(new ActorDTO("ID3", "Mufasa", "Mufasa", 5));
//		randomActors.add(new ActorDTO("ID4", "Timon", "Timon", 6));
//		randomActors.add(new ActorDTO("ID5", "Pumba", "Pumba", 7));

		FestivalCineController.getInstance().registerActor("ID3", "Mufasa", "Mufasa", 5);
		FestivalCineController.getInstance().registerActor("ID4", "Timon", "Timon", 6);
		FestivalCineController.getInstance().registerActor("ID5", "Pumba", "Pumba", 7);

		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(2));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula("El Rey Leon","Otro de los" +
						" mayores clasicos de la historia", "drama",121, 1985,"Alguien","MIURL",
				"Muchos y variados","clasicos",randomActors);

		randomActors.clear();
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula("La Comedia","Otro de los" +
						" mayores clasicos de la historia", "comedia",97, 2019,"Yo mismo","MIURL",
				"Muchos y variados","novedades",randomActors);
		System.out.println("Fixtures generated successfully.");
		System.out.println("_____________________________________________");
	}

	public void registerUser(String login, String password) {
		rsl.registerUser(login,password);
	}
	public String sayMessage(String login, String password, String message) {
		return rsl.sayMessage(login,password, message);
	}
	public UsuarioDTO getUser(String login, String pwd) {
		return rsl.getUser(login, pwd);
	}
	public MessageList getUserMessages(String login) {
		return rsl.getUserMessages(login);
	}
	public void registerActor(String id, String nombre, String apellido, int edad) {
		rsl.registerActor(id,nombre,apellido,edad);
	}
	public ActorList getActorList() {
		return rsl.getActorList();
	}
	public void registerPelicula(String titulo, String sinopsis, String genero, int duracion, int anyo,
								 String director, String enlacetrailer, String premios, String seccion,
								 List<ActorDTO> actores) {
		rsl.registerPelicula(titulo,sinopsis,genero,duracion,anyo,director,enlacetrailer,premios, seccion, actores);
	}
	public PeliculaList getPeliculaList() {
		return rsl.getPeliculaList();
	}
	public void valorarPelicula (String titulo, float valoracion) throws NullPointerException {
		rsl.valorarPelicula(titulo, valoracion);
	}
	public ArrayList<String> getFiltros(String filtro) { return rsl.getFiltroList(filtro);}
	public PeliculaList getFilteredPeliculaList(String filtro, String criterio) {
		return rsl.getFilteredPeliculaList(filtro, criterio);
	}

	public void comentarPelicula (String titulo, String usuario, String contenido) throws NullPointerException {
		rsl.comentarPelicula(titulo, usuario, contenido);
	}

	public static void main(String[] args) {
		new FestivalCineController(args);
		FestivalCineController.getInstance().generateFixtures();
		if (args.length != 2) {
			System.out.println("Use: java Client.Client [host] [port]");
			System.exit(0);
		}
	}
}
