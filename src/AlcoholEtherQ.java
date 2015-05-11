import java.sql.SQLException;
/**
 * 
 * 
 * AlcoholEtherQ
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
 * This is the database class which gets questions
 * from subject "Alcohols Ethers".
 * 
 * Upper and lower bounds for this subject are
 * defined as constants.
 * 
 * The questions from Alcohols / Ethers are written
 * by Irmak Akkuzuluoglu.
 * 
 *
 */

public class AlcoholEtherQ extends Question{
	// constants
	final int UPPER_BOUND = 40;
	final int LOWER_BOUND = 21;
	// variables
	public AlcoholEtherQ()
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
