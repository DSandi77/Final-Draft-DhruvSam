package ca_1;

public class Movie {



    private String title;
    private int yearOfRelease;
    private float runningTime;
    private String genre;
    private String plot;

    // arrayList of actors in the movie
    private ArrayList<Actor> actors;

    private ArrayList<ActorWithMovie> characters;

    public Movie(String title, int yearOfRelease, float runningTime, String genre, String plot) {
	super();
	this.title = title;
	this.yearOfRelease = yearOfRelease;
	this.runningTime = runningTime;
	this.genre = genre;
	this.plot = plot;
	actors = new ArrayList<Actor>();
	characters = new ArrayList<ActorWithMovie>();
    }

    public ArrayList<Actor> getActors() {
	return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
	this.actors = actors;
    }

    public void addANewActorToMovie(String name, String dob, String gender, String nationality) {
	actors.add(new Actor(name, dob, gender, nationality));
    }

    public ArrayList<ActorWithMovie> getCharacters() {
	return characters;
    }

    public void setCharacters(ArrayList<ActorWithMovie> characters) {
	this.characters = characters;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public int getYearOfRelease() {
	return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
	this.yearOfRelease = yearOfRelease;
    }

    public float getRunningTime() {
	return runningTime;
    }

    public void setRunningTime(float runningTime) {
	this.runningTime = runningTime;
    }

    public String getGenre() {
	return genre;
    }

    public void setGenre(String genre) {
	this.genre = genre;
    }

    public String getPlot() {
	return plot;
    }

    public void setPlot(String plot) {
	this.plot = plot;
    }

    // public Image getPoster() {
    // return poster;
    // }
    //
    // public void setPoster(Image poster) {
    // this.poster = poster;
    // }

    // adds actor to arrayList

    public void addActorToMovie(Actor actor) {
	actors.add(actor);
    }

    public void removeActorFromMovie(Actor actor) {
	actors.remove(actor);
    }

    public void addCharacterToMovie(ActorWithMovie character) {
	characters.add(character);
    }

    public void removeCharacterFromMovie(ActorWithMovie character) {
	characters.remove(character);
    }

    public String printActors() {
	String list = "";
	// iterating over array
	for (int i = 0; i < actors.size(); i++) {
	    list += actors.get(i).getName();
	}
	return list;
    }

    public String printCharacters() {
	String list = "";
	// iterating over array
	for (int i = 0; i < actors.size(); i++) {
	    list += characters.get(i).getActor().getName();
	}
	return list;
    }

	@Override
	public String toString() {
	    return  "Title = " + title +"\n"+ 
		    "Year Of Release = " + yearOfRelease +"\n"+
		    "Running Time =" + runningTime +"\n"+
		    "Genre = " + genre +"\n"+ 
		    "Plot =" + plot + "\n"+
		    "Actors = " + printActors() + "\n" + "Characters = " + getCharacters().toString();
	}

}