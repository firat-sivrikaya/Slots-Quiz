import java.sql.SQLException;

/**
 * AldeKetS
 * @author Firat Sivrikaya
 * @date 01/05/2015
 * This is the slots class for aldehydes ketones questions.
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
