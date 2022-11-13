import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository {

	private ArrayList<Student> studenti = new ArrayList<Student>();
	private ArrayList<Observer> observatori=new ArrayList<Observer>();

	private static Repository obiectCreeat = null;

	private Repository() {

		try {

			File f1 = new File("studenti.txt");
			Scanner sc = new Scanner(f1);

			while (sc.hasNextLine()) {

				String linie = sc.nextLine();

				Student s1 = new Student(linie);
				studenti.add(s1);

			}

		} catch (Exception e) {

		}
		notifyAllObserver();

	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public static Repository getInstance() {
		if (obiectCreeat == null) {
			obiectCreeat = new Repository();
			return obiectCreeat;
		} else
			return obiectCreeat;

	}

	public String toString() {
		return "Repository [studenti=" + studenti + "]";
	}

	public void adaugaStudent(Student s) { // singleton

		studenti.add(s);

		try {

			FileWriter filewriter = new FileWriter("studenti.txt", true);
			PrintWriter printwriter = new PrintWriter(filewriter);

			printwriter.println(s.toString());

			printwriter.close();
		} catch (Exception e) {

		}
		notifyAllObserver();

	}

	public void stergeStudent(Student s) {
        
			
		studenti.remove(s);
		

		try {

			File filewriter = new File("studenti.txt");

			PrintWriter printwriter = new PrintWriter(filewriter);

			for (int i = 0; i < studenti.size(); i++) {
				printwriter.println(studenti.get(i).toString());

			}

			printwriter.close();

		} catch (Exception e) {
		}
		notifyAllObserver();

	}

	public void modificaNume(String nv, String nn) {

		for (int i = 0; i < studenti.size(); i++) {

			if (studenti.get(i).getNume().equals(nv)) {

				studenti.get(i).setNume(nn);
				try {

					File filewriter = new File("studenti.txt");
					PrintWriter printwriter = new PrintWriter(filewriter);
					for (int a = 0; a < studenti.size(); a++) {

						printwriter.println(studenti.get(a).toString());
					}

					printwriter.close();

				} catch (Exception e) {
				}

			}

		}
		notifyAllObserver();

	}

	public void adaugaNota(Student s, Nota nt) {

		for (int i = 0; i < studenti.size(); i++) {

			if (studenti.get(i).equals(s)) {
				
                Main.logger.info("Adaug nota la student");
				studenti.get(i).adaugaNota(nt);
				break;

			}

		}

		try {

			File filewriter = new File("studenti.txt");
			PrintWriter printwriter = new PrintWriter(filewriter);
			for (int a = 0; a < studenti.size(); a++) {

				printwriter.println(studenti.get(a).toString());
			}

			printwriter.close();

		} catch (Exception e) {
		}
		notifyAllObserver();

	}

	public void stergeNota(Student s, Nota nt) {

		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).equals(s)) {
				studenti.get(i).stergeNote(nt);
			}

		}
		try {

			File filewriter = new File("studenti.txt");
			PrintWriter printwriter = new PrintWriter(filewriter);
			for (int a = 0; a < studenti.size(); a++) {

				printwriter.println(studenti.get(a).toString());
			}

			printwriter.close();

		} catch (Exception e) {
		}
		notifyAllObserver();

	}
	
	public void addObserver(Observer o) {
		
	 observatori.add(o);
		
	}
    public void removeObserver(Observer o) {
		
		observatori.remove(o);
	}
    public void notifyAllObserver() {
    	
    	for(Observer o : observatori)
    		o.update();
    }

}
