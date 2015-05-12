import java.sql.SQLException;

/**
 * HydrocarbonS
 * @author Firat Sivrikaya
 * @date 01/05/2015
 * This is the slots class for hydrocarbon questions.
 *
 */
public class HydrocarbonS {
	
	static final int COIN_GAIN = 25;
	static final int CRYSTAL_GAIN = 1;
	
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
