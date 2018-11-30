package Memory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class MemoryGui extends JFrame implements ActionListener {
	
	private JLabel currentScore = new JLabel("Current score: ");
	private JLabel currentHighScore = new JLabel("This is a memorygame, press in the right order");
	
	private JFrame frame;
	private JPanel cubeOne;
	private JPanel cubeTwo;
	private JPanel cubeThree;
	private JPanel main;
	
	private JButton start = new JButton("Start");
	private JButton pressCubeOne = new JButton("");
	private JButton pressCubeTwo = new JButton("");
	private JButton pressCubeThree = new JButton("");
	
	
	MemoryController controller;
	
	public MemoryGui(MemoryController controller){
		this.controller = controller;
		start();
	}
	
	public void start(){
		frame = new JFrame();
		frame.setBounds(0, 0, 819, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("MemoryGame");		
		InitializeGUI();					// Fill in components
		frame.setVisible(true);
		frame.setResizable(false);			// Prevent user from change size
		frame.setLocationRelativeTo(null);	// Start middle screen
		
	}
	
	
	
	
	private void InitializeGUI(){
		
		
		currentHighScore.setBounds(310, 10, 355,25);
		currentScore.setBounds(310, 270, 155,25);
	
	
		main = new JPanel();
		main.setBorder(BorderFactory.createLineBorder(Color.black));
		main.setBounds(0, 0, 819,438);		
		main.setBackground(Color.LIGHT_GRAY);
		
		cubeOne = new JPanel();
		cubeOne.setBorder(BorderFactory.createLineBorder(Color.black));
		cubeOne.setBounds(40, 70, 185,185);		
			
		cubeTwo = new JPanel();
		cubeTwo.setBorder(BorderFactory.createLineBorder(Color.black));
		cubeTwo.setBounds(300, 70, 185,185);
		
		cubeThree = new JPanel();
		cubeThree.setBorder(BorderFactory.createLineBorder(Color.black));
		cubeThree.setBounds(560, 70, 185,185);
		
		pressCubeOne.setBounds(40,70,185,185);
		pressCubeTwo.setBounds(300,70,185,185);
		pressCubeThree.setBounds(560,70,185,185);
		
		
		pressCubeOne.setOpaque(false);
		pressCubeOne.setContentAreaFilled(false);
		pressCubeOne.setBorderPainted(false);
		
		pressCubeTwo.setOpaque(false);
		pressCubeTwo.setContentAreaFilled(false);
		pressCubeTwo.setBorderPainted(false);
		
		pressCubeThree.setOpaque(false);
		pressCubeThree.setContentAreaFilled(false);
		pressCubeThree.setBorderPainted(false);
		
		
		
		start.setBounds(310, 370, 155,25);
		
		
		frame.add(currentHighScore);
		frame.add(currentScore);
		frame.add(pressCubeThree);
		frame.add(pressCubeTwo);
		frame.add(pressCubeOne);
		frame.add(cubeOne);
		frame.add(cubeTwo);
		frame.add(cubeThree);
		frame.add(start);
		frame.add(main);
		
		start.addActionListener(this);
		pressCubeOne.addActionListener(this);
		pressCubeTwo.addActionListener(this);
		pressCubeThree.addActionListener(this);
	
		disableButtons();
	}
	
	public void disableStart(){
		start.setText("");
		start.setEnabled(false);
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
	}
	
	public void enableStart(){
		start.setText("Start");
		start.setEnabled(true);
		start.setOpaque(true);
		start.setContentAreaFilled(true);
		start.setBorderPainted(true);
	}
	
	public void disableButtons(){
		pressCubeOne.setEnabled(false);
		pressCubeTwo.setEnabled(false);	
		pressCubeThree.setEnabled(false);
	}
	
	public void enableButtons(){
		pressCubeOne.setEnabled(true);
		pressCubeTwo.setEnabled(true);	
		pressCubeThree.setEnabled(true);
	}
	
	public void fixScreen(){
		enableButtons();
		enableStart();	
		cubeOne.setBackground(null);		
		cubeTwo.setBackground(null);
		cubeThree.setBackground(null);		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == start) {
			controller.callStart(main,currentHighScore,currentScore,cubeOne,cubeTwo,cubeThree);
		}
		
		if (e.getSource() == pressCubeOne) {
			controller.callCubeOne(cubeOne);
		}
		
		if (e.getSource() == pressCubeTwo) {
			controller.callCubeTwo(cubeTwo);
		}
		
		if (e.getSource() == pressCubeThree) {
			controller.callCubeThree(cubeThree);
		}
}
}
