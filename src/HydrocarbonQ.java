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
	
	final int UPPER_BOUND = 20;
	final int LOWER_BOUND = 1;
	
	public HydrocarbonQ()
	{
		super();
		
		
	}
	
	public Question askQuestion() throws SQLException
	{
		return nextQuestion(LOWER_BOUND, UPPER_BOUND);
	}

}
