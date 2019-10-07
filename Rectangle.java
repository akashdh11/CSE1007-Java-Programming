package encapsulation;

public class Rectangle {
	private int length;
	private int breadth;
	public void getinput(int length,int breadth)
	{
		this.length=length;
		this.breadth=breadth;
		int ar=length*breadth;
		System.out.println(ar);
	}
	public void getperi(int length,int breadth)
	{
		this.length=length;
		this.breadth=breadth;
		int pr=length*breadth;
		System.out.println(pr);
	}
	
	
	

	public static void main(String[] args) {
		Rectangle r=new Rectangle();
		r.getinput(3, 4);
		r.getperi(2, 1);

	}

}
