package Memory;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class MemoryController{

	JLabel currentScore;
	JLabel currentHighScore;
	JPanel main;
	
	public int turn = 1;
	public int highscore = 0;
	boolean cubeOneOn = false;
	boolean cubeTwoOn = false;
	boolean cubeThreeOn = false;
	
	wrongThread wrongThreads;
	fastClick fastClick;
	MemoryGui gui;
	cubeOneThread cubeOneThread;
	startNewRound startNewRound;
	Thread newRound, fastclickThread, wrongAnswerThread;
	

	
	ArrayList<Integer> order = new ArrayList<Integer>();
	
	public MemoryController(){
		gui = new MemoryGui(this);
	}
	
	
	public void callStart(JPanel main,JLabel currentHighScore,JLabel currentScore,JPanel cubeOne,JPanel cubeTwo,JPanel cubeThree){
		this.currentScore = currentScore;
		this.currentHighScore = currentHighScore;
		this.main = main;
		
		gui.disableButtons();
		gui.disableStart();
		startNewRound = new startNewRound(this,turn,cubeOne,cubeTwo,cubeThree);
		newRound = new Thread(startNewRound);
		newRound.start();
	}
	
	public void roundDone(){
		gui.disableButtons();
		gui.enableStart();
		turn++;
		currentScore.setText("Current score: " + (turn-1));
		if(turn>highscore){
			highscore = turn-1;
			currentHighScore.setText("Current Highscore: " + highscore);
		}
	}
	

	
	public void wrongAnswerEffect(){
		wrongThreads = new wrongThread(this, main);
		wrongAnswerThread = new Thread(wrongThreads);
		wrongAnswerThread.start();	
	}
	
	public void wrongAnswer(){
		gui.fixScreen();
		System.out.println("WRONG!");
		gui.disableButtons();
		turn = 1;
		currentHighScore.setText("Oooops, you failed!");
		currentScore.setText("Current score: " + (turn-1));
		gui.enableStart();
	}

	public void callCubeOne(JPanel cubeOne){	
		fastClick = new fastClick(cubeOne, 1);
		fastclickThread = new Thread(fastClick);
		fastclickThread.start();	
		
		if(order.get(0)==1){
			order.remove(0);
			if(order.size() == 0){
				System.out.println("Correct!");
				roundDone();
			}
		}
		else{
			wrongAnswerEffect();
		}	 
	}
	

	
	public void callCubeTwo(JPanel cubeTwo){
		fastClick = new fastClick(cubeTwo, 2);
		fastclickThread = new Thread(fastClick);
		fastclickThread.start();
		if(order.get(0)==2){
			order.remove(0);
			if(order.size() == 0){
				System.out.println("Correct!");
				roundDone();
			}
		}
		else{
			wrongAnswerEffect();
		}
	}
	
	public void callCubeThree(JPanel cubeThree){
		fastClick = new fastClick(cubeThree,3);
		fastclickThread = new Thread(fastClick);
		fastclickThread.start();
		
		if(order.get(0)==3){
			order.remove(0);
			if(order.size() == 0){
				System.out.println("Correct!");
				roundDone();
			}
		}
		else{
			wrongAnswerEffect();
		}
	}
	
	public void whatOrder(ArrayList order){
		this.order = order;
//		System.out.println(order);
		gui.enableButtons();
	}
	
	public static void main(String[] args) {

		MemoryController run = new MemoryController();

	}

}
