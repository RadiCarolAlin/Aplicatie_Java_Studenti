import java.util.logging.Logger;

public class Main {
public static Logger logger=Logger.getAnonymousLogger();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.logger.info("Start");
		
		AdaugareStudentFrame asf=new AdaugareStudentFrame();
		StergereStudentFrame ast=new StergereStudentFrame();
		AdaugaNotaFrame asy=new AdaugaNotaFrame();
		VizualizareStudentiFrame t=new VizualizareStudentiFrame();
		ModificaAlegeStudentFrame s=new ModificaAlegeStudentFrame();
		
		Nota n1=new Nota(10,3);
		Student s1=new Student("Popescu Andreea",n1);
		double m=Servicii.calculMedie.apply(s1);
		System.out.println(m);
		Nota n2=new Nota(10,2);
		Nota n3=new Nota(10,1);
		Nota n4=new Nota(6,4);
		Nota n5=new Nota(7,5);
		Nota n6=new Nota(5,5);
		Nota n7=new Nota(10,4);
		Nota n8=new Nota(10,2);
		Nota n9=new Nota(5,4);
		
		
		
		
		
		double r=Servicii.calculMediePonderata.apply(s1);
		System.out.println(r);
		Servicii.afisareListaStudenti.accept(Repository.getInstance().getStudenti());
		

	}

}
