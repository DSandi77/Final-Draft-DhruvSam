package ca_1;

public class MovieShop {

  public static ArrayList < Movie > movies;
  public static ArrayList<Actor> actors;
  public static ArrayList < ActorWithMovie > characters;

  // Starting Array list of Movies
  public MovieShop() {
    movies = new ArrayList < Movie > ();
    actors = new ArrayList < Actor > ();
    characters = new ArrayList < ActorWithMovie > ();
  }

  // the number of items in the array s
  public int numberOfMovies() {
    return movies.size();
  }

  public int numberOfActors() {
    return actors.size();
  }

  public int numberOfCharacters() {
    return characters.size();
  }

  // adding a new items to the array
  public boolean addActor(Actor actor) {
    actors.add(actor);
    return true;
  }

  public boolean addMovie(Movie movie) {
    movies.add(movie);
    return true;
  }

  public void addCharacters(ActorWithMovie character) {
    characters.add(character);
  }

  // deleting a movie from the array by index number and returning the movie to be
  // accessed later
  public Movie removeMovie(int index) {
    Movie movieToBeRemoved = movies.get(index);
    movies.remove(movieToBeRemoved);
    return movieToBeRemoved;
  }

  public boolean deleteMovieByIndex(int i) {
    movies.remove(i);
      return true;
  }

  public boolean deleteActorByIndex(int i) {
    actors.remove(i);
      return true;
  }

  public ActorWithMovie deleteCharacterByIndex(int index) {
    ActorWithMovie characterToBeRemoved = characters.get(index);
    characters.remove(characterToBeRemoved);
    return characterToBeRemoved;
  }

  //		public boolean deleteCharacterByIndex(int i) {
  //	      characters.remove(i);
  //		    return true;
  //		}

  // getter methods for the arrays
  public static ArrayList < Movie > getMovies() {
    return movies;
  }

  public static ArrayList < Actor > getActor() {
    return actors;
  }

  public static ArrayList < ActorWithMovie > getCharacters() {
    return characters;
  }

  // Display the list of movie names with return if none found
//  public String displayListOfMoviesNames() {
//    if (movies.size() == 0) {
//      return "No movies are in the system";
//    } else {
//      String listOfMovieNames = "";
//
//      for (int i = 0; i < movies.size(); i++) {
//        int movieCounter = i;
//        if (movies.get(i).getTitle() != null)
//          listOfMovieNames += "Below is a list of movies in the system : " + "\n\n" + "Movie(" +
//          movieCounter + ") " + movies.get(i).getTitle() + "\n";
//      }
//      return listOfMovieNames;
//    }
//  }

  public String listOfMoviesNames() {
    String listOfMovieNames = "";

    if (movies.size() == 0) {
      return "No movies are in the system";
    } else {

      for (int i = 0; i < movies.size(); i++) {
        listOfMovieNames += movies.get(i).getTitle() + "\n";
      }
    }
    return listOfMovieNames;
  }

  public String listOfMoviesNamesPlusYear() {
    String listOfMovieNames = "";

    if (movies.size() == 0) {
      return "No movies are in the system";
    } else {

      for (int i = 0; i < movies.size(); i++) {
        listOfMovieNames += movies.get(i).getTitle() + " released in the year" +
          movies.get(i).getYearOfRelease() + "\n";
      }
    }
    return listOfMovieNames;
  }

  // display movie details
  public String displayMovieDetails(String name) {
    if (movies.size() == 0) {
      return "No movies are in the system";
    } else {
      String listOfMovieNames = "";

      for (int i = 0; i < movies.size(); i++) {
        int movieCounter = i + 1;
        if (movies.get(i).getTitle() != null)
          listOfMovieNames += movieCounter + ") " + movies.get(i).getTitle() +
          movies.get(i).getYearOfRelease() + movies.get(i).getRunningTime() +
          movies.get(i).getGenre() + movies.get(i).getPlot() + "\n";
      }
      return listOfMovieNames;
    }
  }

  // Display movies by Genre
  public String displayListOfMoviesGenre() {
    if (movies.size() == 0) {
      return "No movies are in the system";
    } else {
      String listOfMoviesGenre = "";

      for (int i = 0; i < movies.size(); i++) {
        if (movies.get(i).getGenre() != null)
          listOfMoviesGenre += "A list of Movies by and their Genre: " + movies.get(i).getTitle() + "'s genre = " + movies.get(i).getGenre() + "\n";
      }
      return listOfMoviesGenre;
    }
  }

  // Display movies by year
  public String displayListOfMoviesYear() {
    if (movies.size() == 0) {
      return "No movies are in the system";
    } else {
      String listOfMoviesYearOfRelease = "";

      for (int i = 0; i < movies.size(); i++) {
        listOfMoviesYearOfRelease += "A list of Movies by and their Genre: " + movies.get(i).getTitle() + "'s year of release = " + movies.get(i).getYearOfRelease() + "\n";
      }
      return listOfMoviesYearOfRelease;
    }
  }

  public String searchByYear(int year) {
      String list = "";
      for (Movie movie : movies) {
	  if (movie.getYearOfRelease() == year) {
	      list += movie.getTitle();
	  }
      }
      return list;
  }

  // searcher method
  public String searchByName(String name) {
      Movie movieToBeReturned = null;
      for (Movie movie : movies) {
	  if (movie.getTitle().toUpperCase().contains(name.toUpperCase())) {
	      movieToBeReturned = movie;
	  }
      }
      // return name + movieToBeReturned.toString();
      return "We have found a movie matching your search of (" + name + ") , here are the details: " + "\n "
	      + movieToBeReturned.toString();
  }

