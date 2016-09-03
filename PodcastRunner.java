import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileReader;
import java.io.IOException;

public class PodcastRunner{
public static void main(String[] args) throws IOException {
	Podcast podcast = new Podcast("Groom Fake Thursday Podcast", "Vroom", "King ButtHat", "Garbage Pail");
	System.out.println(podcast.getAllPodcasterNames());
	System.out.println("Starting podcast...");
	Scanner sc = new Scanner(System.in);
	System.out.println("Starting counter\n");
	short cmd = -1;
	String currTalkerName = "";

	while (cmd != 0) {
		System.out.println("\nChoose a caster to start");
		try{
			cmd = sc.nextShort();
		} catch (InputMismatchException e){
			sc.next();
		}
		switch (cmd) {
			case -1:
				System.out.println("Please choose a valid input");
			break;
			case 1:
				System.out.println("stopping " + currTalkerName + " counter\n");
				podcast.stopTimer(currTalkerName);
				currTalkerName = "Vroom"; 
				System.out.println("talk time =" + podcast.getTalkTime(currTalkerName));
				System.out.println("Vroom counter started");
				podcast.startTimer("Vroom");
				currTalkerName = "Vroom"; 
				System.out.println();
			break;
			case 2:
				System.out.println("stopping " + currTalkerName + " counter\n");
				podcast.stopTimer(currTalkerName);
				currTalkerName = "King ButtHat";
				System.out.println("talk time =" + podcast.getTalkTime(currTalkerName));
				System.out.println("King ButtHat counter started");
				podcast.startTimer("King ButtHat");
				currTalkerName = "King ButtHat";
				System.out.println();
			break;
			case 3:
				System.out.println("stopping " + currTalkerName + " counter\n");
				podcast.stopTimer(currTalkerName);
				currTalkerName = "Garbage Pail";
				System.out.println("talk time =" + podcast.getTalkTime(currTalkerName));
				System.out.println("Garbage Pail counter started");
				podcast.startTimer("Garbage Pail");
				System.out.println();
			break;
			case 0:
				System.out.println("cancelling");
			break;
			default:
				System.out.println("not vaild choice");
			break;

		}
	}

		System.out.println(podcast.getAllPodcasterData());
		
	}	
}