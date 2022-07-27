package model;

import dao.AccountDAO;

public class LoginLogic2 {
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO(); 
		Account account = dao.findByLogin(login);
		return account != null;
	}

}
