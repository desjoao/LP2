public class LotteryTicket {

	public static void main (String[] args) {

		int [][] lotteryCard = { {20, 15, 3}, {8, 7, 2}, {7, 15, 8} };

		int [][] lotteryCard2 = new int[3][3];
		lotteryCard2[0][0] = 20;
		lotteryCard2[0][1] = 15;
		lotteryCard2[0][2] = 3;
		lotteryCard2[1][0] = 8;
		lotteryCard2[1][1] = 7;
		lotteryCard2[1][2] = 2;
		lotteryCard2[2][0] = 7;
		lotteryCard2[2][1] = 15;
		lotteryCard2[2][2] = 8;
		
		//[row][column]
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(lotteryCard2[i][j]);
			}
		}
	}
}
