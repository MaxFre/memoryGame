package Memory;

import java.awt.Color;

import javax.swing.JPanel;

public class wrongThread implements Runnable{
	JPanel wrong;
	MemoryController MemoryController;
	
	public wrongThread(MemoryController MemoryController, JPanel wrong){
		this.wrong = wrong;
		this.MemoryController = MemoryController;
	}

	public void run() {
		try{
			wrong.setBackground(Color.red);
			Thread.sleep(50);
			wrong.setBackground(Color.LIGHT_GRAY);
			Thread.sleep(50);
			wrong.setBackground(Color.red);
			Thread.sleep(50);
			wrong.setBackground(Color.LIGHT_GRAY);
			
			MemoryController.wrongAnswer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
