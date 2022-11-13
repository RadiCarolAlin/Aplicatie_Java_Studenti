import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Servicii {
 
	public final static Function<Student,Double> calculMedie=(Student ss)->{
		double s=0;
		for(Nota n:ss.getListaNote())
			s=s+n.getNota();
		double m=s/ss.getListaNote().size();
		return m;
		
	};
	
	public final static Function<Student,Double> calculMediePonderata=(Student ss)->{
		double s=0;
		for(Nota n:ss.getListaNote())
			s=s+(n.getNota()*n.getNrCredite());
		double m=s/30;
		return m;
		
	};
	
	public final static Predicate<Nota> getCredite=(n)->{
		
		return n.getNota()>=5?true:false;
	};
	
	Function<Nota,Integer> getCredite2=(n)->n.getNota()>=5?n. getNrCredite():0;
	
	Function <ArrayList<Nota>,Integer> totalCredite=l->{
		
		return l.stream().mapToInt(n->n.getNota()>=5?n.getNrCredite():0).sum();
	};
	
	
	public final static Predicate<Student> getStatus=(s)->s.getListaNote().stream().mapToInt(n->n.getNota()>=5?n.getNrCredite():0).sum()>=20;
	
	public final static Consumer<ArrayList<Student>> afisareListaStudenti=l->{
		
		l.stream().filter(getStatus).forEach(System.out::println);
	};
	
	public final static Predicate<Student> getSex=s->s.getNume().trim().charAt(s.getNume().trim().length()-1)=='a';
	
	public final static Consumer<ArrayList<Student>> afisareFete=(l)->{
		l.stream().filter(getSex).forEach(System.out::println);
	};
	
	public final static BiFunction<String,ArrayList<Student>,Optional<Student>>searchStudent=(nume,lista)->{
		
	   Student obj=null;
	   for (Student s:lista)
		   if(s.getNume().trim().equalsIgnoreCase(nume.trim())) {
			   
			   obj=(Student) s.clone();
			   Optional<Student> cutieDeReturnat=Optional.of(obj);
			   return cutieDeReturnat;
		   }
	   return Optional.empty();
	};
	public final static Function<Student,Integer> calculCeaMaimareNota=(Student s)->{
		int m=0;
		for(Nota n:s.getListaNote()) {
			
			if (m<n.getNota()) {
				m=n.getNota();
			}
		}
		return m;
	};
		
	
	}
