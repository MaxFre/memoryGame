package Memory;

import java.awt.Color;

import javax.swing.JPanel;

public class CubeThreeThread implements Runnable{
	JPanel cubeThree;
	Thread thread;
	
	
	public CubeThreeThread(JPanel cubeThree){
		this.cubeThree = cubeThree;
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
			cubeThree.setBackground(Color.green);
			Thread.sleep(900);
			cubeThree.setBackground(null);
			runnning = false;
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
