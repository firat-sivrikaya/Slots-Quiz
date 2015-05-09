import java.sql.SQLException;

/**
 * 
 * AldeKetS
 *
 * @author Firat Sivrikaya
 * @date 9 May 2015
 * 
 * This is the slots class for Aldehyde Ketone questions. It has a askQuestion
 * method, which returns a question from related topic and getter setter methods for
 * lock status of the slots.
 * 
 */

public class AldeKetS {
	// properties
	AldeKetQ question;
	boolean opened;
	// constructors
	public AldeKetS()
	{
		question = new AldeKetQ();
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
			// TODO Auto-generated catch block
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
