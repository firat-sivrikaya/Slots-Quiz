import java.sql.SQLException;

/**
 * CoinGenerator
 * @author Firat Sivrikaya
 * @date 06/05/2015
 * 
 * This is the coin generator class which is used to ask 
 * questions for coin generator game.
 *
 */
public class CoinGenerator {
	// properties
	CoinGeneratorQ question;
	// constructors
	public CoinGenerator()
	{
		question = new CoinGeneratorQ();
		// This slot machine is closed by default.
	}
	
	// methods
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
