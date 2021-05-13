package ca_1;

public class Character {

    private Actor actor;
    private Movie movie;
    private String name;

    public Character(Actor actor, Movie movie, String name) {
		this.actor = actor;
		this.movie = movie;
		this.name = name;
	}

    public Actor getActor() {
	return actor;
    }

    public void setActors(Actor actor) {
	this.actor = actor;
    }

    public Movie getMovie() {
	return movie;
    }

    public void setMovie(Movie movie) {
	this.movie = movie;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "ActorWithMovie [actor=" + actor + ", movie=" + movie + ", name=" + name + "]";
    }
}
