package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	Faker faker = new Faker();

	public String generateNewUserName() {
		return faker.name().username();
	}

	public String generateNewPassword() {
		return faker.internet().password();
	}

	public String generateEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String generateNewAddress() {
		return faker.address().fullAddress();
	}

}
