import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ComboStudenti extends JComboBox implements Observer {
    
	private static ArrayList<Student> listaStudenti;
	private static Vector<String> v=new Vector<String>();
	
	static {
		listaStudenti=Repository.getInstance().getStudenti();
		for(Student s:listaStudenti)
		{
		  v.add(s.getNume());	
			
			
		}
	}
	public ComboStudenti() {
		
		super(v);
		
		
		Repository.getInstance().addObserver(this);
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.removeAllItems();
		ArrayList<Student> lista=Repository.getInstance().getStudenti();
		for(Student s:lista)
			this.addItem(s.getNume());

	}
/*	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (this.getSelectedItem()!=null) {
		String Studentselectat=this.getSelectedItem().toString().trim();
		
		studenti.setText(Studentselectat);
		}
		
		
	}
*/
}
