package dsa.algoAnimation;

import javax.swing.JFrame;

public class animationFrame extends JFrame {

	public animationFrame(){
		add(new Sorting());
		setTitle("ALgorithm Visualizer");
	    setSize(800, 450);
	    setLocation(300, 5);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(false);
	}
	
	
}
