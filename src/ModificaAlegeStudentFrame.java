import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificaAlegeStudentFrame extends JFrame implements ActionListener{
	JPanel mainPanel;
	JPanel botPanel;
	JPanel middlePanel;
	JPanel topPanel;
	
	ComboStudentiComandant2 alegeStudent;
	JTextField numeVechi;
	JTextField numeNou;
	
	JLabel alegeStudentLabel;
	JLabel numeVechiLabel;
	JLabel numeNouLabel;
	
	
	ButonModificaStudent modifica;
	
	public ModificaAlegeStudentFrame(){
		this.mainPanel= new JPanel();
    	BoxLayout layout= new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
    	this.mainPanel.setLayout(layout);
    	this.botPanel=new JPanel();
    	this.middlePanel=new JPanel();
    	this.topPanel=new JPanel();
    	
    	this.alegeStudentLabel=new JLabel("Alege student");
    	this.topPanel.add(alegeStudentLabel);
    	
    	this.numeVechi=new JTextField(15);
    	numeVechi.setEditable(false);
    	this.middlePanel.add(numeVechi);
    	
    	this.alegeStudent=new ComboStudentiComandant2(numeVechi);
    	this.topPanel.add(alegeStudent);
    	

    	this.alegeStudent.addActionListener(this);
    	
    	this.numeVechiLabel=new JLabel("Nume Vechi");
    	this.middlePanel.add(numeVechiLabel);
    	
    	
    	
    	this.numeNouLabel=new JLabel("Nume Vechi");
    	this.botPanel.add(numeNouLabel);
    	
    	this.numeNou=new JTextField(15);
    	this.botPanel.add(numeNou);
    	
    	this.modifica= new ButonModificaStudent(this.alegeStudent,this.numeNou);
    	this.modifica.addActionListener(this);
    	this.botPanel.add(modifica);
    	
    	this.mainPanel.add(topPanel);
    	this.mainPanel.add(middlePanel);
    	this.mainPanel.add(botPanel);
    	
    	this.add(mainPanel);
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
