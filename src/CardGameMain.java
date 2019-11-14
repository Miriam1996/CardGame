import java.util.Scanner;


public class CardGameMain {

	public static void main(String[] args) {
		System.out.println("Please Enter the Number of Players between 2 and 4");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n<2||n>4) {
			System.out.println("Please Enter the Number of Players between 2 and 4");
			n = in.nextInt();
		}
		CardGame cg = new CardGame(n);
		cg.Game();
		
		

	}

}
