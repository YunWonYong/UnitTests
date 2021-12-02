package book.exemple.chapter2.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import book.exemple.chapter2.Answer;
import book.exemple.chapter2.Bool;
import book.exemple.chapter2.BooleanQuestion;
import book.exemple.chapter2.Criteria;
import book.exemple.chapter2.Criterion;
import book.exemple.chapter2.Profile;
import book.exemple.chapter2.Weight;


public class ProfileTest3 {
	
	private Profile profile;
	private BooleanQuestion question;
	private Criteria criteria; 
	
	@Before
	public void create() {
		this.profile = new Profile("Bull Hockey, Inc.");
		this.question = new BooleanQuestion(1, "Got bonuses ?");
		this.criteria = new Criteria();
	}
	
	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
		assertFalse(profile.matches(criteria));
	}
	
	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
		assertTrue(profile.matches(criteria));
	}
}
