import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	private String nume;
	private ArrayList<Nota> listaNote = new ArrayList<Nota>();

	public Student(String linie) {

		int nr = linie.indexOf(":");
		String num = linie.substring(0, nr);
		this.nume = num;
		String note = linie.substring(nr + 1);

		Scanner sc = new Scanner(note);
		sc.useDelimiter(",");

		String nota;

		while (sc.hasNext()) {

			nota = sc.next();

			int nr1 = nota.indexOf("(");
			int nr2 = nota.indexOf(")");

			String notaS = nota.substring(0, nr1);
			notaS = notaS.trim();
			String creditS = nota.substring(nr1 + 1, nr2);
			creditS = creditS.trim();

			int nota1 = Integer.parseInt(notaS);
			int credit = Integer.parseInt(creditS);

			Nota n1 = new Nota(nota1, credit);
			listaNote.add(n1);

		}

	}
	
	public Student(String nume,Nota n) {
		this.nume=nume;
		this.listaNote.add(n);
	}
	public Student(String nu,ArrayList<Nota> nt)
	{
		this.nume=nu;
		this.listaNote=nt;
		
	}
	public ArrayList<Nota> getListaNote() {
		return listaNote;
	}
 
	public void setListaNote(ArrayList<Nota> listaNote) {
		this.listaNote = listaNote;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public boolean equals(Object obj) {
	 if (obj==null)
			 return false;
		if (obj instanceof Student) {
			
			Student s =(Student)obj;
			boolean t1 =this.nume.equalsIgnoreCase(s.nume);
			return t1;
		}else return false;
		
	}

	public String toString() {
		return   nume + ":" + listaNote.toString().substring(1, listaNote.toString().length() - 1);
	}

	public void adaugaNota(Nota n) {

		listaNote.add(n);

	}

	public void stergeNote(Nota n) {

		listaNote.remove(n);
	}
	
	public Object clone() {
		
		return new Student(this.nume,this.listaNote);
		
	}

	

}