  // searcher method
  public Movie searchName(String name) {
    Movie movieToBeReturned = null;
    for (Movie movie: movies) {
      if (movie.getTitle().toUpperCase().contains(name.toUpperCase())) {
        movieToBeReturned = movie;
      }
    }
    return movieToBeReturned;
  }

  public Actor searchActorName(String name) {
      Actor actorToBeReturned = null;
      for (Actor actor : actors) {
	  if (actor.getName().toUpperCase().contains(name.toUpperCase())) {
	      actorToBeReturned = actor;
	  }
      }
      return actorToBeReturned;
  }

  public ActorWithMovie searchCharacterName(String name) {
      ActorWithMovie characterToBeReturned = null;
      for (ActorWithMovie character : characters) {
	  if (character.getCharacter().toUpperCase().contains(name.toUpperCase())) {
	      characterToBeReturned = character;
	  }
      }
      return characterToBeReturned;
  }

  // sorter methods
  public void sortByTitle() {
    for (int i = movies.size() - 1; i >= 0; i--) {
      int highestIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (movies.get(j).getTitle().compareTo(movies.get(highestIndex).getTitle()) > 0) {
          highestIndex = j;
        }
      }
      swapProducts(movies, i, highestIndex);
    }
  }

  // sort by genre
  public void sortByGenre() {
    for (int i = movies.size() - 1; i >= 0; i--) {
      int highestIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (movies.get(j).getGenre().compareTo(movies.get(highestIndex).getGenre()) > 0) {
          highestIndex = j;
        }
      }
      swapProducts(movies, i, highestIndex);
    }
  }

  // Sort by Year
  public void sortByYear() {
    for (int i = movies.size() - 1; i >= 0; i--) {
      int highestIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (movies.get(j).getYearOfRelease() < movies.get(highestIndex).getYearOfRelease()) {
          highestIndex = j;
        }
      }
      swapProducts(movies, i, highestIndex);
    }
  }

  /**
   * Actor Methods
   * 
   * @return
   */

  // Display the list of actor names with return if none found
  public String displayListOfActorNames() {
    if (actors.size() == 0) {
      return "No movies are in the system";
    } else {
      String listOfActorNames = "";

      for (int i = 0; i < movies.size(); i++) {
        int actorCounter = i + 1;
        if (movies.get(i).getTitle() != null)
          listOfActorNames += "Actor(" + actorCounter + ")" + actors.get(i).getName() + "\n";
      }
      return listOfActorNames;
    }
  }



  /**
   * Character Methods
   * 
   * @return
   */

  // Display the list of character names with return if none found
  public String displayListOfCharacterNames() {
    if (actors.size() == 0) {
      return "No movies are in the system";
    } else {
      String listOfCharacterNames = "";

      for (int i = 0; i < movies.size(); i++) {
        int characterCounter = i + 1;
        if (movies.get(i).getTitle() != null)
          listOfCharacterNames += "Actor(" + characterCounter + ")" + actors.get(i).getName() +
          "\n";
      }
      return listOfCharacterNames;
    }
  }



  private void swapProducts(ArrayList < Movie > movies, int i, int j) {
    Movie smaller = movies.get(i);
    Movie bigger = movies.get(j);

    movies.set(i, bigger);
    movies.set(j, smaller);
  }


  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	//searcher method
//public Actor searcActorhName(String name) {
//    Actor actorToBeReturned = null;
//    for (Actor actor : actors) {
//	  if (actor.getName().toUpperCase().contains(name.toUpperCase())) {
//		  actorToBeReturned = actor;
//	  }
//    }
//    return actorToBeReturned;
//    //return "We have found a movie matching your search of (" + name + ") , here are the details: "  + "\n " + movieToBeReturned.toString();
//}

  /*
   * This method should look for the index of both movie and actor and print it
   * out. Since we are matching an actor to a movie and the link is the character
   * name we should look at the character Array and print out the Actor class and
   * the Movie class names.
   */
//  public String displayCharactersAndActors() {
//    if (characters.size() == 0) {
//      return "No movies/actors are in the system";
//    } else {
//      String listOfActors = "";
//
//      for (int i = 0; i < characters.size(); i++) {
//        if (characters.get(i).getMovie() != null)
//          listOfActors += "The list of actors in the system are: " +
//          characters.get(i).getMovie().toString() +
//          characters.get(i).getActor().toString() + "\n";
//      }
//      return listOfActors;
//    }
//  }

//  public String displayMovieDetailsWithActors(Movie movie) {
//    String movieDetails = "";
//    String listOfActors = "";
//
//    if (movies.size() == 0) {
//      return "No movies linked with Characters/Actors database";
//
//    } else {
//      for (int i = 0; i < movies.size(); i++) {
//        if (characters.get(i).getMovie() == movie) {
//          movieDetails += "Movie()" + movies.get(i).getTitle() + movies.get(i).getYearOfRelease() +
//            movies.get(i).getRunningTime() + movies.get(i).getGenre() +
//            movies.get(i).getPlot() + "\n";
//        }
//      }
//    }
//
//    if (characters.size() == 0) {
//      listOfActors = "There are no actors/characters under that movie";
//
//    } else {
//
//      for (int i = 0; i < characters.size(); i++) {
//        if (characters.get(i).getMovie() == movie) {
//          listOfActors += "List of actors and their roles: " + "/n" +
//            characters.get(i).getActor().toString() +
//            characters.get(i).getCharacter().toString();
//        }
//      }
//    }
//
//    return movieDetails + listOfActors;
//  }

}