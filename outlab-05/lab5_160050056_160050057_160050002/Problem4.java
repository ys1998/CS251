//https://stackoverflow.com/questions/37424284/unreported-exception-java-lang-exception-must-be-caught-or-declared-to-be-throw
import javax.swing.*;
import java.io.File;
import java.awt.event.*;
import java.awt.GridLayout;

class Form{
	private JFrame frame;
	private JButton openButton;
	private JButton goButton;
	private JButton resetButton;
	private JTextField file;
	private JTextField stopword;
	private JLabel output;
	private JLabel text1;
	private JPanel row1;
	String defStopWord="and,the,or,is,in,at,of,her,him,his";
	final JFileChooser fc = new JFileChooser();
	File filepath;
	String arg;
	class ButtonClick implements ActionListener{
		//haven't assigned the return value from parse to any return variable yet.
		public void main() {
			try {   arg=filepath.getCanonicalPath();        			
				if(arg.endsWith("doc") || arg.endsWith("docx")){	parse.extract(doc.main(arg) , stopword.getText());}
				else if( arg.endsWith("xlsx") || arg.endsWith("xls") ){	parse.extract(workbook.main(arg), stopword.getText());}
				else if(arg.endsWith("pdf") ){		parse.extract(pdf.main(arg), stopword.getText());}
			}catch (Exception e) {e.printStackTrace();}
		}
		@Override
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == openButton) {
			        int returnVal = fc.showOpenDialog(frame);

		        	if (returnVal == JFileChooser.APPROVE_OPTION) {
       			     		filepath = fc.getSelectedFile();
				}
        		}
			String command=e.getActionCommand();
			if(command=="Go"){
				output.setText("Opening and parsing file...");
				main();
	
			}
			else if(command=="reset"){
				file.setText("");
				stopword.setText("and,the,or,is,in,at,of,her,him,his");				
				//filepath  = /home;
				output.setText("Fields reset.");
			}
		}
	}
	public Form(){
		frame=new JFrame("Problem 4");
		openButton=new JButton("open");		
		goButton=new JButton("Go");
		resetButton=new JButton("Reset");
		file=new JTextField(20);
		stopword=new JTextField(20);
		output=new JLabel("Please select file and enter stopwords");
		text1=new JLabel("Stopwords");
		row1=new JPanel();
		row1.add(text1); row1.add(stopword);
		stopword.setText("and,the,or,is,in,at,of,her,him,his");
		frame.setSize(600,300);
		frame.setLayout(new GridLayout(8,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(row1);
		frame.add(openButton);
		frame.add(goButton);
		frame.add(resetButton);
		frame.add(output);

		resetButton.setActionCommand("reset");
		openButton.addActionListener(new ButtonClick());
		goButton.addActionListener(new ButtonClick());
		resetButton.addActionListener(new ButtonClick());

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
public class Problem4{
	public static void main(String[] args){
		new Form();
	}
}
