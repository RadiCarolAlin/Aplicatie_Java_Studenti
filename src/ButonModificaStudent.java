import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ButonModificaStudent extends JButton implements Command {
	
	
	ComboStudenti studenti;
	JTextField studentNou;
	
	public ButonModificaStudent(ComboStudenti s,JTextField sn){
		
		super("Modifica");
		this.studenti=s;
		this.studentNou=sn;
		
	}
	
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String s=studenti.getSelectedItem().toString().trim();
		String sn=studentNou.getText().trim();
		
		Repository.getInstance().modificaNume(s,sn);
	}

}
