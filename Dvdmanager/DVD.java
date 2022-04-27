package Dvdmanager;



public class DVD implements Comparable<DVD> {

	

	private String title;		// Title of this DVD
	private String rating;		// Rating of this DVD
	private int runningTime;	// Running time of this DVD in minutes
	private int stars;
	private int logo;

	public DVD(String dvdTitle, String dvdRating, int dvdRunningTime,int dvdstars,int dvdlogo) 
	{
		this.title = dvdTitle;
		this.rating = dvdRating;
		this.runningTime = dvdRunningTime;
		this.stars =dvdstars;
		this.logo = dvdlogo;;
	}
	
	public DVD(String title2) {
		this.title=title2;
	}
	

	public String getTitle() 
	{
		return title;


		
	}
	
	public String getRating() 
	{
		return rating;


		
	}
	
	public int getRunningTime() 
	{

		return runningTime;

		
	}

	public void setTitle(String newTitle) {

		this.title = newTitle;



	}

	public void setRating(String newRating) {


		this.rating = newRating;


	}

	public void setRunningTime(int newRunningTime) {

		this.runningTime = newRunningTime;



	}
	
    public int compareTo(DVD o) {
    	
      return this.title.compareTo(o.getTitle());
    	
    
   }


	public String toString() {
		
		
		return "DVD title=" + title + ", rating=" + rating + ", runningTime=" + runningTime+ " "+stars +" stars";
		
	}
	public boolean equals(Object obj) {
		if (!(obj instanceof DVD))
			return false;	
		if (obj == this)
			return true;
		return this.title.equals(((DVD) obj).title);
	}
 
	public int hashCode(){
		return title.length();
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getLogo() {
		return logo;
	}

	public void setLogo(int logo) {
		this.logo = logo;
	}


	
	
}
