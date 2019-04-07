package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		String amounts = JOptionPane.showInputDialog("How Many Robots?");
		String color = JOptionPane.showInputDialog("What color?(red, green, blue)");
		String sidess = JOptionPane.showInputDialog("How many sides(>0, number)");
		int amount=Integer.parseInt(amounts);
		int sides = Integer.parseInt(sidess);
		for (int i = 0; i < amount; i++) {
			Robot r = new Robot(200*i+100, 300);
			r.setSpeed(10);
			
			if(color.equalsIgnoreCase("red")) {
				r.setPenColor(Color.RED);
			}
			else if(color.equalsIgnoreCase("blue")) {
				r.setPenColor(Color.blue);
			}
			else if(color.equalsIgnoreCase("green")) {
				r.setPenColor(Color.green);
			}
			else {
				JOptionPane.showMessageDialog(null, "Color not red, green, or blue");
				System.exit(0);
			}
			r.penDown();
			Thread t = new Thread(()-> {
				for (int j = 0; j < sides; j++) {
					r.move(50);
					r.turn(360/sides);
				}
			}
			);
			t.start();
		}
	}
}
