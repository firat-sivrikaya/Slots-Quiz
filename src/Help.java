import javax.swing.*;

/*
 * by Hüseyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * This class holds the informations which is necessary for the Help page of our Project
 */
public class Help 
{
	ImageIcon introduction;
	ImageIcon definitions;
	ImageIcon symbols;
	
	public Help()
	{
		introduction = new ImageIcon("images/intro.jpg");
		
		definitions =  new ImageIcon("images/def.jpg");
		
		symbols = new ImageIcon("images/symbols.jpg");
	}
	
	public ImageIcon getIntro()
	{
		return introduction;
	}

	public ImageIcon getDef()
	{
		return definitions;
	}
	
	public ImageIcon getSym()
	{
		return symbols;
	}
}


