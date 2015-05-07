import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Statistics implements Serializable
{
	int coin;
	int crystal;
	
	boolean hydroOpen;
	boolean alcoOpen;
	boolean aldeOpen;
	boolean carboxOpen;
	
	public Statistics()
	{
		coin = 10;
		crystal = 0;
		
		hydroOpen  = true;
		alcoOpen   = false;
		aldeOpen   = false;
		carboxOpen = false;		
	}
	
	public int getCoin()
	{
		return coin;		
	}
	
	public int getCrystal()
	{
		return crystal;		
	}
	
	public void addCoins( int amount )
	{
		coin = coin + amount;
	}
	
	public void addCrystal( int amount )
	{
		crystal = crystal + amount;
	}
	
	public boolean[] openedLevels()
	{
		boolean[] array = new boolean[4];
		
		array[0] = hydroOpen;
		array[1] = alcoOpen;
		array[2] = aldeOpen;
		array[3] = carboxOpen;
				
		return array;
	}
	
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
	
	public void reset()
	{
		coin = 100;
		crystal = 0;
		
		hydroOpen  = true;
		alcoOpen   = false;
		aldeOpen   = false;
		carboxOpen = false;			
	}

}
