public class Podcaster{
	private String name = "";
	private long talkTime = 0; //in seconds
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;

	public Podcaster(String name){
		this.name = name;
	}

	public void startTalkTimer() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}

	public void stopTalkTimer() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
		addTalkTime();
	}

	//add amount of time a podcaster talks in milliseconds
	public void addTalkTime() {
		talkTime += this.stopTime - this.startTime;
	}

	//elaspsed time in seconds
	public long getTalkTimeSec() {
		return (talkTime / 1000);
	}

	public String getName(){
		return name;
	}

	public boolean isRunning(){
		if (running)
			return true;
		else 
			return false;
	}

}