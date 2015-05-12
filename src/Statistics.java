/**Statistics
 * @author Huseyin Beyan
 * @author Firat Sivrikaya
 * @date 08/05/2015
 * This is the statistics class which holds coin and crystal amount,
 * and lock statuses of the slots.
 * 
 */

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Statistics implements Serializable
{
	// properties
	final int RESET_COIN_AMOUNT = 10;
	final int RESET_CRYSTAL_AMOUNT = 10;
	
	int coin;
	int crystal;
	
	boolean hydroOpen;
	boolean alcoOpen;
	boolean aldeOpen;
	boolean carboxOpen;
	
	public Statistics()
	{
		// initialize currencies
		coin = 10;
		crystal = 0;
		// initialize slots locks
		hydroOpen  = true;
		alcoOpen   = false;
		aldeOpen   = false;
		carboxOpen = false;		
	}
	// currency getters
	public int getCoin()
	{
		return coin;		
	}
	
	public int getCrystal()
	{
		return crystal;		
	}
	// adder and spender methods
	public void addCoins( int amount )
	{
		coin = coin + amount;
	}
	
	public void addCrystal( int amount )
	{
		crystal = crystal + amount;
	}
	
	public void spendCoins( int amount )
	{
		coin = coin - amount;
	}	
	
	public void spendCrystal( int amount )
	{
		crystal = crystal - amount;
	}
	// checks if the coin amount is enough or not 
	public boolean enoughCoin( int amount)
	{
		if( coin >= amount)
			return true;
		else
			return false;
	}
	// checks if the crystal amount is enough or not
	public boolean enoughCrystal( int amount)
	{
		if( crystal >= amount)
			return true;
		else
			return false;
	}
	// returns opened levels in a boolean array
	public boolean[] openedLevels()
	{
		boolean[] array = new boolean[4];
		
		array[0] = hydroOpen;
		array[1] = alcoOpen;
		array[2] = aldeOpen;
		array[3] = carboxOpen;
				
		return array;
	}
	// getters and setters
	public void setHyrdo( boolean b)
	{
		hydroOpen = b;
	}
	
	public void setAlco( boolean b)
	{
		alcoOpen = b;
	}
	
	public void setAlde( boolean b)
	{
		aldeOpen = b;
	}
	
	public void setCarbox( boolean b)
	{
		carboxOpen = b;
	}
	
	public boolean getHyrdo()
	{
		return hydroOpen;
	}
	
	public boolean getAlco()
	{
		return alcoOpen;
	}
	
	public boolean getAlde()
	{
		return aldeOpen;
	}
	
	public boolean getCarbox( )
	{
		return carboxOpen;
	}
	
	public String toString()
	{
		String s = coin + " "+ crystal + "";
				
		for( int i = 0; i < this.openedLevels().length; i++)
		{
			if( this.openedLevels()[i])
				s = s + " open ";
			if( !this.openedLevels()[i])
				s = s + " close ";
		}
		return s;
	}
	
	public void save() throws FileNotFoundException
	{
		try{  // Catch errors in I/O if necessary.
			// Open a file to write to, named SavedObj.sav.
			FileOutputStream saveFile=new FileOutputStream("saves/stats.sav");

			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			// Now we do the save.
			save.writeObject(this);
			// Close the file.
			save.close(); // This also closes saveFile.
			}
			catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
			}		
	}
	// resets the statistics
	public void reset()
	{
		coin = RESET_COIN_AMOUNT;
		crystal = RESET_CRYSTAL_AMOUNT;
		
		hydroOpen  = true;
		alcoOpen   = false;
		aldeOpen   = false;
		carboxOpen = false;			
	}

}
