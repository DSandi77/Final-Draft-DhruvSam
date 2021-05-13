package ca_1;

    public class ActorWithMovie {



	private Actor actor;
    	private String character;
	private Movie movie;


	public ActorWithMovie(Actor actor, String character, Movie movie) {
    		this.actor = actor;
    		this.character = character;
		this.movie = movie;
    	}

    	
    	public Actor getActor() {
    		return actor;
    	}
    	
    	public void setActors(Actor actor) {
    		this.actor = actor;
    	}
    	
    	
    	public String getCharacter() {
    		return character;
    	}
    	
    	public void setCharacter(String character) {
    		this.character = character;
    	}

	public Movie getMovie() {
	    return movie;
	}

	public void setMovie(Movie movie) {
	    this.movie = movie;
	}


	@Override
	public String toString() {
	    return "ActorWithMovie [actor=" + actor.getName() + ", character=" + character + "]";
	}

    }


