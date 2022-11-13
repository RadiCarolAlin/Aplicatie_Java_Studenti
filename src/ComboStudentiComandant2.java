import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComboStudentiComandant2 extends ComboStudenti  implements Command{
	

    JTextField student;
    
    public ComboStudentiComandant2(JTextField s) {
    super();
    this.student=s; 
    Repository.getInstance().addObserver(this);
    }
    
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (this.getSelectedItem()!=null) {
			String Studentselectat=this.getSelectedItem().toString().trim();
			
			student.setText(Studentselectat);
 
   }
}
}
