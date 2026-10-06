// Cali Andrews
// Week 5 Assignment - Animal class
import java.util.ArrayList;

public class Animal 
{
	private String name;
	private int type;
	private int hunger;
	private int clinginess;
	private boolean isAngry;
	
	public Animal(String name, int type)
	{
		this.name = name;
		this.type = type;
		this.hunger = 0;
		this.clinginess = 0;
		this.isAngry = false;
	}
	public String getName()
	{
		return name;
	}
	public void pet()
	{
		clinginess = 0;
	}
	public void feed()
	{
		hunger = 0;
	}
	private void speak() 
	{
		if(type == 1 && isAngry) {
			System.out.println(name + " (Cat) says Meow");
		}
		else if(type == 2 && isAngry) {
			System.out.println(name + " (Dog) says Bork");
		}
		else {
			System.out.println(name + " is napping");
		}
	}
	public static void statusUpdate(ArrayList<Animal> allAnimals)
	{
		for(Animal a : allAnimals) 
		{
			a.hunger++;
			a.clinginess++;
			if(a.type == 1 && (a.clinginess > 8 || a.hunger > 3))
			{
				a.isAngry = true;
			}
			else if(a.type == 2 && (a.clinginess > 5 || a.hunger > 8))
			{
				a.isAngry = true;
			}
			else 
			{
				a.isAngry = false;
			}
			
			a.speak();
		}
	}
	
	
}
