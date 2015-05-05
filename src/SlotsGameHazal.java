/*
 * @author Hazal Buruk
 * @author Irmak Akkuzuluoðlu
 */

import javax.swing.*;
import java.awt.*;

public class SlotsGame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Slots Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HydrocarbonSlotsPanel slots = new HydrocarbonSlotsPanel();
		frame.getContentPane().add(slots);
		
		frame.setBounds( 0, 0, 800, 600);
		frame.setVisible(true);
		frame.setResizable(false);

	}

}
