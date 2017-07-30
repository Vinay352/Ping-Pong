package Game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	
	int x,y;//coordinates of the ball.
	int size=16;
	int vx,vy;//velocity_x and velocity_y
	int speed=3;
	
	Rectangle boundingBox;
	
	public Ball(int x,int y){
		
		this.x=x;
		this.y=y;
		vx=speed;
		vy=speed;
		
		boundingBox=new Rectangle(x,y,size,size);
		boundingBox.setBounds(this.x,this.y,size,size);
		
	}
	
	
	public void tick(Game game){
		
		boundingBox.setBounds(x,y,size,size);
		
		if(x<=0){
			
			game.p2++;
			vx=speed;//move to the right
			
		}
		else if(x+size>=game.getWidth()){
			
			game.p1++;
			vx=-speed;//move to the left
			
		}
		
		if(y<=0){
			vy=speed;//move down
		}
		else if(y+size>=game.getHeight()){
			vy=-speed;//move up
		}
		
		x+=vx;
		y+=vy;
		
		paddleCollide(game);
		
	}
	
	
	private void paddleCollide(Game game){
		
		if(boundingBox.intersects(game.player.boundingBox)){
			vx=speed;
		}
		else if(boundingBox.intersects(game.ai.boundingBox)){
			vx=-speed;
		}
	}
	
	
	public void render(Graphics g){
		
		g.setColor(Color.RED);
		g.fillOval(x, y, size, size);
		
	}
	
}
