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
 * by Firat Sivrikaya.
 * 
 *
 */

public class HydrocarbonQ extends Question{
	
	final int UPPER_BOUND = 60;
	final int LOWER_BOUND = 41;
	
	public HydrocarbonQ()
	{
		super();
		
	}
	
	public Question askQuestion() throws SQLException
	{
		// Returns the next question with respect to the bounds
		return nextQuestion(LOWER_BOUND, UPPER_BOUND);
	}

}
