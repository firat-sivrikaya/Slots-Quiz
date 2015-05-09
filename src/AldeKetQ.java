import java.sql.SQLException;
/**
 * 
 * 
 * AldeKetQ
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
 * This is the database class which gets questions
 * from subject "Aldehydes and Ketones".
 * 
 * Upper and lower bounds for this subject are
 * defined as constants.
 * 
 * The questions from Aldehydes / Ketones are written
 * by Gokce Ozyurt.
 * 
 *
 */

public class AldeKetQ extends Question{
	
	final int UPPER_BOUND = 40;
	final int LOWER_BOUND = 21;
	
	public AldeKetQ()
	{
		super();
		
		
	}
	
	public Question askQuestion() throws SQLException
	{
		return nextQuestion();
	}

}
