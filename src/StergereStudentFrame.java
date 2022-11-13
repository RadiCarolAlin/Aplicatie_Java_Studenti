import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StergereStudentFrame extends JFrame implements ActionListener {
	JPanel mainPanel;
	JPanel botPanel;
	
	JLabel numeLabel;
	JLabel comboStudentiLabel;
	ComboStudentiComandant ComboStudenti;
	
	 StergeStudentButton stergeStudent;
	 
	 public StergereStudentFrame() {
		 this.mainPanel= new JPanel();
		 BoxLayout layout= new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
		 this.mainPanel.setLayout(layout);
		 
		 this.comboStudentiLabel=new JLabel();
	    	this.mainPanel.add(comboStudentiLabel);
	    	
		    this.numeLabel=new JLabel("Introduceti nume");
	    	this.mainPanel.add(numeLabel);
	    	this.ComboStudenti=new ComboStudentiComandant(comboStudentiLabel);
	    	this.mainPanel.add(ComboStudenti);
	    	
	    	this.ComboStudenti.addActionListener(this);
	    	
	    	
	    	this.stergeStudent= new StergeStudentButton(this.ComboStudenti);
	    	this.stergeStudent.addActionListener(this);
	    	this.mainPanel.add(stergeStudent);
		    this.botPanel=new JPanel();
		    this.botPanel.add(mainPanel);
	    	this.add(botPanel);
	    	this.pack();
	    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	this.setVisible(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		((Command)e.getSource()).execute();
		
	}
	 

}
