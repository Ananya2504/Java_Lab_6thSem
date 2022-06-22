import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Student {
	String USN,name,address,category;
	int age;
	double cgpa;
	Scanner sc = new Scanner(System.in);
	public Student(String name,String usn,String addr, String cat,int age,double cgpa) {
		this.name = name;
		this.USN = usn;
		this.age = age;
		this.category = cat;
		this.cgpa=cgpa;
	}
	public void setCGPA(double g) {
		this.cgpa = g;
	}
	public String toString() {
		return "Name: "+name+" USN: "+USN+" Age:"+age+" address: "+address+" category:"+category+" CGPA:"+cgpa;
	}
}
