package Memory;

import java.awt.Color;

import javax.swing.JPanel;

public class CubeTwoThread implements Runnable{
	JPanel cubeTwo;
	Thread thread;
	
	
	public CubeTwoThread(JPanel cubeTwo){
		this.cubeTwo = cubeTwo;
	}
	
	public void giveThread(Thread thread){
		this.thread = thread;
	}
	
	@Override
	public void run() {
		try {
			boolean runnning = true;
			while(runnning == true){
			Thread.sleep(900);
			cubeTwo.setBackground(Color.red);
			Thread.sleep(900);
			cubeTwo.setBackground(null);
			runnning = false;
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
