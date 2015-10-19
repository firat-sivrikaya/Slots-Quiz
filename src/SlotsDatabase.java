import java.sql.*;
import java.util.ArrayList;

/**
 * @class Slots Database
 * 
 * @author Firat Sivrikaya
 * @date 28/04/2015
 * 
 * This is the core class for integrating with database.
 * Slots Database uses Connector/J driver for integrating with MySQL.
 * 
 * Slots Database gets question locations, answers and ids from
 * the question database and sets the variables accordingly.
 * 
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 
 * 4.0 International License. To view a copy of this license, 
 * visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 * 
 */

public class SlotsDatabase {

	// Online database info
	// DB_URL = jdbc:mysql://sql5.freemysqlhosting.net:3306/sql576373
	// USER = sql576373
	// PASS = hJ3%jG5!
	
    // JDBC driver name, Database URL, User and Password
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://217.199.187.60/cl50-slotsquiz";
    static final String USER = "cl50-slotsquiz";
    static final String PASS = "s-kUe.XVV";
    static final int QUESTION_COUNT = 100;
    static final int QUESTION_LIST_RESET_COUNT = 7;
    
    // Properties
    String     		   imageLocation;
    Connection         conn;
    Statement   	   stmt;
    String     		   sql;
    ResultSet          rs;
    ArrayList<Integer> ids;
    
    // Constructor
    public SlotsDatabase()
    {
    	// Create an arraylist to hold question ids
    	ids = new ArrayList<Integer>();
        // Register JDBC driver
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

        // Get database connection
        try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        // Initialize statement
        try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         	
    }
    
    /*
     * method: nextQuestion()
     * This type of nextQuestion method is used in CoinGenerator
     * since it uses the whole question pool.
     * 
     * 
     */
    public Question nextQuestion() throws SQLException
    {
    	Question q = new Question();
    	int id = generate();
//    	ids.add( id );
    	q.setId(id);
    	q.setLocation( getLocation(id) );
    	q.setAnswer( getAnswer(id) );
    	return q;
    }    
    
    public String getAnswer( int id ) throws SQLException{
		
    	sql = "SELECT answer FROM QUESTIONS WHERE id = " + id;
    	rs = stmt.executeQuery( sql );
    	rs.next();
    	String answer = rs.getString("answer");
    	rs.close();
    	return answer;
    	
    }
    
    public String getLocation( int id ) throws SQLException {
    	sql = "SELECT text FROM QUESTIONS WHERE id = " + id;
    	rs = stmt.executeQuery( sql );
    	rs.next();
    	String address = rs.getString("text");
    	rs.close();
    	return address;
    	
    }
    
    public Question nextQuestion( int lowerBound, int upperBound ) throws SQLException
    {
    	Question q = new Question();
    	generate( lowerBound, upperBound );
    	q.setId( ids.get( ids.size() - 1) );
    	q.setLocation( getLocation( ids.get( ids.size() - 1) ) );
    	q.setAnswer( getAnswer( ids.get( ids.size() - 1) ) );
    	return q;
    }
    
    
    public void printQuestionList() throws SQLException
    {
        sql = "SELECT id, text, answer FROM QUESTIONS";
        rs = stmt.executeQuery(sql);   		
        stmt = conn.createStatement();
            
            
            
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String text = rs.getString("text");
                String answer = rs.getString("answer");
                imageLocation = text;
                //Display values
                System.out.print("ID: " + id + "   " );
                System.out.print("Name: " + text + "   ");
                System.out.print("Answer: " + answer + "\n");
            }
            rs.close();
    }
    
    
    public void createDatabase()
    {
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
    //        System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
    //        System.out.println("Connection successful!");
            
            stmt = conn.createStatement();

//            String create = "CREATE DATABASE TEST";
//            stmt.executeUpdate(create);


//			Create database
//            
//            sql = "CREATE TABLE QUESTIONS " +
//                    "(id INTEGER not NULL, " +
//                    " text VARCHAR(255), " +
//                   " PRIMARY KEY ( id ))";
//
//	      stmt.executeUpdate(sql);
//            System.out.println("Created table in given database...");


//            sql = "INSERT INTO Questions " +
//                    "VALUES (0, 'q1.png')";
//	      stmt.executeUpdate(sql);
//	      sql = "INSERT INTO Questions " +
//                  "VALUES (1, 'q2.png)";
//	      stmt.executeUpdate(sql);
//	      sql = "INSERT INTO Questions " +
//	    		 "VALUES (2, 'Hazal')";
//	      stmt.executeUpdate(sql);
//	      sql = "INSERT INTO Questions " +
//	             "VALUES(3, 'Huseyin')";
//	      stmt.executeUpdate(sql);
//
//	      sql = "INSERT INTO Questions " +
//	    		  "VALUES(4, 'Gokce')";
//	      stmt.executeUpdate(sql);
//	      sql = "INSERT INTO Questions VALUES (5, 'Gulsum')";
//	      stmt.executeUpdate(sql);
            
            
//          for( int i = 11 ; i <= QUESTION_COUNT ; i++ ) 
//          {
//        	  sql = "INSERT INTO Questions VALUES (" + i + ", 'resources/q" + i + ".png', 'A')";
//        	  stmt.executeUpdate( sql );
//        	  
//          }
            

//            System.out.println("Inserted records into the table...");
//
//            sql = "SELECT id, text, answer FROM Questions";
//            ResultSet rs = stmt.executeQuery(sql);
//            //STEP 5: Extract data from result set
//            
//            while(rs.next()){
//                //Retrieve by column name
//                int id  = rs.getInt("id");
//                String text = rs.getString("text");
//                String answer = rs.getString("answer");
//                imageLocation = text;
//                //Display values
//                System.out.print("ID: " + id + "   " );
//                System.out.print("Name: " + text + "   ");
//                System.out.print("Answer: " + answer + "\n");
//            }
//            rs.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try        
    }
    
    // Random number generator methods
    
    // Generates a unique number depending on question count
    public int generate()
    {
    	int id = (int) (Math.random() * QUESTION_COUNT + 1);
    	for ( Integer i : ids )
    	{
    		if ( i == id )
    			generate();
    	}
    	ids.add( id );
    	return id;
    }
    
    // Generates a unique number between lower and upper bounds. 
    public void generate( int lowerBound, int upperBound )
    {
    	boolean found = false;
    	int id = (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound );
    	
    	// If question list reset count reached, remove the id at first index to prevent repetition.
    	if ( ids.size() == QUESTION_LIST_RESET_COUNT )
    	{
    		ids.remove(0);
// 			TEST LINE System.out.println("Unique list: "); printIDs();
    	}
    	
    	// Initial state
    	if ( ids.size() == 0 )
    	{
    		ids.add( id );
    	}
    	else
    	{
    		for ( int i = 0 ; i < ids.size(); i++ )
    		{
    			if ( ids.get(i) == id )
    			{
    				// If the generated id is found in id list, found is true.
    				found = true;
    			}
    		}
    		
    		if ( found )
    		{
    			generate( lowerBound, upperBound );
    		}
    		else
    		{
    			ids.add( id );
    		}
    	}
    }
    
    public void printIDs()
    {
    	System.out.println("ID LIST:");
    	for ( Integer i : ids )
    	{
    		System.out.print( i + " ");
    	}
    	System.out.println();
    }
    
}
