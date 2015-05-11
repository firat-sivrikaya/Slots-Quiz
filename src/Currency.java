/* Currency Interface 
 * to be used in Coin and Crystal
 * 01.05.2015 
 * author: @Irmak Akkuzuluoglu
 */

public interface Currency {
	// methods
	public void gain( int amount);
	public void spend( int amount);
	public int getAmount();
}
