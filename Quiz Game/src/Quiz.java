import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {
	
	//Question array contains the set of questions
	String[] questions = 	{
								"What’s name of deity at Belur Temple ?",
								"Which river originates from Ambuteertha in Teerthahalli Taluk ?",
								"Which Bollywood actress made her cinematic debut in Kannada movie Prema Loka ?",
								"What’s the name of luxury tourist train operated by Karnataka Tourism",
								"Who composed the music for film “America America”",
								"Who among these personalities have not won “Bharath Ratna” ?",
								"Which of these locations in Karnataka is included in UNESCO world heritage sites",
								"Who defeated Harshavardhana of Kanauj in a decisive battle fought on the banks of the river Narmada ?",
								"Which was the first multinational corporation (MNC) to set-up its base in Bangalore ?",
								"Impressed by whose views on science and leadership abilities of India, Jamshedji Tata set-up IISc in Bangalore ?",
								"What's the original nationality of Mother Teresa ?",
								"Who was the first Indian to win professional tennis grand slam title ?",
								"Which was the first Indian film to be screened at United Nations ?",
								"Which country is ranked #1 in per capita income as per the Human Development Report of 2011 published by the United Nations ?",
								"Name the managing director of a large business group who studied to be a filmmaker before he graduated from Harvard Business School. He has produced a short film on the Kumbh Mela and his business group is currently planning a foray into the media and entertainment sector."
							};
	
	//2D array options 4 options each for the question in the above array at corresponding index
	String[][] options = 	{
								{"Manjunatha","Bahubali","Chennakeshava","Virupaksha"},
								{"Nethravathi","Cauvery","Tunga","Sharavathi"},
								{"Sridevi","Madhuri Dixit","Juhi Chawla","Kajol"},
								{"Palace on Wheels","Orient Express","Golden Chariot","Golden Chariot"},
								{"Guru Kiran","Raghu Dixit","Mano Murthy","Ravichandran"},
								{"Mahatma Gandhi","S. Radhakrishna","Mother Teresa"," Rajiv Gandhi"},
								{"Belur","Pattadkal","Gol Gumbaz","Badami"},
								{"Veera ballala I","Pulakeshi I","Pulakeshi II","Krishnadevaraya"},
								{"IBM","Cisco Systems","Texas Instruments","General Electric"},
								{"Mahatma Gandhi","Jawaharlal Nehru","Swami Vivekananda","Rabindranath Tagore"},
								{"Germany","Albania","France","Luxembourg"},
								{"Mahesh Bhupathi","Sania Mirza","Leander Paes","Sania Mirza"},
								{"Slumdog Millionaire","Lagaan","Lage Raho Munnabhai","Chak De India"},
								{"Saudi Arabia","USA","Germany","Qatar"},
								{"Vijay Mallya","Anand Mahindra","Mukesh Ambani","Ratan Tata"}
							};
	
	//Answers array contains the answer of each question at the corresponding index
	char[] answers = 		{
								'C',
								'D',
								'C',
								'C',
								'C',
								'A',
								'B',
								'C',
								'C',
								'C',
								'B',
								'A',
								'B',
								'D',
								'B'
							};
	
	
	char guess;//to store the answer given by the user
	char answer;//to store the correct answer
	int index;//iterator kind of thing
	int correctGuesses = 0;//to store the number of correct answers given by the user
	int totalQuestions = questions.length;//total number of questions we have
	int result;//to store the result of the quiz
	int seconds=45;//used by timer, thought of giving 10 seconds to answer each question
	
	
	JFrame frame = new JFrame();//to hold everything
	JTextField textField = new JTextField();//this will hold the current question that we are on
	JTextArea textArea = new JTextArea();//text are to hold the current question
	JButton buttonA = new JButton();//button for option A
	JButton buttonB = new JButton();//button for option B
	JButton buttonC = new JButton();//button for option C
	JButton buttonD = new JButton();//button for option D
	//labels to hold the different answers, contains the value of the answers
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel answerLabelD = new JLabel();
	
//	JLabel timeLabel = new JLabel();//to show the word "Timer"
	JLabel secondsLeft = new JLabel();//this will function as the display for the count down timer
	JTextField numberRight = new JTextField();//this will display the number of correct answers given by the user
	JTextField percentage = new JTextField();//this is used to display the percentage score of the quiz
	
	//This is the timer that will be executed every 1 second once we start the timer
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Every time this methods runs that is each second I'm gonna decrement the seconds variable
			seconds--;
			//Display the decremented seconds variable each second
			secondsLeft.setText(seconds+"");
			
			//if the timer runs out I consider it as the wrong answer and I will show the answer.
			if(seconds<=0) {
				showAnswer();
			}
		}
		
	});

	public Quiz() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit the fame when we press close button on window
		frame.setSize(1200, 650);//setting the size of the frame in pixels
		frame.getContentPane().setBackground(new Color(50, 50, 50));//setting the color of the background 
		frame.setLayout(null);//I'm not using the layout manager I want to handle the sizes of all the components manually
		frame.setResizable(false);//Setting the frame size to be constant, user can not adjust that.
		
		
		textField.setBounds(0, 0, 1200, 50);//sets the position of the field, height and breadth of the field
		textField.setBackground(new Color(40, 40, 40));//sets the background of the textField
		textField.setForeground(new Color(25, 255, 0));//sets the text color
		textField.setFont(new Font("Ink Free", Font.BOLD, 30));//Setting the font style
		textField.setBorder(BorderFactory.createBevelBorder(1));//setting the border for the textField
		textField.setHorizontalAlignment(JTextField.CENTER);//Positioning the text inside the textField to the center
		textField.setEditable(false);//By this I am not letting the user to edit the textField
