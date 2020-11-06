package Assignment1;

import java.awt.*;
import java.util.*;


public class Planet{
	private String name;
	private double mass, x_vel, y_vel, force_X, force_Y;
	private int x_cord, y_cord, size;
	private Color randColor;
	private double g_constant = 6.674 * Math.pow(10, -11);
	
	public Planet(String aName, double aMass, int aX_cord, int aY_cord, double aX_vel, double aY_vel, int aSize){
		name = aName;
		mass = aMass;
		x_cord = aX_cord;
		y_cord = aY_cord;
		x_vel = aX_vel;
		y_vel = aY_vel;
		size = aSize;
		
		Random rand = new Random();
		int red = rand.nextInt(255);
		int green = rand.nextInt(255);
		int blue = rand.nextInt(255);
		randColor = new Color(red, green, blue);//assign random color to the planet
	}
	
	
	public void force(Planet a, double scale){ //using the Force formula
		Planet current = this;
		
		double x = a.x_cord - current.x_cord;
		double y = a.y_cord - current.y_cord;
		
		double r = Math.sqrt(x*x + y*y);
		double force = (g_constant * current.mass * a.mass / ((r * r) / scale));
		
		current.force_X += force*x / r;
		current.force_Y += force*y / r;
	}
		
	
	
	public void newPos(){ //update on the position
		x_vel += force_X/mass;
		y_vel += force_Y/mass;
		
		x_cord += x_vel;
		y_cord += y_vel;
	}	
	
	public void setXVel(double num){
		x_vel = num;
	}
	
	public void setYVel(double num){
		y_vel = num;
	}
	
	public void setXCord(int num){
		x_cord = num;
	}
	
	public void setYCord(int num){
		y_cord = num;
	}

	public String getName(){
		return name;
	}
	
	public double getMass(){
		return mass;
	}
	
	public int getXCord(){
		return x_cord;
	}
	
	public int getYCord(){
		return y_cord;
	}
	
	public double getXVel(){
		return x_vel;
	}
	
	public double getYVel(){
		return y_vel;
	}
	
	public double getForceX(){
		return force_X;
	}
	
	public double getForceY(){
		return force_Y;
	}
	
	public int getSize(){
		return size;
	}
	
	public Color getColor(){
		return randColor;
	}
	
	public String toString(){
		String result = "Planet " + this.name + " : mass = " + this.mass + 
		" | x position = " + this.x_cord +
		" | y position = " + this.y_cord +
		" | velocity in x direction = " + this.x_vel +
		" | velocity in y direction = " + this.y_vel +
		" | radius size = " + this.size;
		
		return result;
	}
}