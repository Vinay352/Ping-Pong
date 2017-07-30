package Game2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable {
    //canvas represents a rectangular area where application can draw something or can receive inputs created by user.
	//Thread in java is an independent path of execution which is used to run two task in parallel.
	//Runnable represents a task in java which is executed by thread.
	//java.lang.Runnable is an interface and defines only one method called run().
	private static final long serialVersionUID = 1L;
	
	JFrame frame=new JFrame("PING PONG");//title of the frame.
	public final int WIDTH=700;//width of frame, not of Canvas.
	public final int HEIGHT=WIDTH/10 * 5;//height of frame, not of Canvas.
	public final Dimension gameSize=new Dimension(WIDTH,HEIGHT);//Condensing width and height of the frame(not of Canvas) into one variable.
	static boolean gameRunning=false;
	
	/*public int ScreenWidth;
	public int ScreenHeight;*/
	
	BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	//the java.awt.image.BufferedImage class which extends the image class(superclass) to allow the application to operate directly with image data(like retrieving or setting up the pixel color).
	
	InputHandler IH;
	
	public static PlayerPaddle player;//available to all classes.
	public static AIPaddle ai;
	public static Ball ball;
	
	int p1,p2;
	
	
	
	public void run() {
		//to run a thread.
		
		while(gameRunning){
			
			tick();
			render();
			
			try{
				Thread.sleep(2);//delay by 2ms.
			}catch(Exception e){
				e.printStackTrace();//prints the stack trace and tells where the problem has occurred.
			}
			
		}
	}
	
	
	public void render() {
		
		BufferStrategy bs=getBufferStrategy();
		//for the convenience of dealing with drawing to surfaces and components in a general way.
		//getDrawGraphics() and show() belong to the library containing this function.
		
		if(bs==null){//if no buffer strategy is created.
			createBufferStrategy(3);//buffer 3 times.
			return ;
		}
		
		Graphics g=bs.getDrawGraphics();
		g.drawImage(image,0,0,getWidth(),getHeight(),null);//getWidth() and getHeight() are widths and heights of Canvas(not of frame) respectively.
		g.setColor(Color.green);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(Color.magenta);
		g.drawString("Player 1:"+p1,10,10);
		g.drawString("Player 2:"+p2,getWidth()-60,10);
		
		player.render(g);
		ai.render(g);
		ball.render(g);
		
		g.dispose();
		
		bs.show();
		
	}


	public void tick() {//this method is for updates.
		
		player.tick(this);
		ai.tick(this);
		ball.tick(this);
		
	}
	
	
	public synchronized void start(){
		// it is not possible for two invocations of synchronized methods on the same object to interleave. 
		//When one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object block (suspend execution) until the first thread is done with the object.
		
		gameRunning=true;
		new Thread(this).start();//in order to start a new thread.Thread(this) refers to a thread of the whole class(Canvas+Game). 
		//NOTE:the start() here is not the same start() function in our that we have in our Game class.It is an another command to start a new thread.
		
	}
	
	
    public static synchronized void stop(){
		
    	gameRunning=false;
		System.exit(0);
		
	}
	
	
	public Game(){
		
		/*frame.setTitle("PING PONG");*/
		//the above command also sets the title of the frame as PING PONG.
		
		setMinimumSize(gameSize);//this command refers to Canvas part only.
		/*this.setMinimumSize(gameSize);*/
		//the above command refers to the whole class ,i.e. Game+Canvas.
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);
		
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);//add Canvas to the frame.
		
		frame.pack();//the pack() method sizes the frame so that all its contents are at or above. 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);//null means center.
		
		gameRunning=true;
		
		/*ScreenWidth=getWidth();
		ScreenHeight=getHeight();*/
		
		IH= new InputHandler(this);
		frame.addKeyListener(IH);
		
		player=new PlayerPaddle(10,60);//one at 10 units from left and 60 units down.
		//player=new PlayerPaddle(50,120);//second at 50 units from left and 120 units down.
		
		ai=new AIPaddle(getWidth()-15,60);
		
		ball=new Ball(getWidth()/2,getHeight()/2);//ball will be initially present in the middle of the srceen.
		
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new Game();
		//If the above command is used, only the Game constructor is executed.
		
		//But if we use the command given below then first the start() is executed, then Game() and then run() is executed. 
		Game game=new Game();
		game.start();
		
	}*/

	

}
