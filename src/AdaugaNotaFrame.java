import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdaugaNotaFrame extends JFrame implements ActionListener {
	JPanel mainPanel;
	JPanel botPanel;
	JPanel topPanel;
	
	JComboBox notacombo;
	JComboBox credite;
	JLabel comboStudentiLabel;
	ComboStudenti studenti;
	
	ButonAdaugareNota AdaugareNota;
	
	public AdaugaNotaFrame() {
		
		
		this.mainPanel= new JPanel();
		
		BoxLayout layout= new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
    	this.mainPanel.setLayout(layout);
    	
    	this.botPanel=new JPanel();
    	this.topPanel=new JPanel();
    	
    	this.studenti=new ComboStudenti();
    	this.topPanel.add(studenti);
    	
    	
    	String [] v= {"1","2","3","4","5","6","7","8","9","10"};
    	this.notacombo=new JComboBox<String>(v);
    	this.topPanel.add(notacombo);
    	
    	String [] c= {"2","3","4","5","6"};
    	this.credite= new JComboBox<String>(c);
    	this.topPanel.add(credite);
    	
    	this.AdaugareNota= new ButonAdaugareNota(this.studenti,this.notacombo,this.credite);
    	this.AdaugareNota.addActionListener(this);
    	this.botPanel.add(AdaugareNota);
    	
    	this.mainPanel.add(topPanel);
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
