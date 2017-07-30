package Game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle {
	
	int x,y;//coordinates of the AI paddle.
	int width=15,height=40;
	int speed=2;
	
	boolean isTwoPlayer=false;
	
	boolean goingUp=false;
	boolean goingDown=false;
	
	Rectangle boundingBox;
	
	public AIPaddle(int x,int y){
		
		this.x=x;
		this.y=y;
		
		boundingBox=new Rectangle(x,y,width,height);
		boundingBox.setBounds(this.x,this.y,width,height);
		
	}
	
	public void tick(Game game){
		
		boundingBox.setBounds(x,y,width,height);
		
		if(isTwoPlayer==false){
			
			if(game.ball.y<y && y>=0){
			
			y-=speed;
			
		    }
		
		    if(game.ball.y>y && y+height<game.getHeight()){
			
			    y+=speed;
			
		    }
		    
		}
		else{
			
			if(goingUp && y>=0){
				
				y-=speed;
				
			}
			
			if(goingDown && y+height<game.getHeight()){
				
				y+=speed;
				
			}
			
		}
		
	}
	
	public void render(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillRect(x,y,width,height);
		
	}
	
	
}