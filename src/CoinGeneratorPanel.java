/* CoinGeneratorPanel
 * @author Gokce Sakir Ozyurt
 * @author Firat Sivrikaya
 * 
 * This is the panel class for coin generator. 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;




public class CoinGeneratorPanel extends JPanel {
	// variables
	private CurrencyPanel curPanel;
	private Image background;	
	// button variables
	private ProjectButton aButton;
	private ProjectButton bButton;
	private ProjectButton cButton;
	private ProjectButton dButton;
	private ProjectButton eButton;
	// sound variables
	private static File backgroundSound;
	private static AudioInputStream createBackgroundSound;
	private static Clip startBackgroundSound;
	
	private File answerButton;
	private AudioInputStream createAnswerButton;
	private Clip startAnswerButton;
	
	private File correctButton;
	private AudioInputStream createCorrectButton;
	private Clip startCorrectButton;

	private JPanel panel;
	private CoinGenerator question;
	private String answer;
	private String location;
	private Question q;
	private Statistics stats;
	// constructors
	public CoinGeneratorPanel( Statistics stats) {
		CoinGeneratorPanel.stopBackgroundMusic();
		// get the question instance from coin generator
		question = new CoinGenerator();		
	
		
		//Panel has to be 800* 600
		// Set the panel's properties
		this.setVisible( true);				
		this.setBounds( 0,0, 800, 600);
		this.setFocusable(false);
		this.requestFocusInWindow();
		// get the stats from constructors
		this.stats = stats;
		
		//In order to move the necessary components
		setLayout(null);
		
		// Get the question from database and print it for test purpose
		q = question.askQuestion();
		answer = q.getAnswer();
		location = q.getLocation();	
		System.out.println( "Location: " + location + "\n Answer: " + answer );
		
		
		// set the answer label's properties
		JLabel answerLabel = new JLabel("Start!");
		answerLabel.setFont(new Font("Phosphate", Font.PLAIN, 20));
		answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		answerLabel.setBounds(274, 538, 241, 16);
		add(answerLabel);
		
		
		//Currency panel at the top left corner.
		curPanel = new CurrencyPanel(stats);
		add(curPanel); 
		
		//Initializing the buttons
		aButton = new ProjectButton("A");
		bButton = new ProjectButton("B");
		cButton = new ProjectButton("C");
		dButton = new ProjectButton("D");
		eButton = new ProjectButton("E");	
		
		JLabel headerImage = new JLabel("");
		headerImage.setIcon(new ImageIcon("images/coingeneratorheader.png"));
		headerImage.setBounds(205, 0, 400, 90);
		add(headerImage);
		
		//settings for A button
		aButton.setBounds(40, 470, 70, 70);
		add(aButton);	
		
		//settings for B Button
		bButton.setBounds(200, 470, 70, 70);
		add(bButton);	
		
		//settings for C button
		cButton.setBounds(360, 470, 70, 70);
		add(cButton);
		
		//settings for D button
		dButton.setBounds(520, 470, 70, 70);
		add(dButton);
		
		
		//settings for E button
		eButton.setBounds(680, 470, 70, 70);
		add(eButton);
		
		
		// set focusable
		aButton.setFocusable( false );
		bButton.setFocusable( false );
		cButton.setFocusable( false );
		dButton.setFocusable( false );
		eButton.setFocusable( false );
		
		
		//adding action listener to A button
		aButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Print the location for test purpose in the console
				System.out.println("Location: " + location + " \nAnswer: " + answer ); 
				
				if(event.getSource()==aButton){
					if ( answer.equals("A"))
					{
						// play correct sound
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						
						
						System.out.println( "CORRECT!");
						// Print correct message in the panel
						answerLabel.setText("Correct!");
						stats.addCoins( 5);
						curPanel.update( stats);
						repaint();
						
					}
					else{						
						
						System.out.println( "FALSE!");
						answerLabel.setForeground( Color.red );
						answerLabel.setText("False! It was " + answer);
						repaint();
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
					
					}
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		});

		//adding action listener to B button
		bButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				System.out.println("Location: " + location + " \nAnswer: " + answer ); 
				
				if(event.getSource()==bButton){
					if ( answer.equals("B"))
					{
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						System.out.println( "CORRECT!");
						answerLabel.setForeground( Color.green );
						answerLabel.setText("Correct!");
						stats.addCoins( 5);
						curPanel.update( stats);
						
					}
					else{
					
						System.out.println( "FALSE!");
						answerLabel.setForeground( Color.red );
						answerLabel.setText("False! It was " + answer);
						repaint();
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
					
					}
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		});

		//adding action listener to C button
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				System.out.println("Location: " + location + " \nAnswer: " + answer ); 
				
				if(event.getSource()==cButton)
				{
					if ( answer.equals("C"))
					{
						answerLabel.setForeground( Color.green );
						answerLabel.setText("Correct!");
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						stats.addCoins( 5);
						curPanel.update( stats);
						System.out.println( "CORRECT!");
						repaint();
					}
					else
					{
					
						repaint();
						System.out.println( "FALSE!");
						answerLabel.setForeground( Color.red );
						answerLabel.setText("False! It was " + answer);
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
				
						
					}
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		});
		
		//adding action listener to D button
		dButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				System.out.println("Location: " + location + " \nAnswer: " + answer ); 
				
				if(event.getSource()==dButton)
				{
					if ( answer.equals("D"))
					{
						answerLabel.setForeground( Color.green );
						answerLabel.setText("Correct!");
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						System.out.println( "CORRECT!");
						stats.addCoins( 5);
						curPanel.update( stats);
					
					}
					else
					{
					
						repaint();
						System.out.println( "FALSE!");
						answerLabel.setForeground( Color.red );
						answerLabel.setText("False! It was " + answer);
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						
					}
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		}
		);		

		//adding action listener to E button
		eButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				System.out.println("Location: " + location + " \nAnswer: " + answer ); 
				
				if(event.getSource()==eButton){
				
					if ( answer.equals("E"))
					{
						answerLabel.setForeground( Color.green );
						answerLabel.setText("Correct!");
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						System.out.println( "CORRECT!");
						stats.addCoins( 5);
						curPanel.update( stats);
					}
					else{
						
						repaint();
						System.out.println( "FALSE!");
					
						answerButton = new File("sounds/gameover.wav");
						answerLabel.setForeground( Color.red );
						answerLabel.setText("False! It was " + answer);			

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
					}
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					
				}
			}
		}
		);
		
		
		
	}

		
	
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/backgrounds/backgroundq01.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);
		// panel.getGraphics().drawImage
		g.drawImage( new ImageIcon( location ).getImage(), 48, 102, 700, 350, null );
		repaint();
	}
	
	public void update( Statistics stats)
	{
		curPanel.update( stats);
	}
	public static void startBackgroundMusic() {

		backgroundSound = new File("sounds/backgroundSound.wav");
		createBackgroundSound = null;
		startBackgroundSound = null;

		try {
			createBackgroundSound = AudioSystem
					.getAudioInputStream(backgroundSound);
			
			try {
				startBackgroundSound = AudioSystem.getClip();

			} catch (LineUnavailableException e) {

				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			startBackgroundSound.open(createBackgroundSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FloatControl gainControl = 
			    (FloatControl) startBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f);
		startBackgroundSound.loop(10);
		
	}

	public static void stopBackgroundMusic() {
		if (startBackgroundSound != null && startBackgroundSound.isRunning())
			startBackgroundSound.stop();
	}
}

