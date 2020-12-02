package Assignment1;


import javax.swing.*;      
import java.awt.*;          
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;



public class NBody extends JPanel implements ActionListener {

	private Lists<Planet> planet_list;
	private double scale;
	
	public NBody(String file_input_name){
		ArrayList<String> read_in_data = new ArrayList<String>();
		//reads in data file
		try {
			File myObj = new File(file_input_name);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				read_in_data.add(myReader.nextLine());
				}
			System.out.println(read_in_data);
			myReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		//Check for ArrayList or LinkedList
		if(read_in_data.get(0).equals("ArrayList")){
			planet_list = new ArrayList<Planet>();
		}
		else{
			planet_list = new LinkedList<Planet>();
		}
		
		scale = Double.parseDouble(read_in_data.get(1));// initialize the scale
		
		for(int i = 2; i < read_in_data.size(); i++){//start for index 2 reads in the info about planet
			String[] planet_info = read_in_data.get(i).split(",");
			Planet my_planet = new Planet(planet_info[0], Double.parseDouble(planet_info[1]), Integer.parseInt(planet_info[2]) , Integer.parseInt(planet_info[3]) , Double.parseDouble(planet_info[4]) , Double.parseDouble(planet_info[5]), Integer.parseInt(planet_info[6]));
			planet_list.add(my_planet);
			System.out.println(my_planet); 
		}
	}
		
	public void paintComponent(Graphics g) {
		Timer tm = new Timer(500, this);
		super.paintComponent(g);
		for (int i = 0; i < planet_list.size(); i++) {
			g.setColor(planet_list.get(i).getColor());
			g.fillOval(planet_list.get(i).getXCord(), planet_list.get(i).getYCord(), planet_list.get(i).getSize(), planet_list.get(i).getSize()); 
		}
	
		tm.start();
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < planet_list.size() -1 ; i++) {
			planet_list.get(i).force(planet_list.get(i + 1), scale); //calculate the force
			planet_list.get(i).newPos();//update positon 
		}
		repaint();
	}
	
	public static void main(String[] args){
			NBody my_planet = new NBody("nbody_input.txt");
			
			JFrame jf = new JFrame();
			jf.setTitle("Assignment1 NBody problem");
			jf.setSize(768, 768);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(my_planet);
			jf.setVisible(true);
		
		}
	
}