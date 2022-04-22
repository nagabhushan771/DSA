import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
	
	//I choose the screen dimensions to 600x600 pixels 
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	
	static final int UNIT_SIZE = 15;//setting the size of the objects to 25x25 pixels 
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;//Calculating the number of units that we can fir into the frame or the window
	static final int DELAY = 75;//the delay we use in the game to 75 seconds before we updating the frame controls the difficult of game
	final int[] x = new int[GAME_UNITS];//contains the x-coordinates of the body parts of the snake 
	final int[] y = new int[GAME_UNITS];//contains the y-coordinates of the body parts of the snake
	int bodyParts = 6;//Initially I Start the game with the snake having the bodyParts number of parts
	int cherriesEaten;//It will keep count of the number of cherries snake has eaten
	int cherryX;//x-coordinate of the cherry on the screen
	int cherryY;//y-coordinate of the cherry on the screen
	char direction = 'R';//Initially I will start the game with snake moving to the right
	boolean running = false;//as of now I am setting the running to false we will come back to it later
	Random random;//this is used to randomly generate the position of the cherries
	Timer timer;//this is the timer we will be using in the game
	
	public GamePanel() {
		random = new Random();//created the instance of the Random class
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));//Setting the height and width of the game panel
		this.setFocusable(true);
		this.setBackground(Color.black);//Setting the background to black color
		this.addKeyListener(new myKeyAdapter());//adding our keyAdpater class as keyListener
		startGame();
	}
	
	public void startGame() {
		newCherry();//creating new Cherry to start the game
		running = true;//setting the running to true to start the game so that snake will start moving
		timer = new Timer(DELAY, this);//timer with the delay as we defined and for the actionListener I am adding the this since we implemented the ActionListener
		timer.start();//Starting the timer
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		
		if (running) {
			// just drawing the grid to visualize our panel i will make it easy in
			// development of the game
			/*
			 	for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
					g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
					g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
				}
			 */
			
			g.setColor(new Color(252, 255, 38));// Setting the color of the cherry to red
			g.fillOval(cherryX, cherryY, UNIT_SIZE, UNIT_SIZE);// I choose the shape of the cherry to be oval and
																// creating the cherry using the x and y coordinated
																// given by the newCherry method with the size UNIT_SIZE

			// now lets draw the snake
			for (int i = 0; i < bodyParts; i++) {

				if (i == 0) {
					// setting the head with different color
					g.setColor(new Color(252, 255, 38));
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);// fill the unit using the x and y coordinates with UNIT_SIZE
				} else {
					g.setColor(new Color(246, 247, 183));
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);// fill the unit using the x and y coordinates with UNIT_SIZE 
				}
			}
			
			g.setColor(new Color(252, 255, 38));//Setting the color to red
			g.setFont(new Font("Brush Script MT", Font.BOLD, 30));//Setting the font, font-style and the size of the font
			
			//FontMetrix is used to lining up text in the center of the screen
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score : " + cherriesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score : " + cherriesEaten))/2, g.getFont().getSize());//this will help us to decide from where we should start our string
		} else {
			gameOver(g);
		}
	}
	
	//Every time we call this method this will randomly generate the x and y coordinates of the cherry
	public void newCherry() {
		cherryX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		cherryY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	
	//In this method we will move the snake 
	public void move() {
		
		/*
		 * moving the snake by changing the arrays containing the x and y coordinates by updating them with the previous values 
		 * coordinates at index 0 will contains the coordinates of the head of the snake
		 * once the snake moves the coordinates at the (i-1)th index body part will become the coordinates of the ith body part
		 */
		for(int i = bodyParts; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		/*
		 * this switch is used to change the direction of the snake
		 * since 0 index contains the head of the snake I will update that according the direction user have provided
		 */
		switch(direction) {
		case 'U' : 
			y[0] = y[0]-UNIT_SIZE;
			break;
		case 'D' :
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L' :
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R' :
			x[0] = x[0] + UNIT_SIZE;
		}
	}
	
	public void checkCherry() {
		if((x[0] == cherryX) && (y[0] == cherryY)) {
			bodyParts++;
			cherriesEaten++;
			newCherry();
		}
	}
	
	/*
	 * In this Method if the snake touches any of it's body parts or  it touches any borders we will set the running to false
	 * at the end if the running is false I will stop the timer 
	 */
	public void checkCollision() {
		//in this loop I will check weather the head of the snake touches any other body parts
		for(int i = bodyParts; i>0; i--) {
			if((x[i] == x[0]) && (y[i] == y[0]))
				running = false;
		}
		//If the head of snake touches the left border
		if(x[0] < 0)
			running = false;
		//If the head of snake touches the right border
		if(x[0] > SCREEN_WIDTH)
			running  = false;
		//If the head of the snake touches the top border
		if(y[0] < 0)
			running = false;
		//If the head of the snake touches the bottom border
		if(y[0] > SCREEN_HEIGHT)
			running = false;
		
		if(!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		//Display the score in the Game Over Screen
		g.setColor(new Color(252, 255, 38));//Setting the color to red
		g.setFont(new Font("Brush Script MT", Font.BOLD, 50));//Setting the font, font-style and the size of the font
		
		//FontMetrix is used to lining up text in the center of the screen
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score : " + cherriesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score : " + cherriesEaten))/2, g.getFont().getSize());//this will help us to decide from where we should start our string
		
		//Setting the game over font
		g.setColor(new Color(252, 255, 38));//Setting the color to red
		g.setFont(new Font("Brush Script MT", Font.BOLD, 75));//Setting the font, font-style and the size of the font
		
		//FontMetrix is used to lining up text in the center of the screen
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("GameOver"))/2, SCREEN_HEIGHT/2);//this will help us to decide from where we should start our string
//		g.drawString("Game Over", (SCREEN_WIDTH - "Game Over".length()*UNIT_SIZE*2)/2, SCREEN_HEIGHT/2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();//to move the snake
			checkCherry();//to check weather the snake ran into the a=cherry or not
			checkCollision();//to check weather snake weather the snake collided with it's body or not
		}
		repaint();//if running is not true we will repaint the panel
	}
	
	public class myKeyAdapter extends KeyAdapter{
		/*
		 * In this method I will control the direction of the snake using the Arrow keys
		 * This method is responsible for the changing the direction of the snake
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				if(direction != 'R')//I will not allow the snake to turn by 180 degrees so I'm checking this condition
					direction = 'L';
				break;
			case KeyEvent.VK_RIGHT :
				if(direction != 'L')//I will not allow the snake to turn by 180 degrees so I'm checking this condition
					direction = 'R';
				break;
			case KeyEvent.VK_UP :
				if(direction != 'D')//I will not allow the snake to turn by 180 degrees so I'm checking this condition
					direction = 'U';
				break;
			case KeyEvent.VK_DOWN :
				if(direction != 'U')//I will not allow the snake to turn by 180 degrees so I'm checking this condition
					direction = 'D';
				break;
			}
			
			
		}
	}

}
