import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class VizualizareStudentiFrame extends JFrame implements ActionListener{
	
	JPanel midPanel;
	JPanel topPanel;
	JPanel botPanel;
	
	
	JLabel text;
	StudentTable tabel;
	
	public VizualizareStudentiFrame() {
		
		 this.midPanel=new JPanel();
		 BoxLayout layout= new BoxLayout(midPanel,BoxLayout.Y_AXIS);
		 this.midPanel.setLayout(layout);
		 
		 this.topPanel=new JPanel();
		 this.botPanel=new JPanel();
		 
		 this.text=new JLabel("Vizualizare Studenti");
	     this.topPanel.add(text);
	     
	     
	    // Object[][] data = new Object[][] {
	     //       {1, "John", 40.0, false },
	     //       {2, "Rambo", 70.0, false },
	      //      {3, "Zorro", 60.0, true },
	      //  };  
	     
	   //  String[] columnName={ "Id", "Name", "Hourly Rate", "Part Time"};  
         
	       
         this.tabel=new StudentTable();  
	    // tabel.setBounds(30,40,200,300);          
	    // JScrollPane sp=new JScrollPane(tabel);      
	     this.botPanel.add(new JScrollPane(tabel));          
	     //this.setSize(300,400);    
	     
	      
	     
		 
		 this.midPanel.add(topPanel);
		 this.midPanel.add(botPanel);
		
		 
		 
		 this.add(midPanel);
	     this.pack();
	     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	     this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
