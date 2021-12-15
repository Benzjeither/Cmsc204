import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	Random directions;
	int randomNum;
	Queue<Integer> queue;
	
	public CarQueue() {
		directions=new Random();
		queue = new ArrayDeque<Integer>();
		
		for (int i = 0; i < 6; i++) {
			queue.add(directions.nextInt(4));
		}

	}
	
	
	public Random getDirections() {
		
		return directions;
	}
	public void setDirections(Random directions) {
		
		this.directions = directions;
	}
	public Queue<Integer> getQueue() {
		return queue;
	}
	public void setQueue(Queue<Integer> queue) {
		this.queue = queue;
	}
	
	
	public int deleteQueue() {
	
		randomNum=queue.remove();
		return randomNum;
		
	}
	public void addToQueue() {
		
		class Run implements Runnable{
			@Override
			public void run() {
				
				try {
					while (true) {
						queue.add(directions.nextInt(4));
						Thread.sleep(100);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		Run r = new Run();
		Thread t = new Thread(r);
		t.start();
	}
}