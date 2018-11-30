package Memory;

import java.awt.Color;

import javax.swing.JPanel;

public class cubeOneThread implements Runnable{
	JPanel cubeOne;
	Thread thread;
	
	
	public cubeOneThread(JPanel cubeOne){
		this.cubeOne = cubeOne;
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
			cubeOne.setBackground(Color.yellow);
			Thread.sleep(900);
			cubeOne.setBackground(null);
			runnning = false;
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
