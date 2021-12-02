package book.exemple.chapter1.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import book.exemple.chapter1.ScoreCollection;

public class ScoreCollectionTest {

	@Test
	public void answersArithmeticMeanOfTwoNumbers() {
		ScoreCollection collection = new ScoreCollection();
		collection.add(()-> 5);
		collection.add(()-> 7);
		assertThat(collection.arithmeticMean(), is(6));
	}

}
