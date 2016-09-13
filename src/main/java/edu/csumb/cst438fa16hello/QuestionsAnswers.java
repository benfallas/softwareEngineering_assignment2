package edu.csumb.cst438fa16hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
*	A half-secretive map of	questions to answers (at most one answer per question).
*	Gives out random questions (keys) from the map,	and
* 	can	be queried to test if a	given question maps	to a given answer.
*/

public class QuestionsAnswers {
	ArrayList<String> answers;
	private HashMap<String, ArrayList<String>> questionsAnswers = new HashMap<String, ArrayList<String>>();

    public QuestionsAnswers() {
        put("What is 1 + 1?", "2");
        put("What is 2 * 2?", "4");
        put("what is 4 / 2?", "2");
    }

	/**
	 * Maps passed in question to a passed in answer.
	 * 
	 * @param question The question to be mapped to the answer.
	 * @param answer The answer to be mapped to the question.
	 */
	public void put(String	question,	String	answer)	{
		
		if (question == null || answer == null) {
			return;
		}
		
		if (!questionsAnswers.containsKey(question)) {
			ArrayList<String> answers = new ArrayList<String>();
			
			answers.add(answer);
			questionsAnswers.put(question, answers);
		} else {
			questionsAnswers.get(question).add(answer);
		}
	}
	
	/**
	 * Verifies if the given question maps to given answer.
	 * 
	 * @param question The question to query.
	 * @param answer The questions answer to verify.
	 * 
	 * @return {@true} if answer maps to question. {@false} otherwise.
	 */
	public boolean	testAnswer(String	question,	String	answer)	{	
	
		return questionsAnswers.get(question).contains(answer);
	}
	
	/**
	 * Provides a random question from the key set.
	 * 
	 * @return The randomly generated question.
	 */
	public String getRandomQuestion()	{	
		Random randomNumberGenerator = new Random();
		ArrayList<String> questions = new ArrayList<String>(questionsAnswers.keySet());
		
		int randomNumber = randomNumberGenerator.nextInt(questions.size());

		return questions.get(randomNumber);
	}

	/**
	 * Visible for Testing 
	 * 
	 * Returns the size of the hash map
	 * 
	 * @return The size of the hash map.
	 */
	public int getSize() {
		return questionsAnswers.size();
	}
}
