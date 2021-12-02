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


public class ProfileTest2 {
	
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
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
		criteria.add(criterion);
		assertFalse(profile.matches(criteria));
	}
	
	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
		criteria.add(criterion);
		assertTrue(profile.matches(criteria));
	}
}
