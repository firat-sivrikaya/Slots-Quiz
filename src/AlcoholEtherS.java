import java.sql.SQLException;

/**
 * 
 * AlcoholEtherS
 *
 * @author Firat Sivrikaya
 * @date 9 May 2015
 * 
 * This is the slots class for Alcohol Ether questions. It has a askQuestion
 * method, which returns a question from related topic and getter setter methods for
 * lock status of the slots.
 */

public class AlcoholEtherS {
	
	// properties
	AlcoholEtherQ question;
	boolean opened;
	
	// constructors
	public AlcoholEtherS()
	{
		question = new AlcoholEtherQ();
		// This slot machine is closed by default.
		opened = false;
	}
	
	// methods
	public Question askQuestion()
	{
		Question q = null;
		try {
			q = question.askQuestion();
		} catch (SQLException e) {
			// Database errors
			e.printStackTrace();
		}
		return q;
	}
	
	public void setOpened( boolean b )
	{
		opened = b;
	}
	
	public boolean isOpened()
	{
		return opened;
	}	
	
}
