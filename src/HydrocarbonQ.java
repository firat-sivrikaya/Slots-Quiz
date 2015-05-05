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

public class HydrocarbonQ extends Question{
	
	final int UPPER_BOUND = 23;
	final int LOWER_BOUND = 21;
	
	public HydrocarbonQ()
	{
		super();
		
		
	}
	
	public Question askQuestion() throws SQLException
	{
		return nextQuestion(LOWER_BOUND, UPPER_BOUND);
	}

}
