import java.sql.SQLException;

/**
 * 
 * CoinGenerator
 *
 * @author Firat Sivrikaya
 * @date 9 May 2015
 * 
 * This is the coin generator class which asks basic hydrocarbon
 * questions. It has a askQuestion
 * method, which returns a question from related topic.
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
