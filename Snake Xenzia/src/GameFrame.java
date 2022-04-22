import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	//In this class I will only create the frame or the window in which we play the game
	public GameFrame() {
		this.add(new GamePanel());//Directly adding the instance of the GamePanle to the frame without using the variable
		this.setTitle("Snake Xenzia");//Setting the name of the frame to "Snake Xenzia"
		this.setResizable(false);//this will not allow users to resize the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//this will close the window when we press the close button of the window
		this.pack();//this will take the jFrame and add the components that we add in the closely fitting or secure manner
		this.setVisible(true);//this will make the window visible once we start the game, if we set it to false window will not pup up
		this.setLocationRelativeTo(null);//to get the window in the middle of the screen
	}

}
