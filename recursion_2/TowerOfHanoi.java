package recursion_2;

public class TowerOfHanoi {
	public static void towerOfHanoi(int n,char s,char h,char d) {
		if(n==1) {
			System.out.println("move 1st disk from "+ s+" to "+d);
			return;
		}
		towerOfHanoi(n-1, s, d, h);
		System.out.println("move "+n+"th disk from "+ s+" to "+d);
		towerOfHanoi(n-1, h, s, d);
	}

	public static void main(String[] args) {
		towerOfHanoi(2, 's', 'h', 'd');

	}

}
