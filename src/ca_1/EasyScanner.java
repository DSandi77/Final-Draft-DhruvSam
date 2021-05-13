package ca_1;

import java.util.*;

public class EasyScanner
{
  public static int nextInt()
  {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    return i;
  }

  public static double nextDouble()
  {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    double d = sc.nextDouble();
    return d;
  }

  public static String nextString()
  {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    return s;
  }

  public static char nextChar()
  {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    char c = sc.next().charAt(0);
    return c;
  }
  
  public static Float nextFloat()
  {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    float f = sc.nextFloat();
    return f;
  }
  

}

