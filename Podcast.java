import java.util.*;

public class Podcast{

	private String podcastTitle = "";
	//private Map<String, Podcaster> cast = new HashMap<String, Podcaster>();
	private List<Podcaster> castMembers = new ArrayList<Podcaster>();
	Podcaster currentTalking;
	int currentIndex = -1;
	//private List<String> podcasterNames = new ArrayList<String>();
	
	public Podcast(String podcastTitle){
		this.podcastTitle = podcastTitle;
	}

	public Podcast(String podcastTitle, String... people ){
		/*for (String person : people) {
			cast.put(person, new Podcaster(person));
			podcasterNames.add(person);
		}*/
		for (String person : people ) {
			castMembers.add(new Podcaster(person));
		}
	}

	public Podcast(String podcastTitle, List<String> people){
		for (String person : people) {
			castMembers.add(new Podcaster(person));
		}
	}
	/*public void startTimer(String person){
		System.out.println("starting talk counter for " + person);

		currentTalking = cast.get(person);
		currentTalking.startTalkTimer();
		
	}*/

	/*add thrown exceptions here*/

	public void startTimer(int index) throws IndexOutOfBoundsException {

		if (currentIndex != index ){
			currentTalking = castMembers.get(index);
			currentTalking.startTalkTimer();
			System.out.println("starting timer for " + currentTalking.getName());
			currentIndex = index;
		}
	}

	/*public void stopTimer(String person){
		System.out.println("stopping talk counter for " + person);

		if (person.length() != 0){ // NOT very first time staring podcast counter
			currentTalking.stopTalkTimer();
			System.out.println(person + "'s current talk time is " + currentTalking.getTalkTimeSec());
		}
	}*/

	public void stopTimer(){
		//System.out.println("current index is " + currentIndex);
		if(currentTalking != null){
			currentTalking.stopTalkTimer();
			System.out.println("stopping timer for " + currentTalking.getName() + "   " + currentTalking.getTalkTimeSec());
		}
	}

	public String[] getAllPodcasterNames(){
		String[] names = new String[castMembers.size()];
		for (int i=0; i<names.length; i++) {
			names[i]=castMembers.get(i).getName();
		}
		return names;
	}

	public int getCastSize(){
		return castMembers.size();
	}

	@Override
	public String toString(){
		StringJoiner joiner = new StringJoiner(", ");
		for (Podcaster caster : castMembers)
		{
		    joiner.add(caster.getName()+ ": " + caster.getTalkTimeSec());
		}

		return joiner.toString();
	}

	public String getCastMemberName(int index){
		return castMembers.get(index).getName();
	}


	/*TODO: Implement toString() method here!!!!*/
/*
	public long getTalkTime(String name){
		if (name.length() != 0){
			return cast.get(name).getTalkTimeSec();
		}
		return 0;
	}
*/
	
}