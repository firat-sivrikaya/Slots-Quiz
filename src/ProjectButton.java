/*
 *  by   H�seyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * This class is used for the customize our buttons of the project
 * It replaces the content of the JButton with a wanted Image 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProjectButton extends JButton {
	public ProjectButton(String s) {
		super(s);

		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);

		if (s.equals("PLAY")) 
		{
			setIcon(new ImageIcon("images/buttons/playbutton.png"));
			setText("");
		} 
		
		if (s.equals("OPTIONS")) 
		{
			setIcon(new ImageIcon("images/buttons/optionsbutton.png"));
			setText("");
		} 
		
		if (s.equals("HELP")) 
		{
			setIcon(new ImageIcon("images/buttons/helpbutton.png"));
			setText("");
		} 
		
		if (s.equals("EXIT")) 
		{
			setIcon(new ImageIcon("images/buttons/exitbutton.png"));
			setText("");
		} 
		
		if (s.equals("OK")) {
			setIcon(new ImageIcon("images/buttons/OKbutton.png"));
			setText("");
		} 
		
		if (s.equals("RESET")) {
			setIcon( new ImageIcon("images/buttons/reset.png"));
			setText("");
		}
		
		if (s.equals("BACK")) 
		{
			setIcon(new ImageIcon("images/buttons/backbutton.png"));
			setText("");
		} 
		
		if (s.equals("COIN GENERATOR")) {
			setIcon(new ImageIcon("images/buttons/coingeneratorbutton.png"));
			setText("");
		} 
		
		if (s.equals("SLOTS GAME")) {
			setIcon(new ImageIcon("images/buttons/slotsgamebutton.png"));
			setText("");
		} 
		
		if (s.equals("CONTINUE")) {
			setIcon(new ImageIcon("images/buttons/continue.png"));
			setText("");
		} 
		
		if (s.equals("HYDROCARBONS")) {
			setIcon(new ImageIcon("images/buttons/hydrocarbons.png"));
			setText("");
		} 
		
		if (s.equals("ALCOHOLS/ETHERS")) {
			setIcon(new ImageIcon("images/buttons/alcetbutton.png"));
			setText("");
		} 
		
		if (s.equals("ALDEHYDES/KETONS")) {
			setIcon(new ImageIcon("images/buttons/aldketbutton.png"));
			setText("");
		} 
		
		if (s.equals("CARBOXCYLIC ACIDS")) {
			setIcon(new ImageIcon("images/buttons/carboxbutton.png"));
			setText("");
		} 
		
		if (s.equals("Locked-ALCOHOLS/ETHERS")) {
			setIcon(new ImageIcon("images/buttons/alcetbuttonlocked.png"));
			setText("");
		} 
		
		if (s.equals("Locked-ALDEHYDES/KETONS")) {
			setIcon(new ImageIcon("images/buttons/aldketbuttonlocked.png"));
			setText("");
		} 
		
		if (s.equals("Locked-CARBOXCYLIC ACIDS")) {
			setIcon(new ImageIcon("images/buttons/carboxbuttonlocked.png"));
			setText("");
		} 
		
		if (s.equals("BACK TO MAIN MENU")) {
			setIcon(new ImageIcon("images/buttons/backtomain.png"));
			setText("");
		} 
		
		if (s.equals("A")) {
			setIcon(new ImageIcon("images/AnswerButtons/answerona.png"));
			setRolloverIcon(new ImageIcon("images/AnswerButtons/answeroffa.png"));
			setText("");
		} 
		
		if (s.equals("B")) {
			setIcon(new ImageIcon("images/AnswerButtons/answeronb.png"));
			setRolloverIcon(new ImageIcon("images/AnswerButtons/answeroffb.png"));
			setText("");
		} 
		
		if (s.equals("C")) {
			setIcon(new ImageIcon("images/AnswerButtons/answeronc.png"));
			setRolloverIcon(new ImageIcon("images/AnswerButtons/answeroffc.png"));
			setText("");
		} 
		
		if (s.equals("D")) {
			setIcon(new ImageIcon("images/AnswerButtons/answerond.png"));
			setRolloverIcon(new ImageIcon("images/AnswerButtons/answeroffd.png"));
			setText("");
		}
		
		if (s.equals("E")) {
			setIcon(new ImageIcon("images/AnswerButtons/answerone.png"));
			setRolloverIcon(new ImageIcon("images/AnswerButtons/answeroffe.png"));
			setText("");
		} 
		
		if (s.equals("soundOn")) {
			setIcon(new ImageIcon("images/soundIcon/Sound-on-icon.png"));
			setText("");
		} 
		
		if (s.equals("soundOf")) {
			setIcon(new ImageIcon("images/soundIcon/Sound-off-icon.png"));
			setText("");
		}
		
		if (s.equals("arrowRight")) {
			setIcon(new ImageIcon("images/arrows/arrow-right.png"));
			setText("");
		} 
		
		if (s.equals("arrowLeft")) {
			setIcon(new ImageIcon("images/arrows/arrow-left.png"));
			setText("");
		}

	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				(float) 1.0));
		super.paint(g2);

		g2.dispose();
	}

}
