import java.sql.SQLException;

/**
 * 
 * @author Firat Sivrikaya
 *
 */
public class AlcoholEtherS {
	
	AlcoholEtherQ question;
	
	
	public AlcoholEtherS()
	{
		question = new AlcoholEtherQ();
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
