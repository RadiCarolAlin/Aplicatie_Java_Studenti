import javax.swing.JButton;
import javax.swing.JComboBox;

public class ButonAdaugareNota extends JButton implements Command {

	ComboStudenti studenti;
	JComboBox<String> nota;
	JComboBox<String> credite;
	
	public ButonAdaugareNota(ComboStudenti s,JComboBox<String> n,JComboBox<String> c) {
		super("AdaugaNota");
		this.studenti=s;
		this.nota=n;
		this.credite=c;	
	}
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
        String s=studenti.getSelectedItem().toString().trim();
        int n=Integer.parseInt(nota.getSelectedItem().toString());
        int c=Integer.parseInt(credite.getSelectedItem().toString());
   

		Nota nota=new Nota(n,c);
		Student t=new Student(s,nota);
		Repository.getInstance().adaugaNota(t,nota); 

	}

}
