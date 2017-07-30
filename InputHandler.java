package Game2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	
	
	public InputHandler(Game game){
		game.addKeyListener(this);
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		
		int keyCode=e.getKeyCode();
		
		//Player 1 controls
		if(keyCode==KeyEvent.VK_W){//if the player has pressed the Up key.VK stands for Virtual Keyboard.
			
			Game.player.goingDown=false;
			Game.player.goingUp=true;
			
		}
        if(keyCode==KeyEvent.VK_S){//if the player has pressed the Down key
			
        	Game.player.goingUp=false;
			Game.player.goingDown=true;
			
		}
        
        //Player 2 controls
        if(keyCode==KeyEvent.VK_UP){//if the player 2 has pressed the Up (arrow) key.
			
		    Game.ai.goingDown=false;
		    Game.ai.goingUp=true;
			
		}
        if(keyCode==KeyEvent.VK_DOWN){//if the player 2 has pressed the Down (arrow) key.
			
        	Game.ai.goingUp=false;
			Game.ai.goingDown=true;
			
		}
        
        
        if(keyCode==KeyEvent.VK_ESCAPE){
        	
        	System.exit(0);
        	
        }
        
        
	}

	
	
	public void keyReleased(KeyEvent e) {
		
        int keyCode=e.getKeyCode();
		
        //Player 1 controls
		if(keyCode==KeyEvent.VK_W){//if the player has pressed the Up key.VK stands for Virtual Keyboard.
			
			Game.player.goingDown=false;
			Game.player.goingUp=false;
			
		}
        if(keyCode==KeyEvent.VK_S){//if the player has pressed the Down key
			
        	Game.player.goingUp=false;
			Game.player.goingDown=false;
			
		}
        
        //Player 2 controls
        if(keyCode==KeyEvent.VK_UP){//if the player 2 has pressed the Up (arrow) key.
			
		    Game.ai.goingDown=false;
		    Game.ai.goingUp=false;
			
		}
        if(keyCode==KeyEvent.VK_DOWN){//if the player 2 has pressed the Down (arrow) key.
			
        	Game.ai.goingUp=false;
			Game.ai.goingDown=false;
			
		}
        
	}

	
	
	public void keyTyped(KeyEvent e) {
	
		
	}
	
	
	
}
