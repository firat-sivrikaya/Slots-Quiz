import java.sql.SQLException;
/**
 * 
 * 
 * CoinGeneratorQ
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
 * This is the database class which gets questions
 * from subject "Hydrocarbons" for coin generator
 * 
 * Upper and lower bounds for this subject are
 * defined as constants.
 * 
 * The questions from Hydrocarbons are written
 * by Firat Sivrikaya
 * 
 *
 */

public class CoinGeneratorQ extends Question{
	// constants
	final int UPPER_BOUND = 1;
	final int LOWER_BOUND = 20;
	// constructors
	public CoinGeneratorQ()
	{
		super();
		
	}
	// methods
	public Question askQuestion() throws SQLException
	{
		// Returns the next question with respect to the bounds
		return nextQuestion(LOWER_BOUND, UPPER_BOUND);
	}

}
