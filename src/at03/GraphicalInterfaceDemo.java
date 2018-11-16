package at03;

import java.awt.*;
import javax.swing.*;

public class GraphicalInterfaceDemo {
	
	private static void create_window() {
		
		JFrame frame = new JFrame("Simple GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel textLabel = new JLabel("Hello World!", SwingConstants.CENTER);
		textLabel.setPreferredSize(new Dimension(300, 100));
		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	
}
