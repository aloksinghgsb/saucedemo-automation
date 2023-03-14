package pageObjects;

public interface HomePageElements {
	String homePageHeading="//div[@class='login_logo']";
	String username="//input[@id='user-name']";
	String pwd="//input[@id='password']";
	String loginbtn="//input[@id='login-button']";
	String invalidLoginMsg="//h3[@data-test='error']";

}
