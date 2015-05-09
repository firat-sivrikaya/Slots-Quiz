import java.sql.SQLException;
/**
 * 
 * 
 * CoinGeneratorQ
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
 * This is the Coin Generator database class which gets questions
 * from subject "Hydrocarbons".
 * 
 * Upper and lower bounds for this subject are
 * defined as constants.
 * 
 * The questions in Coin Generator are written
 * by Firat Sivrikaya.
 * 
 *
 */

public class CoinGeneratorQ extends Question{
	
	final int UPPER_BOUND = 1;
	final int LOWER_BOUND = 20;
	
	public CoinGeneratorQ()
	{
		super();
		
	}
	
	public Question askQuestion() throws SQLException
	{
		// Returns the next question with respect to the bounds
		return nextQuestion(LOWER_BOUND, UPPER_BOUND);
	}

}
