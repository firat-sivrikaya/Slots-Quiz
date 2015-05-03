/* Coin
 * 01.05.2015 
 * author: @Irmak Akkuzuluoglu
 */
public class Coin implements Currency {

	// properties
	int amount;
	
	// constructor
	public Coin() {
		amount = 0;
	}

	// methods
	@Override
	public void gain(int gained) {
		amount = amount + gained;
	}

	@Override
	public void spend(int spent) {
		amount = amount - spent;
	}

	@Override
	public int getAmount() {
		// returns the amount of coins
		return amount;
	}

}
