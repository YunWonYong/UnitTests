package book.exemple.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persion {
	private List<Question> characteristics = new ArrayList<>();

	public Persion() {
	}
	
	public void add(Question charactoristic) {
		characteristics.add(charactoristic);
	}
	
	public List<Question> getCharacteristics() {
		return characteristics;
	}
	
	public List<Question> withCharacteristic(String questionPattern) {
		return characteristics.stream()
				.filter( 
					c -> c.getText().endsWith(questionPattern)
				).collect(Collectors.toList());
	}
}
