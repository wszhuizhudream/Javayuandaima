package cn.reull.www;

public class Compute implements Runnable {
int i=0;
public void run()
{
for (int i=0;i<10;i++)
{
	System.out.println(i);
	}
}
}

