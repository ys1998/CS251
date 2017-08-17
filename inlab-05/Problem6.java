import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

class Form{
	private JFrame frame;
	private JButton loginButton;
	private JButton resetButton;
	private JTextField username;
	private JPasswordField password;
	private JLabel output;
	private JLabel text1;
	private JLabel text2;
	private JPanel row1;
	private JPanel row2;

	class ButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			String command=e.getActionCommand();
			if(command=="login"){
				if((!username.getText().equals(""))&&(!(new String(password.getPassword()).equals("")))) {
					output.setText("Both fields are non-empty.");
				}else{
					output.setText("One or both of the fields are empty.");				
				}
			}else if(command=="reset"){
				username.setText("");
				password.setText("");
				output.setText("Fields reset.");
			}
		}
	}
	public Form(){
		frame=new JFrame("Problem 6");
		loginButton=new JButton("Login");
		resetButton=new JButton("Reset");
		username=new JTextField(20);
		password=new JPasswordField(20);
		output=new JLabel("Enter username and password");
		text2=new JLabel("Password");
		text1=new JLabel("Username");
		row1=new JPanel();
		row2=new JPanel();
		row1.add(text1); row1.add(username);
		row2.add(text2); row2.add(password);
		frame.setSize(600,300);
		frame.setLayout(new GridLayout(8,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(row1);
		frame.add(row2);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(output);

		loginButton.setActionCommand("login");
		resetButton.setActionCommand("reset");
		loginButton.addActionListener(new ButtonClick());
		resetButton.addActionListener(new ButtonClick());

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
public class Problem6{
	public static void main(String[] args){
		new Form();
	}
}