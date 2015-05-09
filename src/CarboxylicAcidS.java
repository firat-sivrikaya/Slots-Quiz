import java.sql.SQLException;

/**
 * 
 * CarboxylicAcidS
 *
 * @author Firat Sivrikaya
 * @date 9 May 2015
 * 
 * This is the slots class for Carboxylic Acid questions. It has a askQuestion
 * method, which returns a question from related topic and getter setter methods for
 * lock status of the slots.
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
