package assignment5;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *  This class is an implementation of DVDUserInterface
 *  that uses JOptionPane to display the menu of command choices. 
 */

public class DVDGUI extends JFrame implements DVDUserInterface {
	 
	 private DVDCollection dvdlist;
	 
	 public DVDGUI(DVDCollection dl)
	 {
		 dvdlist = dl;
	 }
	 
	 public void processCommands()
	 {
	
		 String[] commands = {"Add DVD","Modify DVD",
				 	"Remove DVD",
				 	"View DVD Info",
				 	"Get Total Running Time",
				 	"Exit and Save"};
		 
		 int choice;
		// this.setSize(400,400);
		 this.setVisible(true);
		 do {
			
			 choice = JOptionPane.showOptionDialog(null,
					 "Select a command", 
					 "DVD Collection", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 commands,
					 commands[commands.length - 1]);
			
			 switch (choice) {
			 	case 0: doAddDVD(); break;
			 	case 1: doAddOrModifyDVD(); break;
			 	case 2: doRemoveDVD(); break;
			 	case 3: doGetDVDInfo(); break;
			 	case 4: doGetTotalRunningTime(); break;
			 	case 5:  doSave(); break;
			 	default:  // do nothing
			 }
			 
		 } while (choice != commands.length-1);
		 System.exit(0);
	 }
	 
		private void doAddDVD() {
		
	   		int number = 0;
	   		String stars;
	   		String logo;
			// Request the title
			String title = JOptionPane.showInputDialog("Enter title");
			if (title == null) {
				return;		// dialog was cancelled
			}
			title = title.toUpperCase();
			
			// Request the rating
			String rating = JOptionPane.showInputDialog("Enter rating for " + title);
			if (rating == null) {
				return;		// dialog was cancelled
			}
			rating = rating.toUpperCase();
			
			// Request the running time
			String time = JOptionPane.showInputDialog("Enter running time for " + title);
			if (time == null) {
				return;	
			}
			do {
			stars = JOptionPane.showInputDialog("Enter Star rating time for must be 0-5 " + title);
			if (stars == null) {
				return;	
			}
			number = Integer.parseInt(stars);
			}while(number<0 || number>5);
			
			do {
			logo = JOptionPane.showInputDialog("Enter a number for a DVD logo 0-3 " + title);
			if (logo == null) {
				return;	
			}
			number = Integer.parseInt(logo);
			}while(number<0 || number >3);
			
			
			
			
	                // Add or modify the DVD (assuming the rating and time are valid
	                dvdlist.addOrModifyDVD(title, rating, time,stars,logo);
	                
	                // Display current collection to the console for debugging
	                JOptionPane.showMessageDialog(null,"Adding/Modifying: " + title + "," +"Rating = "+ rating + "," + "Runningtime ="+time + ", " + stars+" stars");
	              	
		}
		
	private void doAddOrModifyDVD() {
		int choice;
		
		String[] str = dvdlist.getTitles();
		 choice = JOptionPane.showOptionDialog(null,
					 "Select a command", 
					 "DVD Collection", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 str,
					 str[str.length - 1]);
		
   		 JOptionPane.showMessageDialog(null,dvdlist.Dlist.get(choice),"Selected Movie",dvdlist.Dlist.get(choice).getLogo());
   		String titles = dvdlist.Dlist.get(choice).getTitle();

   		int number= 0;
		String stars;
		String logo;
		// Request the rating
		String rating = JOptionPane.showInputDialog("Enter rating for " + titles);
		if (rating == null) {
			return;		// dialog was cancelled
		}
		rating = rating.toUpperCase();
		
		// Request the running time
		String time = JOptionPane.showInputDialog("Enter running time for " + titles);
		if (time == null) {
			return;	
		}
		do {
		stars = JOptionPane.showInputDialog("Enter Star rating time for must be 0-5 "+titles);
		if (stars == null) {	
			return;
		}
		 number = Integer.parseInt(stars);
		}while(number<0 || number>5);
		
		do {
		logo = JOptionPane.showInputDialog("Enter a number for a DVD logo 0-3 "+ titles);
		if (logo == null) {
			return;
		}
		number = Integer.parseInt(logo);
		}while(number<0 || number >3);
	      // Add or modify the DVD (assuming the rating and time are valid
                dvdlist.addOrModifyDVD(titles, rating, time,stars,logo);
                
                // Display current collection to the console for debugging
                JOptionPane.showMessageDialog(null,"Adding/Modifying: " + titles + "," +"Rating = "+ rating + "," + "Runningtime ="+time + ", " + stars+" stars");
         
            	
       	
		
	}
	
	private void doRemoveDVD() {

		int choice;
		
		String[] str = dvdlist.getTitles();
		if(str==null) {
			 JOptionPane.showMessageDialog(null,"No Movies to remove");
			 return;
		}
		else
		 choice = JOptionPane.showOptionDialog(null,
					 "Select a movie", 
					 "DVD Collection", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 str,
					 str[str.length - 1]);
		 
   		 JOptionPane.showMessageDialog(null,dvdlist.Dlist.get(choice),"Removed",1);
   		String titles = dvdlist.Dlist.get(choice).getTitle();
   		if (titles == null) {
			return;		// dialog was cancelled
		}
		
                // Remove the matching DVD if found
                dvdlist.removeDVD(titles);
                
                // Display current collection to the console for debugging
              
                //System.out.println("Removing: " + title);
              

	}
	
	private void doGetDVDInfo() {

		int choice;
		
		String[] str = dvdlist.getTitles();
		if(dvdlist.getTitles()==null) {
			 JOptionPane.showMessageDialog(null,"No Movies to show");
			 return;
		}
		else
		 choice = JOptionPane.showOptionDialog(null,
					 "Select a movie", 
					 "DVD Collection", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 str,
					 str[str.length - 1]);
		 
   		 JOptionPane.showMessageDialog(null,dvdlist.Dlist.get(choice),"DVD Info",dvdlist.Dlist.get(choice).getLogo());
	}

        private void doGetTotalRunningTime() {
                
                int total = dvdlist.getTotalRunningTime();
                JOptionPane.showMessageDialog(null,total,"Total Running Time of DVDs: ",1);
               
	 
        }

	private void doSave() {
		
		dvdlist.save();
		
	}
		
}
