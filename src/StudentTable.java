import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

public class StudentTable extends JTable implements Observer {
	
	private static String[] columns;
	private static Object[][] data;
	
	
	static {
		
		int i=0;

		int max=0;
		 ArrayList<Student> listaStudenti=Repository.getInstance().getStudenti();
		
        for(Student s:listaStudenti) {	 
			 if (s.getListaNote().size()>max) {
				 max=s.getListaNote().size();
			 }
        }
         Main.logger.info("Nr maxim coloane "+max);
        data=new Object[listaStudenti.size()+1][2*max+1];
        
        for(int q=0;q<listaStudenti.size()+1;q++)
        	for(int t1=0;t1<2*max+1;t1++) {
        		
        		data[q][t1]=" ";
        	}
        
        columns=new String[max+1];
        columns[0]="Nume";
        int k;
        for(k=1;k<max+1;k++)
        {
        	if(k%2!=0)
        		columns[k]="Nota";
        	else
        		columns[k]="Credit";
        	
        }
		 for(Student s:listaStudenti) {
			 
			 data[i][0]=s.getNume();
			 for(int j=0;j < s.getListaNote().size();j++) {
				 data[i][j+1]=s.getListaNote().get(j).getNota();
				 data[i][j+2]=s.getListaNote().get(j).getNrCredite();	 
			 }
			 i++;
			 
		 }
		 
		}
	public StudentTable() {
		super(data,columns);
		
		Repository.getInstance().addObserver(this);
		
		
		
		
		
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
	/*	this.removeAll();
		 Object[][] data;
		ArrayList<Student> listaStudenti=Repository.getInstance().getStudenti();
		int i=0;
		for(Student s:listaStudenti) {
			 
			 data[i][0]=s.getNume();
			 for(int j=0;j < s.getListaNote().size();j++) {
				 data[i][2*j+1]=s.getListaNote().get(j).getNota();
				 data[i][2*j+2]=s.getListaNote().get(j).getNrCredite();	 
			 }
			 i++;
			 
		 }
		*/

	}

}
