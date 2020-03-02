package homework2;

public class ReservedMovie extends Movie { //SuperClass : Movie

	private int count = 0;

	public ReservedMovie() { //������
		super();
	}

	public ReservedMovie(Movie movie) { //������
		super(movie);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
