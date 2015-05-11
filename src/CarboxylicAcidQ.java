import java.sql.SQLException;
/**
 * 
 * 
 * CarboxylicAcidQ
 * @author Firat Sivrikaya
 * @date 05/05/2015
 * 
 * This is the database class which gets question from
 * subject "Carboxylic acids".
 * 
 * Upper and lower bounds for this subject are defined on the code
 * as constants.
 * 
 * The questions from Carboxylic Acids are written by
 * Huseyin Beyan.
 * 
 *
 */

public class CarboxylicAcidQ extends Question{
	// constants
	final int UPPER_BOUND = 100;
	final int LOWER_BOUND = 81;
	// constructors
	public CarboxylicAcidQ()
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
