/*
 * @author Hazal Buruk
 */

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SlotsPanel extends JPanel {
	
	private ImageIcon[] icon, bands;
	private ImageIcon slot;
	private int first;
	private int[] saver;
	private final int DELAY = 500;
	private JLabel[] label, bandLabels;
	private JLabel label1;
	private Timer timer;
	private Random generator= new Random();
	private SlotButton button;
	private JPanel panel;

	public SlotsPanel(){
		
		bands = new ImageIcon[3];
		bandLabels = new JLabel[5];
		bands[0] = new ImageIcon("band1.png");
		bands[1] = new ImageIcon("band2.gif");
		bands[2] = new ImageIcon("band3.gif");
		
		bandLabels[0] = new JLabel(bands[0]);
		bandLabels[1] = new JLabel(bands[0]);
		bandLabels[2] = new JLabel(bands[0]);
		bandLabels[3] = new JLabel(bands[1]);
		bandLabels[4] = new JLabel(bands[2]);
		
		slot = new ImageIcon("button.png");
		button = new SlotButton("");
		button.setBounds(180, 340, 100, 100);
		button.setIcon(slot);
		button.setBackground(Color.red);
		button.addActionListener(new ButtonListener());
		
		first=0;
		timer = new Timer(DELAY, new SlotListener());
		
		label1 = new JLabel("Counter: 0" + "            ");
		label1.setBounds(10, 393, 123, 17);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label = new JLabel[9];
		
		panel = new JPanel();
		panel.setBounds(1, 5, 330, 330);
		
		panel.setLayout( new GridLayout(3,3));
		icon = new ImageIcon[5];
		icon[4] = new ImageIcon("001.png");
		icon[1] = new ImageIcon("002.png");
		icon[2] = new ImageIcon("003.png");
		icon[3] = new ImageIcon("004.png");
		icon[0] = new ImageIcon("gifh.gif");
		
		saver = new int[9];
		for(int i = 0; i<9; i++)
			saver[i]=0;
		
		for ( int i = 0; i<9 ; i++)
		{
			int b = generator.nextInt(5-1)+1;
			label[i] = new JLabel(icon[1]);
			panel.add(label[i]);
		}
		setLayout(null);
	
		add(panel);
		panel.setPreferredSize(new Dimension (330, 330));
		panel.setBackground(Color.black);
		add(label1);
		add(button); 
		
		for(int i=0; i<5; i++)
			add(bandLabels[i]);
		
		setBackground(Color.red);
		setPreferredSize(new Dimension(332, 790));
		
	}
	
	private class SlotListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			if(first < 9)
			{
				int num = generator.nextInt(5-1)+1;
				label[first].setIcon(icon[num]);
				saver[first]=num;
				first++;
			}
			else
			{
				timer.stop();
				label1.setText("Counter: " + lineCounter() +"            ");
			}
		}
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			for ( int i = 0; i<9 ; i++)
			{
				label[i].setIcon(icon[0]);
				label1.setText("Counter: 0            ");
			}
			first=0;
			timer.start();
		}
	}
	
	private boolean isChangable(){
		for(int i= 0; i<9; i++)
		{
			if(label[i].getDisabledIcon() == icon[0])
				return true;
		}
		return false;
	}
	
	public int lineCounter(){
		int counter=0;
		if(saver[0] == 0)
			return 0;
		else
		{
			if(saver[0]== saver[1] && saver[1]== saver[2])
				counter++;
			if(saver[0]== saver[4] && saver[4]== saver[8])
				counter++;
			if(saver[3]== saver[4] && saver[4]== saver[5])
				counter++;
			if(saver[6]== saver[4] && saver[4]== saver[2])
				counter++;
			if(saver[6]== saver[7] && saver[7]== saver[8])
				counter++;
		}
		return counter;
			
	}
	
	public boolean isTriggered(){
		if(lineCounter()>0)
			return true;
		return false;
	}
	
}
