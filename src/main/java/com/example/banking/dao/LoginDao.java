package com.example.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.banking.model.Accounts;
import com.example.banking.model.Customers;
import com.example.banking.model.ForgotPassword;
import com.example.banking.model.Login;

@Component
public class LoginDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Login p) {
		String sql = "insert into customers(username,password,f_name,l_name,Cust_ID) " + " values('" + p.getUsername()
				+ "','" + p.getPassword() + "','" + p.getFirstName() + "','" + p.getLastName() + "','" + p.getCustId()
				+ "')";
		return template.update(sql);
	}

	public int insertAccounts(Login p) {
		String sql = "Insert into Accounts (Account_number, Account_Type_ID, Cust_ID, Balance)  " + " values('"
				+ p.getAccountNumber() + "', 222 ,'" + p.getCustId() + "','5000')";
		return template.update(sql);
	}

	public int insertUtilities(Login p) {
		String sql = "Insert into Utilities (Biller_ID, Biller_Name, Cust_ID, Bill_date, dueAmount) " + " values('"
				+ p.getCustId() + "','" + p.getUsername() + "','" + p.getCustId() + "',sysdate(), 500)";
		return template.update(sql);
	}

	public boolean loginchecking(Login p) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/banking", "root", "");
		String sql = "select * from login where username = '" + p.getUsername() + "' and password = '" + p.getPassword()
				+ "'";

		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		boolean status = rs.next();
		return status;
	}

	public List<Login> getUsers() {
		return template.query("select * from login", new RowMapper<Login>() {
			public Login mapRow(ResultSet rs, int row) throws SQLException {
				Login e = new Login();
				e.setLoginid(rs.getString(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));

				return e;
			}
		});
	}

	public int update1(Login p) {
		String sql = "update login set username='" + p.getUsername() + "', password='" + p.getPassword()
				+ "' where loginid=" + p.getLoginid() + "";
		return template.update(sql);
	}

	public int delete1(int loginid) {
		String sql = "delete from login where loginid=" + loginid + "";
		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Login getUserById(int loginid) {
		String sql = "select * from login where loginid=?";
		return template.queryForObject(sql, new Object[] { loginid }, new BeanPropertyRowMapper<Login>(Login.class));
	}

	@SuppressWarnings("deprecation")
	public Float getBalance(String cust_ID) {
		String sql = "select A.Balance from Accounts A, Customers C  where A.Cust_ID = C.Cust_ID and C.Cust_ID = ? and Account_Type_ID = 222 ";
		return template.queryForObject(sql, new Object[] { cust_ID }, Float.class);
	}

	@SuppressWarnings("deprecation")
	public Accounts getCustDetails(String cust_ID) {
		String sql = "select A.Balance, C.username, C.f_name, C.l_name from Accounts A, Customers C  where A.Cust_ID = C.Cust_ID and C.Cust_ID = ?";
		return template.queryForObject(sql, new Object[] { cust_ID },
				new BeanPropertyRowMapper<Accounts>(Accounts.class));
	}

	@SuppressWarnings("deprecation")
	public Customers customerLoginCheck(Customers c) {
		String sql = "select * from Customers where username=? and password=?";
		return template.queryForObject(sql, new Object[] { c.getUsername(), c.getPassword() },
				new BeanPropertyRowMapper<Customers>(Customers.class));
	}

	@SuppressWarnings("deprecation")
	public String isCustomerAdmin(Customers c) {
		String sql = "select isAdmin from Customers where username=? and password=?";
		return template.queryForObject(sql, new Object[] { c.getUsername(), c.getPassword() }, String.class);
	}

	@SuppressWarnings("deprecation")
	public String getDueAmount(String custid) {
		String sql = "select dueAmount from Utilities where Cust_ID=?";
		return template.queryForObject(sql, new Object[] { custid }, String.class);
	}

	@SuppressWarnings("deprecation")
	public String isAdminCheck(Login p) {
		String sql = "select isAdmin from login where username=? and password=?";
		return template.queryForObject(sql, new Object[] { p.getUsername(), p.getPassword() }, String.class);
	}

	public int depositMoney(Accounts p) {
		String sql = "update Accounts set balance = (balance+ " + p.getBalance() + ") " + "where Cust_ID= "
				+ p.getCust_ID();
		return template.update(sql);
	}

	public void depositMoney(String custid, String amount) {
		try {
			Float f = Float.parseFloat(amount);
			String sql = "update Accounts set Balance = (Balance+ " + f + ") where Cust_ID='" + custid + "'";
			template.update(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int drawMoney(String custid, String amount) {
		int count = 0;
		try {

			Float f = Float.parseFloat(amount);
			String sql = "update Accounts set Balance = (Balance- " + f + ") where Cust_ID='" + custid + "'";
			count = template.update(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int payBill(String custid, String amount) {
		int count = 0;
		try {
			Integer f = Integer.parseInt(amount);
			String sql = "update Utilities set dueAmount = (dueAmount- " + f + ") where Cust_ID='" + custid + "'";
			count = template.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updatePassword(ForgotPassword forgotPassword) {
		String sql = "update Customers set password='" + forgotPassword.getConfirmNewPassword() + "' where username='"
				+ forgotPassword.getUserName() + "'";
		return template.update(sql);
	}
	
	public void depositMoneyToAccount(int accountNumber, String amount) {
		try {
			Float f = Float.parseFloat(amount);
			String sql = "update Accounts set Balance = (Balance+ " + f + ") where Account_number=" + accountNumber + "";
			template.update(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public int getAccountNumber(String custid) {
		String sql = "select Account_number from Accounts where Cust_ID=?";
		return template.queryForObject(sql, new Object[] { custid }, Integer.class);
	}
}
