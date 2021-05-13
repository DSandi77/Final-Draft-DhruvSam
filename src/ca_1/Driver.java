package ca_1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;



public class Driver {
    private MovieShop store;

    public Driver() {
	store = new MovieShop();
	runMenu();

    }

    public static void main(String[] args) {
	new Driver();

    }

    private int mainMenu() {
	int num;
	System.out.println("Welcome to XtraVision");
	System.out.println("---------");
	System.out.println("  1) Add a movie to the system"); // this one is done
	System.out.println("  2) Remove a movie from the system"); // this one is done
	System.out.println("  3) More options"); // need to do it
	System.out.println("  4) Display a list of movies in the system"); // Need to finish the method
	System.out.println("  --------------------");
	System.out.println("  5) Add an actor to the system"); // done
	System.out.println("  6) Remove an actor from the system"); // done
	System.out.println("  7) Add an actor to a movie"); // done
	System.out.println("  8) Remove an actor from a movie"); // done
	System.out.println("  --------------------");
	System.out.println("  9) Search movie by name");
	System.out.println(" 10) Update Movie Plot");
	System.out.println("  --------------------");
	System.out.println(" 11) Save movies to xml");
	System.out.println(" 12) Load movies from xml");
	System.out.println("  --------------------");
	System.out.println("  0) Exit");
	System.out.println(" ");

	num = EasyScannerInput.readNextInt("Please enter your menu option here >>>  ");

	System.out.println(" ");
	return num;

    }

