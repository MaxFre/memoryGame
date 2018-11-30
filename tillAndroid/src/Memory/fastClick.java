package Memory;

import java.awt.Color;

import javax.swing.JPanel;

public class fastClick implements Runnable{
	JPanel box;
	int whatBox;
	
	public fastClick(JPanel box, int whatBox){
		this.box = box;
		this.whatBox = whatBox;
	}
	
	
	
	@Override
	public void run() {
		
		if(whatBox==1){
			box.setBackground(Color.yellow);
		}
		if(whatBox==2){
			box.setBackground(Color.red);
		}
		if(whatBox==3){
			box.setBackground(Color.green);
		}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			box.setBackground(null);
		
		
		
		
	}

}
