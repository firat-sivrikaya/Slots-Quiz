import java.sql.SQLException;
/**
 * 
 * 
 * HydrocarbonQ
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
 * This is the database class which gets questions
 * from subject "Hydrocarbons".
 * 
 * Upper and lower bounds for this subject are
 * defined as constants.
 * 
 * The questions from Hydrocarbons are written
 * by Irmak Akkuzuluoglu.
 * 
 *
 */

public class CoinGeneratorQ extends Question{
	
	final int UPPER_BOUND = 21;
	final int LOWER_BOUND = 34;
	
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
