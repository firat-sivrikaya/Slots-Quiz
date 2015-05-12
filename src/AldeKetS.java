import java.sql.SQLException;

/**
 * AldeKetS
 * @author Firat Sivrikaya
 * @date 01/05/2015
 * This is the slots class for aldehydes ketones questions.
 *
 */
public class AldeKetS {
	static final int COIN_GAIN = 20;
	static final int CRYSTAL_GAIN = 2;
	
	// properties
	AldeKetQ question;
	// constructors
	public AldeKetS()
	{
		question = new AldeKetQ();
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
