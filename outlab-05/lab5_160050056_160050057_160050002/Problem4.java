//https://stackoverflow.com/questions/37424284/unreported-exception-java-lang-exception-must-be-caught-or-declared-to-be-throw

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.awt.event.*;
import java.awt.GridLayout;
import java.util.Map;

class Form {

    private JFrame frame;
    private JButton openButton;
    private JButton goButton;
    private JButton resetButton;
    private JTextField file;
    private JTextField stopword;
    private JLabel output;
    private JLabel text1;
    private JPanel row1;
    private JPanel row2;
    private JTable result;                          // TABLE
    private JScrollPane result_container;           // TABLE
    private Map<String, Integer> result_map;        // TABLE
    String defStopWord = "and,the,or,is,in,at,of,her,him,his";
    final JFileChooser fc = new JFileChooser();
    File filepath;
    String arg;

    class ButtonClick implements ActionListener {
        //haven't assigned the return value from parse to any return variable yet.

        public void main() {
            try {
                arg = filepath.getCanonicalPath();
                if (arg.endsWith("doc") || arg.endsWith("docx")) {
                    result_map = parse.extract(doc.main(arg), stopword.getText());
                } else if (arg.endsWith("xlsx") || arg.endsWith("xls")) {
                    result_map = parse.extract(workbook.main(arg), stopword.getText());
                } else if (arg.endsWith("pdf")) {
                    result_map = parse.extract(pdf.main(arg), stopword.getText());
                }
                frame.remove(result_container);               // TABLE
                DefaultTableModel temp = new DefaultTableModel();
                temp.addColumn("Word");
                temp.addColumn("Frequency");
                for (Map.Entry<String, Integer> entry : result_map.entrySet()) {
                    temp.addRow(new Object[]{entry.getKey(), entry.getValue()});
                }
                result = new JTable(temp);
                result_container=new JScrollPane(result,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);           // For scrollable TABLE
                frame.add(result_container,BorderLayout.CENTER);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == openButton) {
                int returnVal = fc.showOpenDialog(frame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    filepath = fc.getSelectedFile();
                    output.setText("File selected : "+filepath);
                }
            } else {
                String command = e.getActionCommand();
                if ("go".equals(command)) {
                    output.setText("Opening and parsing file...");
                    main();

                } else if ("reset".equals(command)) {
                    file.setText("");
                    stopword.setText("and,the,or,is,in,at,of,her,him,his");
                    //filepath  = /home;
                    output.setText("Fields reset.");
                    frame.remove(result_container);
                    result_container=new JScrollPane(new JTable());
                    frame.add(result_container,BorderLayout.CENTER);
                }
            }
        }
    }

    public Form() {
        frame = new JFrame("Problem 4");
        openButton = new JButton("Open");
        goButton = new JButton("Go");
        resetButton = new JButton("Reset");
        file = new JTextField(20);
        stopword = new JTextField(20);
        output = new JLabel("Please select file and enter stopwords");
        text1 = new JLabel("Stopwords");
        row1 = new JPanel();
        row2 = new JPanel(new GridLayout(4,0));
        
        result_container=new JScrollPane(new JTable());               // TABLE
        
        row1.add(text1);
        row1.add(stopword);
        stopword.setText("and,the,or,is,in,at,of,her,him,his");
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        goButton.setSize(50,20);
        openButton.setSize(50,20);
        resetButton.setSize(50,20);
        
        row2.add(openButton);
        row2.add(goButton);
        row2.add(resetButton);
        

        frame.add(row1,BorderLayout.NORTH);
        frame.add(row2,BorderLayout.EAST);
        
        frame.add(output,BorderLayout.SOUTH);
        frame.add(result_container,BorderLayout.CENTER);              // TABLE

        resetButton.setActionCommand("reset");
        goButton.setActionCommand("go");
        openButton.addActionListener(new ButtonClick());
        goButton.addActionListener(new ButtonClick());
        resetButton.addActionListener(new ButtonClick());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

public class Problem4 {

    public static void main(String[] args) {
        new Form();
    }
}
