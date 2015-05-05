/*
 * by Hüseyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * This class holds the informations which is necessary for the Help page of our Project
 */
public class Help 
{
	String introduction;
	String definitions;
	String symbols;
	
	public Help()
	{
		introduction = "<html>   In this place, introduction info <br /> will be written</html>";
		
		definitions =  "<html>   In this place, definitions that <br /> is used in our project will <br /> be written</html>";
		
		symbols =      "<html>   In this place, symbols in the project <br /> will be explained</html>";		
	}
	
	public String getIntro()
	{
		return introduction;
	}

	public String getDef()
	{
		return definitions;
	}
	
	public String getSym()
	{
		return symbols;
	}
}


