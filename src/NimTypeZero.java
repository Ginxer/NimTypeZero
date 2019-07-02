import java.util.*;
public class NimTypeZero 
{
	public static void main (String args[])
	{
		ArrayList<Integer> arr = create_deck();
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		ArrayList<Integer> p3 = new ArrayList<Integer>();
		ArrayList<Integer> p4 = new ArrayList<Integer>();

		divide_cards(arr, p1);
		divide_cards(arr, p2);
		divide_cards(arr, p3);
		divide_cards(arr, p4);

		the_game(p1,p2,p3,p4);
	}
	
	public static ArrayList<Integer> create_deck()
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for (int i=0; i<40; i++)
		{
			temp.add(i%4);
		}
		
		return temp;
	}
	
	public static void  divide_cards(ArrayList<Integer> lis, ArrayList<Integer> temp)
	{
		Random rand = new Random();
		int random_num;
		
		for (int i=0; i<4; i++)
		{
			random_num = rand.nextInt(40);
			
			if (lis.get(random_num) == 9)
			{
				while(lis.get(random_num)== 9)
				{
					random_num = rand.nextInt(40);
				}
			}
			temp.add(lis.get(random_num));
			lis.set(random_num, 9);
		}
	}
	
	public static void printy_print(ArrayList<Integer> t1)
	{
		for (int i=0; i< t1.size(); i++)
		{
			if (i!=3)
			{
				System.out.print(t1.get(i)+ ", ");
			}
			else
			{
				System.out.print(t1.get(i));
			}
		}
		
		System.out.println();
	}
	
	public static int ai_num(ArrayList<Integer> t, int tot)
	{
		int answer = 0, target;
		
		if (tot <= 6)
		{
			target = 3;
		}
		else if ( tot <= 7)
		{
			target = 2;
		}
		else if ( tot <= 8)
		{
			target = 1;
		}
		else
		{
			target = 0;
		}
		
		for (int c =0; c < target +1; c++)
		{
			for (int r =0; r< t.size(); r++)
			{
				if (t.get(r) == target)
				{
					return r;
				}
			}
			
			target--;
		}
		
		
		return answer;	
	}
	
	public static void the_game(ArrayList<Integer> t1, ArrayList<Integer> t2, ArrayList<Integer> t3, ArrayList<Integer> t4)
	{
		int r, total = 0, temp, num_cpu, index, ind = 0;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You are going to play Nim Type Zero against 3 Computer players.");
		System.out.println("You are going to be given 4 cards and your mission is to not  ");
		System.out.println("make the total go over 9.");
		
		System.out.println();
		
		
		r = rand.nextInt(4) +1;
		
		while(total <= 9 )
		{
			ind = 0;
			System.out.println("---------------------------------------------------");
			System.out.println("It is player " + r + " turn");
			
			if (r == 1)
			{
				printy_print(t1);
				System.out.println("What number would you like to place, player 1?");
				temp = scan.nextInt();
				
				for (int i=0; i< t1.size(); i++)
				{
					if (t1.get(i) == temp)
					{
						t1.remove(i);
						ind = 1;
						break;
					}
				}
				
				if (ind != 1)
				{
					System.out.println("Invalid number please insert a number in your hand. NOW!");
					while( ind  != 1)
					{
						temp = scan.nextInt();
						
						for (int i=0; i< t1.size(); i++)
						{
							if (t1.get(i) == temp)
							{
								t1.remove(i);
								ind = 1;
								break;
							}
						}
					}
				}
				
				total = total + temp;
				
				System.out.println();
				System.out.println("The total is " + total);
				System.out.println();
				r = r + 1;
			}
			else if ( r == 2)
			{
				printy_print(t2);
				System.out.println("What number would you like to place, player 2?");
				
				try
				{
					Thread.sleep(3000);
				}
				catch(InterruptedException ex)
				{
					
				}
				index = ai_num(t2, total);
				num_cpu = t2.get(index);
				t2.remove(index);
				
				System.out.println(num_cpu);
				total = total + num_cpu;
				
				System.out.println();
				System.out.println("The total is " + total);
				System.out.println();
				r = r + 1;
			}
			else if ( r == 3)
			{
				printy_print(t3);
				System.out.println("What number would you like to place, player 3?");
				
				try
				{
					Thread.sleep(3000);
				}
				catch(InterruptedException ex)
				{
					
				}
				
				index = ai_num(t3, total);
				num_cpu = t3.get(index);
				t3.remove(index);
				
				System.out.println(num_cpu);
				total = total + num_cpu;
				
				System.out.println();
				System.out.println("The total is " + total);
				System.out.println();
				 r = r + 1;
			}
			else
			{
				printy_print(t4);
				System.out.println("What number would you like to place, player 4?");
				
				try
				{
					Thread.sleep(3000);
				}
				catch(InterruptedException ex)
				{
					
				}
				
				index = ai_num(t4, total);
				num_cpu = t4.get(index);
				t4.remove(index);
				
				System.out.println(num_cpu);
				total = total + num_cpu;
				
				System.out.println();
				System.out.println("The total is " + total);
				System.out.println();
				r = 1;
			}
		}
		
		if (r == 1)
		{
			System.out.println("Player 4 loses this round");
		}
		else if (r == 2)
		{
			System.out.println("Player 1 loses this round");
		}
		else if ( r == 3)
		{
			System.out.println("Player 2 loses this round");
		}
		else
		{
			System.out.println("Player 3 loses this round");
		}
	}
}
