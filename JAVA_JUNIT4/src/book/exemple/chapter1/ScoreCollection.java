package book.exemple.chapter1;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
	private List<Scoreable> scores = new ArrayList<Scoreable>();
	
	public void add(Scoreable scoreable) {
		scores.add(scoreable);
	}
	
	public int arithmeticMean() {
		int total = scores.stream().mapToInt(Scoreable::getScore).sum();
		return total / scores.size();
	}
}
