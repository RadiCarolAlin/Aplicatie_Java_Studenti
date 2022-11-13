import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdaugareStudentFrame extends JFrame implements ActionListener {
	JPanel mainPanel;
	JPanel bottomPanel;
	JPanel middlePanel;
	JPanel topPanel;
	   	
    JLabel numeLabel;
    JTextField numeText;
    
    JLabel notaLabel;
    JComboBox notaCombo;
    JComboBox numarCredite;
    JLabel numarCrediteLabel;
    AdaugaStudentButton adaugaStudent;

    
    public AdaugareStudentFrame() {
    	
    	this.mainPanel= new JPanel();
    	BoxLayout layout= new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
    	this.mainPanel.setLayout(layout);
    	this.bottomPanel=new JPanel();
    	this.middlePanel=new JPanel();
    	this.topPanel=new JPanel();
    	
    	this.numeLabel=new JLabel("Introduceti nume");
    	this.topPanel.add(numeLabel);
    	this.numeText=new JTextField(15);
    	this.topPanel.add(numeText);
    	
    	this.notaLabel=new JLabel("Introduceti Nota");
    	this.middlePanel.add(notaLabel);
    	String [] v= {"1","2","3","4","5","6","7","8","9","10"};
    	this.notaCombo=new JComboBox<String>(v);
    	this.middlePanel.add(notaCombo);
    	String [] c= {"2","3","4","5","6"};
    	this.numarCredite= new JComboBox<String>(c);
    	this.middlePanel.add(numarCredite);
    	this.numarCrediteLabel=new JLabel("(nr credite)");
    	this.middlePanel.add(numarCrediteLabel);
    	
    	this.adaugaStudent= new AdaugaStudentButton(this.numeText,this.notaCombo,this.numarCredite);
    	this.adaugaStudent.addActionListener(this);
    	this.bottomPanel.add(adaugaStudent);
    	
    	this.mainPanel.add(topPanel);
    	this.mainPanel.add(middlePanel);
    	this.mainPanel.add(bottomPanel);
    	
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
