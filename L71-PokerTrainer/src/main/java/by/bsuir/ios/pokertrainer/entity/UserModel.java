package by.bsuir.ios.pokertrainer.entity;

public class UserModel {
	private String name;
	private String password;
	private String repeatPassword;

	public String getName() {
		return name;
	}

	public void setName(String login) {
		this.name = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
