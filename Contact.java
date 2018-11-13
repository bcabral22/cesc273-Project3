/**
 * 
 * Class: Contacts Description: creating the constrctors
 *
 */
public class Contact {
	/**
	 * this is the first name variable
	 */
	private String firstName;
	/**
	 * this is the last name variable
	 */
	private String lastName;
	/**
	 * this is the Phone number variable
	 */
	private String phoneNumber;
	/**
	 * this is the address Variable
	 */
	private String address;
	/**
	 * this it is the city variable
	 */
	private String city;
	/**
	 * this is the zip code variabele
	 */
	private String zipCode;

	/**
	 * Constructor passing in data to set the values
	 * 
	 * @param f1 first name pass in
	 * @param l1 last name pass in
	 * @param p1 phone number pass in
	 * @param a1 address pass in
	 * @param c1 city pass in
	 * @param z1 zip code pass in
	 */

	public Contact(String firstName1, String lastName1, String phoneNumber1, String address1, String city1,
			String zipCode1) {
		firstName = firstName1;
		lastName = lastName1;
		phoneNumber = phoneNumber1;
		address = address1;
		city = city1;
		zipCode = zipCode1;

	}

	/**
	 * getfirstName getting first name variable
	 * 
	 * @return firstName: first name variable
	 */
	public String getfirstName() {
		return firstName;
	}

	/**
	 * getlastName: getting last name variable
	 * 
	 * @return lastName: last name variable
	 */
	public String getlastName() {
		return lastName;
	}

	/**
	 * getphoneNumber: getting phone Number variable
	 * 
	 * @return phoneNumber: phone Number variable
	 */
	public String getphoneNumber() {
		return phoneNumber;
	}

	/**
	 * getaddress: getting address variable
	 * 
	 * @return address: address variable
	 */
	public String getaddress() {
		return address;
	}

	/**
	 * getcity: getting city variable
	 * 
	 * @return city: city variable
	 */
	public String getcity() {
		return city;
	}

	/**
	 * getzipCode: getting zip code variable
	 * 
	 * @return zipCode: phone zip code variable
	 */
	public String getzipCode() {
		return zipCode;
	}

	/**
	 * setfirstName: setting first name varible
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;

	}

	/**
	 * setlastName: setting last name varible
	 */
	public void setlastName(String lastName) {
		this.lastName = lastName;

	}

	/**
	 * setphoneNumber: setting phoneNumber varible
	 */
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;

	}

	/**
	 * setaddress: setting address varible
	 */
	public void setaddress(String address) {
		this.address = address;

	}

	/**
	 * setcity: setting city varible
	 */
	public void setcity(String city) {
		this.city = city;

	}

	/**
	 * setzipCode: setting zipCode varible
	 */
	public void setzipCode(String zipCode) {
		this.zipCode = zipCode;

	}

	/**
	 * toString: returning format
	 */
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + " Phone Number: " + phoneNumber + " Address: " + address
				+ " City: " + city + " Zip Code: " + zipCode;

	}

	/**
	 * equalsto:
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Contact) {
			Contact c = (Contact) o;
			boolean checkFirst = this.getfirstName().equalsIgnoreCase(c.getfirstName());
			boolean checkLast = this.getlastName().equalsIgnoreCase(c.getlastName());
			return checkFirst && checkLast;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param c
	 * @return
	 */

	public int compareTo(Contact c) {
		if (getlastName().compareToIgnoreCase(c.getlastName()) == 0) {

			return getfirstName().compareToIgnoreCase(c.getlastName());
		} else {
			return getlastName().compareToIgnoreCase(c.getlastName());
		}

	}
}