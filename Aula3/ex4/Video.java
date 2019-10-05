package Aula3.ex4;

public class Video {
	static int currentID = 0;
	private int id,ratingTotal,ratingAverage,numClients;
	private String title,age,category;
	private boolean available;
	
	public Video(String title, String age, String category) {
		if(!validCategory(category)||!validAge(age)) throw new IllegalArgumentException();
		this.title = title;
		this.age = age;
		this.category = category;
		this.id=currentID++;
		this.available=true;
		this.numClients=0;
		this.ratingAverage=0;
		this.ratingTotal=0;
	}

	public int getId() {
		return id;
	}
	public int getRating() {
		return ratingAverage;
	}
	public String getTitle() {
		return title;
	}
	public String getAge() {
		return age;
	}
	public String getCategory() {
		return category;
	}
	public boolean isAvailable() {
		return available;
	}
	
	public void lendVideo() {
		available = false;
		numClients++;
	}
	
	public void returnVideo(int r) {
		available=true;
		addRating(r);
	}
	
	private void addRating(int r) {
		ratingTotal+=r;
		ratingAverage = Math.min(Math.max((int)Math.round((double)ratingTotal/(double)numClients),0), 10);
	}
	
	public String toString() { return title + "|" + ratingAverage + "|" + id + "|" + String.format("%1$"+8+"s", category) + "|" + age; }
	
	private static boolean validCategory(String cat) {
		return cat.equals("Action") || cat.equals("Comedy") || cat.equals("Children") || cat.equals("Drama");
	}
	
	private static boolean validAge(String ageRating) {
		return ageRating.equals("ALL") || ageRating.equals("M6") || ageRating.equals("M12") || ageRating.equals("M16") || ageRating.equals("M18");
	}
	
}
