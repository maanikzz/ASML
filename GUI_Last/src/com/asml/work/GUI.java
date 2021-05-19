package com.asml.work;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.JFrame;
import java.awt.Toolkit;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;

public class GUI {

	private JFrame frmAsml;
	
	private String degrees[]={"DN_0Degree","DN_90Degree","DN_180Degree","DN_270Degree",
			"UP_0Degree","UP_90Degree","UP_180Degree","UP_270Degree"};
	
	private String file_path = "/home/manikandan/Downloads/ASML_DATA/";
	
	private String fileName;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmAsml.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsml = new JFrame();
		frmAsml.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/com/asml/work/scissor.png")));
		frmAsml.getContentPane().setBackground(UIManager.getColor("Panel.background"));
		frmAsml.setFont(new Font("DejaVu Sans", Font.BOLD, 17));
		frmAsml.setTitle("ASML ");
		frmAsml.setBackground(Color.BLUE);
		frmAsml.setBounds(100, 100, 494, 177);
		frmAsml.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsml.getContentPane().setLayout(null);
		
		JLabel lblSaveImageAs = new JLabel("Save image as");
		lblSaveImageAs.setBounds(147, 27, 116, 23);
		frmAsml.getContentPane().add(lblSaveImageAs);
		
		JLabel lblFileSavedSuccesful = new JLabel("Recent Activity :");
		lblFileSavedSuccesful.setBounds(12, 120, 123, 15);
		frmAsml.getContentPane().add(lblFileSavedSuccesful);
		
		JLabel lblNewLabel = new JLabel("Nil");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(51, 204, 102));
		lblNewLabel.setBounds(147, 120, 319, 15);
		frmAsml.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(degrees);
		comboBox.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboBox.setBounds(266, 27, 210, 23);
		frmAsml.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Capture");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
		    		
		    		String result =comboBox.getItemAt(comboBox.getSelectedIndex()).toString();
		    		frmAsml.setState(JFrame.ICONIFIED);
		    		
		    		Thread.sleep(1000);
		            
					Robot robot= new Robot();
					String format = "PNG";
					fileName= result +"."+ format;					
					Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
					System.out.println("Bufered image loaded");
						
					ImageIO.write(screenFullImage, "PNG", new File(file_path+ fileName));
					System.out.println("Screenshot taken " + fileName);
//					lblFileSavedSuccesful.setForeground(null););
					
					lblNewLabel.setForeground(new Color(255, 0, 51));
					lblNewLabel.setText( "Saved as "+ fileName );
//					l3.setText("click capture for new image");
				
				}
				
				catch (Exception exception) {
					exception.printStackTrace();
					// TODO: handle exception
				}
				
				
				
			}
		});
		btnNewButton.setBounds(360, 62, 116, 23);
		frmAsml.getContentPane().add(btnNewButton);
		
		
		

	}
}
