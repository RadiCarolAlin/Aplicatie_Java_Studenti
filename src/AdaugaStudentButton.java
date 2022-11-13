import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AdaugaStudentButton extends JButton implements Command {

	JTextField numeText;
	JComboBox<String> notaCombo;
	JComboBox<String> creditCombo;
	
	public AdaugaStudentButton(JTextField j,JComboBox<String> nc,JComboBox<String> cc) {
		super("AdaugareStudent");
		this.numeText=j;
		this.notaCombo=nc;
		this.creditCombo=cc;
		
	}
	@Override
	public void execute() {
		
		String numeStudent=numeText.getText().trim();
		int n=Integer.parseInt(notaCombo.getSelectedItem().toString());
		int c=Integer.parseInt(creditCombo.getSelectedItem().toString());
		
		Nota nota=new Nota(n,c);
		Student s=new Student(numeStudent,nota);
		Repository.getInstance().adaugaStudent(s); 

	}

}