//		textField.setText("Testing the textField"); // just for testing.
		
		textArea.setBounds(0, 50, 1200, 150);//sets the position of the field, height and breadth of the textArea
		textArea.setLineWrap(true);//if text over flows the frame extra text will come in the new line
		textArea.setWrapStyleWord(true);//wrapped upon the words not on characters
		textArea.setBackground(new Color(40, 40, 40));//sets the background of the textArea
		textArea.setForeground(new Color(25, 255, 0));//sets the text color
		textArea.setFont(new Font("MV Boli", Font.BOLD, 25));//Setting the font style
		textArea.setBorder(BorderFactory.createBevelBorder(1));//setting the border for the textArea
		textArea.setEditable(false);//By this I am not letting the user to edit the textArea
//		textArea.setText("Sample question?"); // for testing the textArea
		
		buttonA.setBounds(0, 350, 100, 100);//positioning and setting the button size
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the fontStyle of the button
//		buttonA.setFocusable(false);//some times when we clock a button it is high lighted
		buttonA.addActionListener(this);//adding the action listener to the button
		buttonA.setText("A");//this text will display on the button
		
		buttonB.setBounds(575, 350, 100, 100);//positioning and setting the button size
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the fontStyle of the button
//		buttonB.setFocusable(false);//some times when we clock a button it is high lighted
		buttonB.addActionListener(this);//adding the action listener to the button
		buttonB.setText("B");//this text will display on the button
		
		buttonC.setBounds(0, 500, 100, 100);//positioning and setting the button size
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the fontStyle of the button
//		buttonC.setFocusable(false);//some times when we clock a button it is high lighted
		buttonC.addActionListener(this);//adding the action listener to the button
		buttonC.setText("C");//this text will display on the button
		
		buttonD.setBounds(575, 500, 100, 100);//positioning and setting the button size
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the fontStyle of the button
//		buttonD.setFocusable(false);//some times when we clock a button it is high lighted
		buttonD.addActionListener(this);//adding the action listener to the button
		buttonD.setText("D");//this text will display on the button
		
		
		answerLabelA.setBounds(125, 350, 450, 100);//Setting the position and size of the answer labels
		answerLabelA.setBackground(new Color(50, 50, 50));//Setting the background color
		answerLabelA.setForeground(new Color(25, 255, 0));//Setting the color of the text in the label
		answerLabelA.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the font style
