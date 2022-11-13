import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class StergeStudentButton  extends JButton implements Command{
	
	ComboStudenti numeText;
	
	public StergeStudentButton(ComboStudenti j) {
		super("StergereStudent");
		this.numeText=j;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		String numeStudent=numeText.getSelectedItem().toString().trim();
		Student s=new Student(numeStudent,null);
		Repository.getInstance().stergeStudent(s);

	}

}
