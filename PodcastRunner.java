import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class PodcastRunner{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	List<String> castList = new ArrayList<String>();;
	Podcast podcast = null;
	String data = "";
	String podcastTitle = "";

	while(!data.equals("done")){
		try{
			if (castList.size()==0){
				System.out.println("Enter the podcast Title. \nTitle: ");
				podcastTitle = sc.nextLine();
			}
		
			System.out.println("Now enter names of the cast. Enter \"done\" when finished");

		    data = sc.nextLine();
		    if (data.equals("done"))
		    	break;
		    else
				castList.add(data);
		} catch (InputMismatchException e){
			sc.next();
			System.out.println("Please input a valid value");
		}
	}



	/*check for list correctness*/
	for (String s : castList) {
		System.out.println(s);
	}

	podcast = new Podcast(podcastTitle, castList);
	//podcast = new Podcast("Groom Fake Thursday Podcast", "Vroom", "King ButtHat", "Garbage Pail"); NOTE: for test use 
	System.out.println();
	for (int i=0; i<castList.size(); i++) {
		System.out.print((i+1) + ") " + castList.get(i) + " ");
	}
	//System.out.println(podcast.getAllPodcasterNames());

	System.out.println("   Starting podcast...");
	
	System.out.println("Starting counter\n");
	int cmd = -1;
	int prevCmd = -100;
	String currTalkerName = "";

	while(cmd!=0){
		try{	
			System.out.println("Enter the cast member's number that you want to start/stop counting for. Press 0 when done.");
			cmd = sc.nextInt();			
			if (cmd == 0)
				break;

			else if (cmd != prevCmd){
				podcast.stopTimer();
				podcast.startTimer(cmd);
				prevCmd = cmd;
				System.out.println("prevCmd = " + prevCmd + "   cmd = " + cmd);
			}
			else {
				System.out.println(podcast.getCastMemberName(cmd)+"'s counter is already running.");
			}
			
		} catch (InputMismatchException e){
			sc.next();
			System.out.println("Please enter a number");
		} catch (IndexOutOfBoundsException e){
			sc.next();
			System.out.println("Please enter a number one through " + podcast.getCastSize());
		}

		
	}
		System.out.println(podcast.getAllPodcasterNames());
		System.out.println(podcast.getCastSize());
		System.out.println(podcast.toString());
		
	}	
}