//		answerLabelA.setText("Option A");//testing the alignment of the label
		
		answerLabelB.setBounds(700, 350, 450, 100);//Setting the position and size of the answer labels
		answerLabelB.setBackground(new Color(50, 50, 50));//Setting the background color
		answerLabelB.setForeground(new Color(25, 255, 0));//Setting the color of the text in the label
		answerLabelB.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the font style
//		answerLabelB.setText("Option B");//testing the alignment of the label
		
		answerLabelC.setBounds(125, 500, 450, 100);//Setting the position and size of the answer labels
		answerLabelC.setBackground(new Color(50, 50, 50));//Setting the background color
		answerLabelC.setForeground(new Color(25, 255, 0));//Setting the color of the text in the label
		answerLabelC.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the font style
//		answerLabelC.setText("Option C");//testing the alignment of the label
		
		answerLabelD.setBounds(700, 500, 450, 100);//Setting the position and size of the answer labels
		answerLabelD.setBackground(new Color(50, 50, 50));//Setting the background color
		answerLabelD.setForeground(new Color(25, 255, 0));//Setting the color of the text in the label
		answerLabelD.setFont(new Font("MV Boli", Font.BOLD, 35));//Setting the font style
//		answerLabelD.setText("Option D");//testing the alignment of the label
		
		secondsLeft.setBounds(550, 225, 100, 100);//Setting the position and size of the timer
		secondsLeft.setBackground(new Color(50, 50, 50));//Setting the background of the times
		secondsLeft.setForeground(new Color(255, 0, 0));//Setting the color of the timer font
		secondsLeft.setFont(new Font("Ink Free", Font.BOLD, 50));//Setting the fonts of the timer
//		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));//Setting the border to the timer
		secondsLeft.setOpaque(true);// making the timer field opaque
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);//Aligning the text inside the timer to center
//		secondsLeft.setVerticalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));//Shows the seconds left while doing the quiz
		
		numberRight.setBounds(450, 100, 300, 100);//Setting the position and the size of the numberRight
		numberRight.setBackground(new Color(25, 25, 25));//Setting the background color of the numberRight
		numberRight.setForeground(new Color(25, 255, 0));//Setting the font color of the numberRight
		numberRight.setFont(new Font("Ink Free", Font.BOLD, 60));//Setting the font style in numberRight
		numberRight.setEditable(false);//I'm not letting the users to edit the results
		numberRight.setBorder(BorderFactory.createBevelBorder(1));//Setting the border
		numberRight.setHorizontalAlignment(JTextField.CENTER);//Aligning the contents to center
		
		percentage.setBounds(450, 250, 300, 100);//Setting the position and the size of the percentage label
		percentage.setBackground(new Color(25, 25, 25));//Setting the background color of the percentage
		percentage.setForeground(new Color(25, 255, 0));//Setting the text color of the percentage label
		percentage.setBorder(BorderFactory.createBevelBorder(1));//Setting the Border of the percentage
		percentage.setFont(new Font("Ink Free", Font.BOLD, 60));//Setting the font style of the percentage
		percentage.setEditable(false);//I'm not letting the user to edit the result
		percentage.setHorizontalAlignment(JTextField.CENTER);//Aligning the text in the label to center
		
		
		frame.add(textField);//Adding the text field to the frame
		frame.add(textArea);//Adding the textArea to frame
		
		//Adding the buttons to the frame
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		
		//Adding the answer labels to frame
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(answerLabelC);
		frame.add(answerLabelD);
		
		frame.add(secondsLeft);//Adding the timer to the frame
