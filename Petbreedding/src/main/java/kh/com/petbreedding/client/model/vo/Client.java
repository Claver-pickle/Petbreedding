package kh.com.petbreedding.client.model.vo;

public class Client {

	private String email;
	private String password;
	private String cl_num;
	private String nickname;
	private String name;
	private String tel;
	
	@Override
	public String toString() {
		return "Client [email=" + email + ", password=" + password + ", cl_num=" + cl_num + ", nickname=" + nickname
				+ ", name=" + name + ", tel=" + tel + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCl_num() {
		return cl_num;
	}

	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	

}
