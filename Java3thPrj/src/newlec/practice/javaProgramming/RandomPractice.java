package newlec.practice.javaProgramming;
import java.util.Random;

public class RandomPractice {

	public static void main(String[] args) {
		
//		 int num ;
//		 Random rand = new Random();
//		 num = rand.nextInt(100);
//		 boolean b = num%2==1;
//		 System.out.printf("%d : %b\n", num,b);
		 
//		 int num ;
//		 Random rand = new Random();
//		 num = rand.nextInt(100);
//		 boolean b = ++num % 3 == 1;
//		 System.out.printf("Random 값은 %d이고, %b 입니다.\n",num,b);
		 
		
		
		
		
		 int num ;
		 Random rand = new Random();
		 
		 System.out.print("┌────────────────────────────────────┐\n");
		 System.out.print("│              로또 복권               │\n");
		 System.out.print("└────────────────────────────────────┘\n");
		 System.out.print(" 번호:");
		 num = rand.nextInt(45);
		 System.out.printf("%d,",++num);
		 num = rand.nextInt(45);
		 System.out.printf(" %d,",++num);
		 num = rand.nextInt(45);
		 System.out.printf(" %d,",++num);
		 num = rand.nextInt(45);
		 System.out.printf(" %d,",++num);
		 num = rand.nextInt(45);
		 System.out.printf(" %d,",++num);
		 num = rand.nextInt(45);
		 System.out.printf(" %d  ",++num);
		 num = rand.nextInt(45);
		 System.out.printf(" 보너스: %d",++num);

		
		
		
		
		

		 

		 
	}

}
