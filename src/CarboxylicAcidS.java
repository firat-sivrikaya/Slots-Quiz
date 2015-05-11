import java.sql.SQLException;

/**
 * CarboxylicAcidS
 * @author Firat Sivrikaya
 * @date 01/05/2015
 * This is the slots class for carboxylic acid questions.
 *
 */
public class CarboxylicAcidS {
	
	// properties
	CarboxylicAcidQ question;
	boolean opened;
	// constructors
	public CarboxylicAcidS()
	{
		question = new CarboxylicAcidQ();
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
