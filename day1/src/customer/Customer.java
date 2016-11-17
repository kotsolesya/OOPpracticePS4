package customer;
//Create class Customer
public class Customer {
//Initialize variables
	String numberOfCard;
	String sex;
	String ageCategory;
	int countOfPurchase=0;
	double countPriceOfGoods=0;
	int countOfVisits=0;
// get  count Of Visits
	public int getcountOfVisits() {
		return countOfVisits;
	}
// set  count Of Visits
	public void setcountOfVisits(int countOfVisits) {
		this.countOfVisits = countOfVisits;
	}
//Get Number of Card
	public String getNumberOfCard() {
		return numberOfCard;
	}
//Set Number of Card
	public void setNumberOfCard(String numberOfCard) {
		this.numberOfCard = numberOfCard;
	}
//Get count of purchases
	public int getCountOfPurchase() {
		return countOfPurchase;
	}
//Set count of purchases
	public void setCountOfPurchase(int d) {
		this.countOfPurchase = d;
	}
// get count of 
	public double getcountPriceOfGoods() {
		return countPriceOfGoods;
	}
// set count price of goods
	public void setcountPriceOfGoods(double countPriceOfGoods) {
		this.countPriceOfGoods = countPriceOfGoods;
	}

}
