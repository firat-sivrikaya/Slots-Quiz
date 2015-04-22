import java.sql.SQLException;


public class HydrocarbonQ extends Question{
	
	final int UPPER_BOUND = 40;
	final int LOWER_BOUND = 1;
	
	public HydrocarbonQ()
	{
		super();
		
		
	}
	
	public Question askQuestion() throws SQLException
	{
		return nextQuestion();
	}

}
