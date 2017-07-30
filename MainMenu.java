package Game2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	int screenWidth=300;
	int screenHeight=200;
	
	int buttonWidth=100;
	int buttonHeight=50;
	
	JButton Play,Quit;
	
	JCheckBox twoPlayer;
	
	public MainMenu(){
		
		addButtons();
		addActions();
		
		getContentPane().setLayout(null);//getContentPane() is used when an object of JFrame class has not been created.
		
		Play.setBounds((screenWidth-buttonWidth)/2,5,buttonWidth,buttonHeight);
		Quit.setBounds((screenWidth-buttonWidth)/2,60,buttonWidth,buttonHeight);
		twoPlayer.setBounds((screenWidth-buttonWidth)/2,120,buttonWidth+10,buttonHeight);
		
		//add buttons to the frame
		getContentPane().add(Play);
		getContentPane().add(Quit);
		getContentPane().add(twoPlayer);
		
		//jframe stuff
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth,screenHeight);
		setTitle("PING-PONG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	
	private void addButtons(){
		
		Play=new JButton("Play");
		Quit=new JButton("Quit");
		twoPlayer=new JCheckBox("Two Players?");
	}
	
	
	private void addActions(){
		
		Play.addActionListener(new ActionListener(){//adding action listener to the Play button.

			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Game game=new Game();
				
				if(twoPlayer.isSelected()){
					
					game.ai.isTwoPlayer=true;
					
				}
				
				game.start();
				
				/*new Game().start();*/
				
			}
			
		} );//Play Button
		
		
		Quit.addActionListener(new ActionListener(){//adding action listener to the Quit button.

			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
		} );//Quit Button
		
	}
	
	
}
