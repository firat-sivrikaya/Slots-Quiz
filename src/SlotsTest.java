import java.sql.SQLException;


public class SlotsTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		SlotsDatabase database = new SlotsDatabase();
		HydrocarbonQ h = new HydrocarbonQ();
		database.printQuestionList();
		for ( int i = 0 ; i < 20 ; i++ )
		System.out.println( h.nextQuestion() );
		System.out.println( h.nextQuestion() );
		System.out.println( "----------------");
//		for ( int j = 0 ; j < 20 ; j++ )
//			System.out.println( database.nextQuestion( 41, 70) );
	}

}
