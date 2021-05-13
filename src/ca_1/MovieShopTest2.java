package ca_1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieShopTest2 {

    private MovieShop testShop;
	private Movie testMovie;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {


	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	@BeforeEach
	void setUp() throws Exception {
	    testShop = new MovieShop();
	    System.out.print("PLEASE ADD 2 MOVIES TO THE TEST ARRAY" + "\n\n\n\n");

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

	    System.out.print("Add a short name for the actor: ");
	    String name = EasyScanner.nextString();
	    
	    System.out.print("Add a DoB for the actor: ");
	    String dob = EasyScanner.nextString();
	    
	    System.out.print("Add a gender for the actor: ");
	    String gender = EasyScanner.nextString();
	    
	    System.out.print("Add a nationality for the actor: ");
	    String nationality = EasyScanner.nextString();
	    
	    
	    testShop.addMovie(new Movie(title, yearOfRelease, runningTime, genre, plot));
	    System.out.print(title + " was added successfully" + "\n");

	    testShop.addActor(new Actor(name, dob, gender, nationality));
	    System.out.print("The actor " + name + " was added successfully" + "\n");
	    
	    
	    System.out.print("Enter movie title: ");
	    String title2 = EasyScanner.nextString();

	    System.out.print("Enter year of release: ");
	    int yearOfRelease2 = EasyScanner.nextInt();

	    System.out.print("Enter the running time: ");
	    Float runningTime2 = EasyScanner.nextFloat();

	    System.out.print("Enter the movies genre: ");
	    String genre2 = EasyScanner.nextString();

	    System.out.print("Add a short plot for the movie: ");
	    String plot2 = EasyScanner.nextString();

	    testShop.addMovie(new Movie(title2, yearOfRelease2, runningTime2, genre2, plot2));
	    System.out.print(title2 + " was added successfully" + "\n\n\n\n");

	    }

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test // WORKING
	void testAddMovie() {

	    for (int i = 0; i < 4; i++) {
		testShop.addMovie(testMovie);
	    }
	    assertEquals(testShop.numberOfMovies(), 4);
	}

	@Test // WORKING
	void testDeleteMovie() {
	    for (int i = 0; i < 4; i++) {
		testShop.addMovie(testMovie);
	    }
	    testShop.deleteMovieByIndex(0);
	    assertEquals(testShop.numberOfMovies(), 3);

	}

	@Test // WORKING
	void testSearchByTitle() {
	    String firstName = EasyScannerInput.validNextLine("Please enter the movies title you are searching for:");
	    System.out.println(testShop.searchByName(firstName));
	}

	@Test // WORKING
	void testSortByTitle() {
	    testShop.sortByTitle();
	    System.out.println(testShop.displayListOfMoviesNames());

	}

	@Test // WORKING
	void testSortByYear() {
	    testShop.sortByTitle();
	    System.out.println(testShop.displayListOfMoviesNames());

	}

	@Test
	void testDisplayListOfMoviesNames() {
	    System.out.println(testShop.displayListOfMoviesNames());
	}

	@Test
	void testDisplayListOfMoviesGenre() {
	    System.out.println(testShop.displayListOfMoviesGenre());
	}

	@Test
	void testDisplayListOfMoviesYear() {
	    System.out.println(testShop.displayListOfMoviesYear());

	}

	@Test
	void testDisplayMovieAndActors() {
	    fail("Not yet implemented");
	}


}