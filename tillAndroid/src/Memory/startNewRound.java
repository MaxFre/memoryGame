package Memory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;



public class startNewRound implements Runnable{
	
	
	ArrayList<Integer> order = new ArrayList<Integer>();
	
	cubeOneThread cubeOneThread;
	CubeTwoThread CubeTwoThread;
	CubeThreeThread CubeThreeThread;
	MemoryController controller;
	
	Thread cubeOne, cubeTwo, cubeThree;
	int turn;
	JPanel cubeOneBox, cubeTwoBox, cubeThreeBox;
	
	public startNewRound(MemoryController controller, int turn,JPanel cubeOneBox,JPanel cubeTwoBox,JPanel cubeThreeBox){
		this.controller = controller;
		this.turn = turn;
		this.cubeOneBox = cubeOneBox;
		this.cubeTwoBox = cubeTwoBox;
		this.cubeThreeBox = cubeThreeBox;

	}
	
	public void random(){
		int whatBoX;
		Random rand = new Random();
		whatBoX = rand.nextInt(3)+1;
//		System.out.println(whatBoX);
		
		order.add(whatBoX);
		
		if(whatBoX==1){
		lightBoxOne(cubeOneBox);
		}	
		if(whatBoX==2){
		lightBoxTwo(cubeTwoBox);
		}	
		if(whatBoX==3){
		lightBoxThree(cubeThreeBox);
		}
	}
	
	public void lightBoxOne(JPanel box){
		cubeOneThread = new cubeOneThread(box);
		cubeOne = new Thread(cubeOneThread);
		cubeOneThread.giveThread(cubeOne);	
		cubeOne.start();	
	}
	
	public void lightBoxTwo(JPanel box){
		CubeTwoThread = new CubeTwoThread(box);
		cubeTwo = new Thread(CubeTwoThread);
		CubeTwoThread.giveThread(cubeTwo);	
		cubeTwo.start();

	}
	
	public void lightBoxThree(JPanel box){
		CubeThreeThread = new CubeThreeThread(box);
		cubeThree = new Thread(CubeThreeThread);
		CubeThreeThread.giveThread(cubeThree);	
		cubeThree.start();

	}


	@Override
	public void run() {
		try {
			int done = 1;
		while(turn>=done){
			Thread.sleep(200);
			random();
			Thread.sleep(900);
			
			if(turn==done){
				Thread.sleep(900);
				controller.whatOrder(order);
			}
			done++;
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
