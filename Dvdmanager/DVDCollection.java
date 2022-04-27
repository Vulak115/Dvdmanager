package Dvdmanager;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class DVDCollection {

	
	private int numdvds;
	private String sourceName;
	private boolean modified;
	
	   
	public DVDCollection() {
		numdvds = 0;
		

	
	}
	
	LinkedList<DVD> Dlist = new LinkedList<DVD>();
	
	
	public String toString() {
		return "numdvds " + numdvds + "\nlength of linkedlist: "+Dlist.size()+" "+"\n"+ Dlist.toString()+"\n";
		
	}
	
	
	
	public void addOrModifyDVD(String title, String rating, String runningTime,String stars,String logos) {
		int running = 0;
		int star = 0;
		int logo =0;
		try {
		running = Integer.parseInt(runningTime);
		star = Integer.parseInt(stars);
		logo = Integer.parseInt(logos);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Needs to be an integer");
			removeDVD(title);
		}
			
		if (Dlist.remove(new DVD(title))) {
			Dlist.add(new DVD(title,rating,running,star,logo));
			modified = true;
		}
		else {
			Dlist.add(new DVD(title,rating,running,star,logo));
			numdvds++;
			modified = true;
		}
		Collections.sort(Dlist);
		
	
	}

	public void removeDVD(String title) {
		if(Dlist.remove(new DVD(title)))
			numdvds--;
		modified = true;
	}
	
	public String getDVDsByRating(String rating) {
		DVD hold = null;
		String str = "";
		ListIterator<DVD> litr = null;
		litr=Dlist.listIterator(0);
		
		  while(litr.hasNext()){
			  hold = litr.next();
			 
			 if (rating.equalsIgnoreCase(hold.getRating())) {
				 str +=hold.getTitle()+"\n";
			 }
			
		  }
	return str;
	}
	

	public int getTotalRunningTime() {
		DVD hold = null;
		int count = 0;
		ListIterator<DVD> litr = null;
		litr=Dlist.listIterator(0);
		
		  while(litr.hasNext()){
			  hold = litr.next();
			  count +=hold.getRunningTime();
			
		  }
	return count;
	}

	
	public void loadData(String filename) {
		
		try {
			File myfile = new File(filename);
			Scanner scan = new Scanner(myfile);
		
			while(scan.hasNext()) {
				String[] parts = scan.nextLine().split(",");
				String title = parts[0];
				String rating = parts[1];
				String running = parts[2];
				String star = parts[3];
				String logo = parts[4];
				addOrModifyDVD(title,rating,running,star,logo);
			}
			scan.close();
		}catch(FileNotFoundException e) {
		
		}
		sourceName = filename;
	}
	
	public void save() {
		DVD hold = null;
		ListIterator<DVD> litr = null;
		litr=Dlist.listIterator(0);
		if (modified) {
		File myFile = new File(sourceName);
		
		try {
			PrintWriter output = new PrintWriter(myFile);
			  while(litr.hasNext()){
				  hold = litr.next();
			output.println(hold.getTitle()+","+hold.getRating()+","+hold.getRunningTime()+","+hold.getStars()+","+hold.getLogo());
			  }
			  output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		}
	
	}
	
	public String[] getTitles() {
		DVD hold = null;
		String count = "";
		String[] titles = {};
		ListIterator<DVD> litr = null;
		litr=Dlist.listIterator(0);
		
		  while(litr.hasNext()){
			  hold = litr.next();
			 count += hold.getTitle()+ ",";
			titles = count.split(",");
		  }
	
	return titles;
		
		
	}

	



	
}
