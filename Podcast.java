import java.util.*;
import java.lang.StringBuilder;

public class Podcast{

	private String podcastTitle = "";
	Map<String, Podcaster> cast = new HashMap<String, Podcaster>();
	Podcaster currentTalking;
	private List<String> podcasterNames = new ArrayList<String>();
	
	public Podcast(String podcastTitle){
		this.podcastTitle = podcastTitle;
	}

	public Podcast(String podcastTitle, String... people ){
		for (String person : people) {
			cast.put(person, new Podcaster(person));
			podcasterNames.add(person);
		}

		//castMembers = cast.keys();
	}
	public void startTimer(String person){
		System.out.println("starting talk counter for " + person);

		currentTalking = cast.get(person);
		currentTalking.startTalkTimer();
		
	}

	public void stopTimer(String person){
		System.out.println("stopping talk counter for " + person);

		if (person.length() != 0){ // NOT very first time staring podcast counter
			currentTalking.stopTalkTimer();
			System.out.println(person + "'s current talk time is " + currentTalking.getTalkTimeSec());
		}
	}

	public String getAllPodcasterNames(){
		//StringBuilder returnedNames = new StringBuilder();
		StringJoiner joiner = new StringJoiner(", ");
		for (String name : podcasterNames) {
			joiner.add(name);
			
		}
		return joiner.toString();
	}

	public String getAllPodcasterData(){
		StringJoiner joiner = new StringJoiner(", ");
		for (Map.Entry<String, Podcaster> entry : cast.entrySet())
		{
		    joiner.add(entry.getKey() + " " + entry.getValue().getTalkTimeSec());
		}

		return joiner.toString();

	}

	public long getTalkTime(String name){
		if (name.length() != 0){
			return cast.get(name).getTalkTimeSec();
		}
		return 0;
	}

	/*@Override
	public String toString(){
		StringBuilder names = new StringBuilder();
		for (Podcaster caster : cast) {
			names.append(" " + caster.getName() + ',');
		}
		return (podcastTitle + " \nPeople in podcast: " + names);
	}*/
	
}

/*******
Issues: 
	- how to mock a radio button? with hash table and making a "currTalker" object
	- how to start one persons timer and end the previous one without iterating through the table

*******/