interface A
{
	private void m1()
	{
		System.out.println("Private non-static Method");
	}
	private static void m2()
	{
		System.out.println("Private Static Method");
	}
	public static void main(String[] args)
	{
		//A a = new A();
		A.m1();
		A.m2();
	}
}
