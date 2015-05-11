import java.sql.SQLException;

/**
 * HydrocarbonS
 * @author Firat Sivrikaya
 * @date 01/05/2015
 * This is the slots class for hydrocarbon questions.
 *
 */
public class HydrocarbonS {
	
	HydrocarbonQ question;
	
	
	public HydrocarbonS()
	{
		question = new HydrocarbonQ();
	}
	
	
	public Question askQuestion()
	{
		Question q = null;
		try {
			q = question.askQuestion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
	
	
}
