import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		/*
		although the movie data could be supplied by the user,
		a database, an external file, etc., we are not
		focused on techniques to gather that data.
		in this assignment, we instead simulate having the data.
		*/
		
		ArrayList<String> allMovies = new ArrayList<String>();
		allMovies.add("The Shawshank Redemption,R,9.3");
		allMovies.add("The Godfather,R,9.2");
		allMovies.add("The Dark Knight,PG13,9.1");
		allMovies.add("The Godfather Part II,R,9.0");
		allMovies.add("The Lord of the Rings: The Return of the King,PG13,9.0");
		allMovies.add("12 Angry Men,NR,9.0");
		allMovies.add("Star Wars: Episode V - The Empire Strikes Back,PG,8.7");
		allMovies.add("Spirited Away,PG,8.6");
		allMovies.add("The Lion King,G,8.5");
		allMovies.add("Whiplash,R,8.5");
		allMovies.add("Spider-Man: Across the Spider-Verse,PG,8.5");
		allMovies.add("WALL-E,G,8.4");
		allMovies.add("Avengers: Infinity War,PG13,8.4");
		allMovies.add("Jaws: The Revenge,PG13,3.1");
		allMovies.add("Cats,PG,2.8");
		allMovies.add("Dragonball: Evolution,PG,2.5");
		allMovies.add("Disaster Movie,PG13,1.9");
		
		System.out.println("On which designation (G, PG, PG13, R, NR) do you want to filter?");
		String designation = scn.nextLine();
		
		double avg = filterMovies(allMovies, designation);
		
		for(String s : allMovies)
		{
			System.out.println(s.split(",")[0]);
		}
		
		System.out.println("Rating avg: " + avg);
		scn.close();
	}
	
	/**
	 * Receives a list of movies and removes those that do not 
	 * have the provided MPA designation (G, PG, PG13, R, NR).
	 * @param list - the input list of movies, represented by Strings
	 * @param designation - the target MPA rating to use as the filter
	 * @return the average review rating of the movies that match the designation
	 */
	public static double filterMovies(ArrayList<String> list, String designation)
	{
		double total = 0;
		int count = 0;
		for (int i = list.size() - 1; i >= 0; i--)
		{
			String[] movie = list.get(i).split(",");

			String mpaRating = movie[1];
			double audienceRating = Double.parseDouble(movie[2]);

			if(!mpaRating.equals(designation))
			{
				list.remove(i);
			}
			else 
			{
				total += audienceRating;
				count++;
			}
		}

		return total / count;
		

	}
}