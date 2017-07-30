package Game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPaddle {
	
	int x,y;//coordinates of the paddle.
	int width=15,height=40;
	int speed=2;
	
	boolean goingUp=false;
	boolean goingDown=false;
	
	Rectangle boundingBox;
	
	public PlayerPaddle(int x,int y){
		
		this.x=x;
		this.y=y;
		
		boundingBox=new Rectangle(x,y,width,height);
		boundingBox.setBounds(this.x,this.y,width,height);
		
	}
	
	public void tick(Game game){
		
		boundingBox.setBounds(x,y,width,height);
		
		if(goingUp && y>=0){
			
			y-=speed;
			
		}
		
		if(goingDown && y+height<game.getHeight()){
			
			y+=speed;
			
		}
		
	}
	
	public void render(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillRect(x,y,width,height );
		
	}
	
	
}
