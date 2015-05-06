import java.sql.SQLException;

/**
 * 
 * @author Firat Sivrikaya
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
