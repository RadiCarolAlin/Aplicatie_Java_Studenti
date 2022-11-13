import javax.swing.JLabel;

public class ComboStudentiComandant extends ComboStudenti  implements Command {
	
     JLabel student;
     
     public ComboStudentiComandant(JLabel s) {
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