    private void runMenu() {

	int option = mainMenu();
	while (option != 0) {

	    switch (option) {
	    case 1:
		addMovie();
		break;
	    case 2:
		removeMovie();
		break;
	    case 3:
		movieDetails();
		break;
	    case 4:
		displayMovieList();
		break;
	    case 5:
		addActorToTheSystem();
		break;
	    case 6:
		removeActorFromTheSystem();
		break;
	    case 7:
		addActorToAMovie();
		break;
	    case 8:
		removeActorFromMovie();
		break;
	    case 9:
		searchMovieByName();
		break;
	    case 10:
	    updateMoviePlot();
		break;
	    case 11:
	    	try {
				save();
				System.out.print("Saved to XML");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
	    case 12:
	    	try {
				load();
				System.out.print("XML Uploaded");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		break;
	    default:
		System.out.println("Invalid option entered: " + option);
		break;
	    }

	    System.out.println("\nPress any key to continue...");
	    EasyScanner.nextString();

	    option = mainMenu();
    }

    }


	/**
     * These are the methods for the movies.
     * 
     * @param store
     */
    public void addMovie() {
    	System.out.println("----------Adding a Movie--------- " + "\n");
    	System.out.print("Enter movie title: ");
	    String title = EasyScanner.nextString();

	System.out.print("Enter year of release: ");
	int yearOfRelease = EasyScanner.nextInt();

	System.out.print("Enter the running time: ");
	Float runningTime = EasyScanner.nextFloat();

	System.out.print("Enter the movies genre: ");
	String genre = EasyScanner.nextString();

	System.out.print("Add a short plot for the movie: ");
	String plot = EasyScanner.nextString();

	Movie newMovie = new Movie(title, yearOfRelease, runningTime, genre, plot);
	boolean answer = this.store.addMovie(newMovie);
	if (answer) {
	    System.out.println(title + " was added successfully" + "\n");
	} else {
	    System.out.println("Movie was not added succesfully, Please try again");
	}

    }

    @SuppressWarnings("static-access")
    public void removeMovie() {
	System.out.println(this.store.listOfMoviesNames());
	if (store.movies.size() > 0) {
	    System.out.print("Enter the index of the movie to delete ==> ");
	    int index = EasyScanner.nextInt();
	    if (index >= 0 && index < store.movies.size()) {
		boolean deleteMovie = store.deleteMovieByIndex(index);
		if (deleteMovie) {
		    System.out.println("Movie Deleted.");
		} else {
		    System.out.println("There is no movie under that index number." + "\n" + "Please try again.");
		}
	    } else {
		System.out.println("There is no movie under that index number." + "\n" + "Please try again.");

	    }
    }
    }

    public void addActorToTheSystem() {
    	System.out.println("----------Adding an Actor to the System--------- "+ "\n");
	System.out.print("Add a short name for the actor: ");
	String name = EasyScanner.nextString();

	System.out.print("Add a DOB for the actor: ");
	String dob = EasyScanner.nextString();

	System.out.print("Add a gender for the actor: ");
	String gender = EasyScanner.nextString();

	System.out.print("Add a nationality for the actor: ");
	String nationality = EasyScanner.nextString();

	Actor newActor = new Actor(name, dob, gender, nationality);

	store.addActor(newActor);

	System.out.println(name + " has been added succesfully to the system");

    }

    @SuppressWarnings("static-access")
    public void removeActorFromTheSystem() {
    	System.out.println("----------Removing an Actor from the System--------- "+ "\n");
	System.out.println(store.displayListOfActorNames());
	if (store.actors.size() > 0) {
	    System.out.print("Enter the index of the character to delete ==> ");
	    int index = EasyScanner.nextInt();
	    if (index >= 0 && index < store.getActor().size()) {
		boolean deleteActor = store.deleteActorByIndex(index);
		if (deleteActor) {
		    System.out.println("Actor Deleted.");
		} else {
		    System.out.println("There is no actor under that index number." + "\n" + "Please try again.");
		}
	    }
    }
    }

    public void addActorToAMovie() {
    	System.out.println("----------Adding Actor to Movie--------- "+ "\n");
	System.out.print("Enter the name of the actor to add ==> ");
	String name = EasyScanner.nextString();
	Actor actor = store.searchActorName(name);
	if (actor == null) {
	    System.out.println("No actor by that name in the system");
	} else {
	    System.out.print("Enter the name of the movie " + name + " starred in:" + "\n");
	    String movieName = EasyScanner.nextString();
	    Movie movie = store.searchName(movieName);
	    if (movie == null) {
		System.out.println("No movie by that name in the system");
	    } else {
		movie.addActorToMovie(actor);
		System.out.print(name + " was added successfully to " + movieName + "\n");

	    }

	    System.out.println("Now please add the character " + name + " played in " + movieName + ": ");
	    String characterName = EasyScanner.nextString();

	    ActorWithMovie newCharacter = new ActorWithMovie(actor, characterName, movie);
	    movie.addCharacterToMovie(newCharacter);

	    System.out.println(name + " played " + newCharacter.getCharacter() + " in " + movie.getTitle() + "\n");

    }

    }

    @SuppressWarnings("static-access")
    public void removeActorFromMovie() {
	System.out.print("Enter the name of the movie the actor you want to remove starred in:" + "\n");
	String movieName = EasyScanner.nextString();
	Movie movie = store.searchName(movieName);
	if (store.movies.size() > 0) {
	    System.out.print("Enter the name of the actor to delete ==> ");
	    String name = EasyScanner.nextString();
	    Actor actor = store.searchActorName(name);
	    if (actor == null) {
		System.out.println("No actor by that name in the system");
	    } else {
		movie.removeActorFromMovie(actor);

	    }
	}
    }

    public void addCharacterToAMovie() {

	System.out.print("Enter the name of the character to add ==> ");
	String name = EasyScanner.nextString();
	ActorWithMovie character = store.searchCharacterName(name);
	if (character == null) {
	    System.out.println("No character by that name in the system");
	} else {
	    System.out.print("Enter the name of the movie " + name + " is in:" + "\n");
	    String movieName = EasyScanner.nextString();
//	    System.out.println("Enter the name of the actor that played " + name + "\n");
//	    String actorName = EasyScanner.nextString();
	    Movie movie = store.searchName(movieName);
//	    Actor actor = store.searchActorName(actorName);
	    if (movie == null) {
		System.out.println("No movie by that name in the system");
	    } else {
//		actor.addCharacterToActor(character);
		movie.addCharacterToMovie(character);
		;
		System.out.print(name + " was added successfully to " + movieName + "\n");

	    }

	}
    }

    @SuppressWarnings("static-access")
    public void removeCharacterFromMovie() {
	System.out.print("Enter the name of the movie the character you want to remove was in:" + "\n");
	String movieName = EasyScanner.nextString();
	Movie movie = store.searchName(movieName);
	if (store.movies.size() > 0) {
	    System.out.print("Enter the name of the character to delete ==> ");
	    String name = EasyScanner.nextString();
	    ActorWithMovie character = store.searchCharacterName(name);
	    if (character == null) {
		System.out.println("No character by that name in the system");
	    } else {
		movie.removeCharacterFromMovie(character);
		;

	    }
	}
    }

    // @SuppressWarnings("static-access")
    // public void addCharacter() {
    // Movie newMovie = null;
    // Actor newActor = null;
    // // we are looking to add the movie to Characters
    // System.out.println(this.store.displayListOfMoviesNames());
    // if (store.getMovies().size() >= 0) {
    // System.out.print("Add the movie: ");
    // String addMovie = EasyScanner.nextString();
    // newMovie = this.store.searchName(addMovie);
    // System.out.println("Movie added!");
    // } else {
    // System.out.println("There are no movies in the system");
    // }
    //
    // // adding actor and movie to character
    // System.out.println(this.store.displayListOfActorNames());
    // if (store.getActor().size() >= 0) {
    // System.out.print("Add the actor: ");
    // String addActor = EasyScanner.nextString();
    // newActor = this.store.searcActorhName(addActor);
    // System.out.println("Actor added!");
    // } else {
    // System.out.println("There are no actors in the system");
    // }
    // // add characters
    // System.out.print("Add the character name of the actor: ");
    // String character = EasyScanner.nextString();
    //
    // store.addCharacters(new ActorWithMovie(newActor, newMovie, character));
    //
    // }
    //
    // @SuppressWarnings("static-access")
    // public void removeCharacter() {
    // System.out.println(this.store.displayListOfCharacterNames());
    // if (store.characters.size() >= 0) {
    // System.out.print("Enter the index of the character to delete ==> ");
    // int index = EasyScanner.nextInt();
    // if (index >= 0 && index < store.getCharacters().size()) {
    // ActorWithMovie deleteCharacter = store.deleteCharacterByIndex(index);
    // System.out.println(deleteCharacter.getCharacter() + " was deleted
    // succesfully");
    //
    // }
    // }
    // }

    public void searchMovieByName() {
	System.out.print("Please enter the movie name to search: ");
	String searchByName = EasyScanner.nextString();
	String thisMovie = store.searchByName(searchByName);
	System.out.println(thisMovie);
    }

    public void displayMovieList() {
	String movieList = store.listOfMoviesNames();
	System.out.print(movieList);
    }

    public void movieDetails() {
	System.out.println();
	System.out.println("Welcome to XtraVision");
	System.out.println("---------");
	System.out.println("  1) Add a movie to the system");
	System.out.println("  2) Remove a movie from the system");
	System.out.println("  3) More options");
	System.out.println("    a. Search and display details of a movie by name");
	System.out.println("    b. Sort movies in the system alphabetically");
	System.out.println("    c. Sort movies by year of release (ASC) ");
	System.out.println("    d. Display movie and its actors and characters ");
	System.out.println("  4) Display a list of movies in the system"); // Need to finish the method
	System.out.println("  --------------------");
	System.out.println("  5) Add an actor to the system"); // done
	System.out.println("  6) Remove an actor from the system"); // done
	System.out.println("  7) Add a Movie Character in the system"); // done
	System.out.println("  8) Remove a Movie Character from the system"); // done
	System.out.println("  --------------------");
	System.out.println(" 9) Search movie by name");
	System.out.println("  --------------------");
	System.out.println(" 10) Save movies to xml");
	System.out.println(" 11) Load movies from xml");
	System.out.println("  --------------------");
	System.out.println("  0) Exit");
	System.out.println(" ");
	System.out.print("Please enter choice[a-d Only]: ");
	char choice = EasyScanner.nextChar();
	System.out.println();
	if (choice == 'a') {
	    System.out.println();
	    System.out.print("Enter Movie name: ");
	    String movieName = EasyScanner.nextString();
	    if (movieName == null) {
		System.out.println("No such Movie exists");
	    } else {
		Movie movie = store.searchName(movieName);
		String movieDetails = movie.toString();
		System.out.print(movieDetails);
	    }
	} else if (choice == 'b') {
	    store.sortByTitle();
	    System.out.println(store.listOfMoviesNames());
	} else if (choice == 'c') {
	    store.sortByYear();
	    System.out.println(store.listOfMoviesNamesPlusYear());
	} else if (choice == 'd') {
	    System.out.println("Here is a list of all the movies in the system: ");
	    System.out.println(store.listOfMoviesNames());
	    System.out.println("");
	    System.out.println("Please enter the name of a movie you would like to see more info on");
	    String usersChoice = EasyScanner.nextString();
	    Movie movie = store.searchName(usersChoice);
	    if (movie.getActors() == null) {
		System.out.println("This movie has no actors in added to it yet");
	    } else {
		String result = movie.printActors() + " played " + movie.printCharacters() + " in this movie";
		if (store.listOfMoviesNames().contains(usersChoice)) {
		    System.out.println(
			    "Here are all the actors that starred in this movie and the character they played");
		    System.out.println("");

		    System.out.println(result);
		} else {
		    System.out.println("No movie by that name exists just yet");
		}
	    }

	} else {
	    System.out.println("Please choose a letter between a-c");
	}

    }
	
	/*
	 * These are the XML methods
	 */

	 @SuppressWarnings("static-access")
	public void save() throws Exception {
		  XStream xstream = new XStream(new DomDriver());
		  xstream.addPermission(NoTypePermission.NONE);
		  ObjectOutputStream out = xstream.createObjectOutputStream
		  (new FileWriter("MovieShop.xml"));
		  out.writeObject(store.movies);
		  out.writeObject(store.actors);
		  out.writeObject(store.characters);
		  out.close();
		  }

		  @SuppressWarnings("unchecked")
		public static void load() throws Exception {
		  XStream xstream = new XStream(new DomDriver());
		  xstream.addPermission(NoTypePermission.NONE);
		  xstream.allowTypesByRegExp(new String[] { ".*" });
		  ObjectInputStream is = xstream.createObjectInputStream
		  (new FileReader("MovieShop.xml"));
		  MovieShop.movies = (ArrayList<Movie>) is.readObject();
		  MovieShop.actors = (ArrayList<Actor>) is.readObject();
		  MovieShop.characters = (ArrayList<ActorWithMovie>) is.readObject();
		  is.close();
		  }

	
}
}
