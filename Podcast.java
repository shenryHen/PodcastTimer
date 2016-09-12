import java.util.*;

public class Podcast{

	private String podcastTitle = "";
	private List<Podcaster> castMembers = new ArrayList<Podcaster>();
	Podcaster currentTalking;
	int currentIndex = -1;

	public Podcast(String podcastTitle){
		this.podcastTitle = podcastTitle;
	}

	public Podcast(String podcastTitle, String... people ){
		for (String person : people ) {
			castMembers.add(new Podcaster(person));
		}
	}

	public Podcast(String podcastTitle, List<String> people){
		for (String person : people) {
			castMembers.add(new Podcaster(person));
		}
	}

	public void startTimer(int index) throws IndexOutOfBoundsException {

		if (currentIndex != index ){
			currentTalking = castMembers.get(index);
			currentTalking.startTalkTimer();
			System.out.println("starting timer for " + currentTalking.getName());
			currentIndex = index;
		}
	}

	public void stopTimer(){
		
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

	public String getCastMemberName(int index){
		return castMembers.get(index).getName();
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
}