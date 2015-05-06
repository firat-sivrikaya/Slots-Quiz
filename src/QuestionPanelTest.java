import javax.swing.JFrame;


public class QuestionPanelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame( "Slots Quiz");
		SlotsQuestionPanel panel = new SlotsQuestionPanel("AlcoholEther");
		
		frame.getContentPane().add( panel );
		
		
		frame.setVisible( true);
		
		frame.setBounds(0,0,800,600);
		frame.setResizable( false);
	}

}
