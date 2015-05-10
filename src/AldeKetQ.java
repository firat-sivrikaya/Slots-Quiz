import java.sql.SQLException;
/**
 * 
 * 
 * 
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
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
