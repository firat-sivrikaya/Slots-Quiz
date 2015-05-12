import java.sql.SQLException;

/**
 * AlcoholEtherS
 * @author Firat Sivrikaya
 * @date 01/05/2015
 * This is the slots class for alcohol ether questions.
 *
 */
public class AlcoholEtherS {
	
	static final int COIN_GAIN = 35;
	static final int CRYSTAL_GAIN = 1;
	// variables
	AlcoholEtherQ question;
	
	// constructors
	public AlcoholEtherS()
	{
		question = new AlcoholEtherQ();
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