//		frame.add(numberRight);//Adding the numberRight to frame
//		frame.add(percentage);//Adding the percentage to frame
		
		frame.setVisible(true);// if we set it to false frame will not come up
		
		nextQuestion();//Calling the next question method to start the quiz
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//this method will get triggered when somebody clicks the button
		//for temporarily I'm disabling the buttons to avoid the user to change the answer he/she given.
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		//Next thing is to determine which button is being pressed and check weather that matches with the correct answer in the answer array
		if(e.getSource() == buttonA) {
			answer = 'A';
			if(answer == answers[index])
				correctGuesses++;
		}
		if(e.getSource() == buttonB) {
			answer = 'B';
			if(answer == answers[index])
				correctGuesses++;
		}
		if(e.getSource() == buttonC) {
			answer = 'C';
			if(answer == answers[index])
				correctGuesses++;
		}
		if(e.getSource() == buttonD) {
			answer = 'D';
			if(answer == answers[index])
				correctGuesses++;
		}
		
		//after this we need to show the answer so I'm calling the showAnswer method
		showAnswer();
	}
	
	public void nextQuestion() {
		/*
		 * First check the weather the number of questions we have got over or not.
		 * if they got over call the showResult method
		 */
		if(index >= totalQuestions) {
			showResult();
		}//else I'm going to populate the frame with the question number, question, options
		else {
			textField.setText("Question "+ (index+1));
			textArea.setText(questions[index]);
			answerLabelA.setText(options[index][0]);
			answerLabelB.setText(options[index][1]);
			answerLabelC.setText(options[index][2]);
			answerLabelD.setText(options[index][3]);
			timer.start();//Starting the timer
		}
	}
	
	public void showResult() {
		//First disable all the buttons to avoid the user from clicking the answers even after the quiz is over
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		textField.setText("RESULT..!");//In the place of question number I'm displaying the phrase "RESULTS..!"
		textArea.setText("");//Setting the textArea which shows question to empty
		//Setting the answerLabel which shows answers to empty
		answerLabelA.setText("");
		answerLabelB.setText("");
		answerLabelC.setText("");
		answerLabelD.setText("");
		
		//Setting the text of the timer as well to empty
		secondsLeft.setText("");
		
		//Calculating the result percentage
		result = (int)((correctGuesses/(double)totalQuestions)*100);
		
		numberRight.setText("(" + correctGuesses + "/" + totalQuestions + ")");//Setting the text in the NumberRight
		percentage.setText(result+"%");//Setting the text in the percentage
		
		//Removing all the components from the frame
		frame.getContentPane().removeAll();
		frame.repaint();
		
		//Adding the textField, numberRight and percentage to the frame
		frame.add(textField);
		frame.add(numberRight);
		frame.add(percentage);
	}
	
	public void showAnswer() {
		
		timer.stop();//Stop the timer once the user answers the question.
		//Irrespective of weather the user will click the options or not we will show the answer so I'm disabling the options as of now
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		if (answers[index] != 'A')
			answerLabelA.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'B')
			answerLabelB.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'C')
			answerLabelC.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'D')
			answerLabelD.setForeground(new Color(255, 0, 0));
		
		//After showing the answer I'm going to give the pause of 2 seconds and then go to the nextQuestion
		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//First I will change the color of the labels back to green
				answerLabelA.setForeground(new Color(25, 255, 0));
				answerLabelB.setForeground(new Color(25, 255, 0));
				answerLabelC.setForeground(new Color(25, 255, 0));
				answerLabelD.setForeground(new Color(25, 255, 0));
				
				//Reset the countDown timer to 10
				seconds = 45;
				secondsLeft.setText(String.valueOf(seconds));
				
				//Enabling the buttons for the next question
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				
				answer = ' ';//resetting the answer
				index++;//Incrementing the index
				
				//Calling the nextQuestion method
				nextQuestion();
				
			}
			
		});
		
		pause.setRepeats(false);//This will execute every 2 seconds if we call start so to avoid that I'm not letting it to repeat
		pause.start();//This will start the pause timer
	}
}
