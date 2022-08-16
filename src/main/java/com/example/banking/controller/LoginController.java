package com.example.banking.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.banking.dao.LoginDao;
import com.example.banking.model.Accounts;
import com.example.banking.model.Customers;
import com.example.banking.model.ForgotPassword;
import com.example.banking.model.Login;

@Controller
public class LoginController {

	@Autowired
	LoginDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/registerUser")
	public String adduserform(Model m) {
		m.addAttribute("command", new Login());
		return "registerUser";
	}

	@RequestMapping("/login")
	public String loginuserform(Model m) {
		m.addAttribute("command", new Login());
		return "login";
	}

	@RequestMapping("/forgotPassword")
	public String forgotPasswordForm(Model m) {
		m.addAttribute("command", new ForgotPassword());
		return "forgotPassword";
	}

	@RequestMapping(value = "/addusersave", method = RequestMethod.POST)
	public String addusersave(@ModelAttribute("login") Login login, Errors errors) {
		System.out.println(login.getUsername().equals(null) || login.getPassword().equals(null));
		if (errors.hasErrors()) {
			return "redirect:/LoginFailed";
		} else {

			Random rnd = new Random();
			int accountNumer = rnd.nextInt(999999);	
			
			String first4char = login.getSinNumber().substring(0,4);
			int intForFirst4Char = Integer.parseInt(first4char);
			String custId = login.getFirstName().substring(0,2) + login.getLastName().substring(0,2) + intForFirst4Char;
			login.setAccountNumber(accountNumer);
			login.setCustId(custId);
			
			dao.save(login);
			dao.insertAccounts(login);
			dao.insertUtilities(login);

			return "redirect:/login"; // will redirect to viewemp request mapping
		}
	}

	// login.............

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String logincheck(@ModelAttribute("login") Login login, Errors errors, Model m) throws SQLException {
		// dao.loginchecking(login);
		String isAdmin = dao.isAdminCheck(login);
		System.out.println("isAdmin = " + isAdmin);

		if (isAdmin.equalsIgnoreCase("Y")) {

			return "redirect:/adminhome";
		}

		if (dao.loginchecking(login)) {

			m.addAttribute("username", login.getUsername());
			m.addAttribute("sbalance", login.getUsername());
			m.addAttribute("cbalance", login.getUsername());
			return "redirect:/home";
		}

		else {
			return "redirect:/LoginFailed";
		}
	}

	@RequestMapping(value = "/customerLoginCheck", method = RequestMethod.POST)
	public ModelAndView customerLoginCheck(@ModelAttribute("Customers") Customers customers, Errors errors,
			ModelMap m) throws SQLException {

		Customers customer = dao.customerLoginCheck(customers);

		if (customer != null) {

			int accountNumber = dao.getAccountNumber(customer.getCust_ID());
			System.out.println("isAdmin = " + customer.getIsAdmin());

			if (customer.getIsAdmin().equalsIgnoreCase("Y")) {
				return new ModelAndView("adminhome");
			}
			Float balance = dao.getBalance(customer.getCust_ID());

			if (balance != 0 && balance > 0.0) {

				m.addAttribute("username", customer.getF_name() + ", " + customer.getL_name());
				m.addAttribute("sbalance", balance);
				m.addAttribute("custid", customer.getCust_ID());
				m.addAttribute("accountNumber", accountNumber);
				m.addAttribute("dueAmount", dao.getDueAmount(customer.getCust_ID()));
			}
			return new ModelAndView("redirect:/home", m); 
		} else {
			return new ModelAndView("LoginFailed");
		}
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewuser")
	public String viewuser(Model m) {
		List<Login> list = dao.getUsers();
		m.addAttribute("list", list);
		return "viewuser";
	}

	// home
	@RequestMapping("/home")
	public String home(Model m) {
		m.addAttribute("command", new Login());
		return "home";
	}

	@RequestMapping("/adminhome")
	public String adminhome(Model m) {
		m.addAttribute("command", new Login());
		return "adminhome";
	}

	// login failed
	@RequestMapping("/LoginFailed")
	public String LoginFailed(Model m) {
		m.addAttribute("command", new Login());
		return "LoginFailed";
	}

	// Edit and Delete User

	@RequestMapping(value = "/edituser/{loginid}")
	public String edit1(@PathVariable int loginid, Model m) {
		Login login = dao.getUserById(loginid);
		m.addAttribute("command", login);
		return "usereditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editusave", method = RequestMethod.POST)
	public String editsave1(@ModelAttribute("member") Login login) {
		dao.update1(login);
		return "redirect:/viewuser";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteuser/{loginid}", method = RequestMethod.GET)
	public String delete1(@PathVariable int loginid) {
		dao.delete1(loginid);
		return "redirect:/viewuser";
	}

	@RequestMapping(value = "/depositMoney", method = RequestMethod.POST)
	public String depositMoney(@ModelAttribute("Accounts") Accounts acc, Errors errors, Model m) throws SQLException {
		dao.depositMoney(acc);
		Float balance = dao.getBalance(acc.getCust_ID());
		int accountNumber = dao.getAccountNumber(acc.getCust_ID());

		if (balance != null && balance > 0.0) {
			m.addAttribute("sbalance", balance);
			m.addAttribute("accountNumber", accountNumber);
		} else {
			m.addAttribute("sbalance", 0.0);
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/accountmain/{custid}", method = RequestMethod.GET)
	public ModelAndView accountmain(@PathVariable String custid, Model mm) {
		Accounts details = dao.getCustDetails(custid);
		int accountNumber = dao.getAccountNumber(custid);
		ModelAndView m = new ModelAndView("home");
		System.out.println("Hi" + custid);
		if (details != null) {
			m.addObject("sbalance", details.getBalance());
			m.addObject("username", details.getF_name() + ", " + details.getL_name());
			m.addObject("custid", custid);
			m.addObject("accountNumber", accountNumber);
			m.addObject("dueAmount", dao.getDueAmount(custid));
		}
		return m;
	}

	@RequestMapping(value = "/utilitiesamount/{custid}/{sbalance}/{dueAmount}", method = RequestMethod.GET)
	public ModelAndView utilitiesamount(@PathVariable String custid, @PathVariable Float sbalance,
			@PathVariable String dueAmount, ModelMap m) {
		int accountNumber = dao.getAccountNumber(custid);
		m.addAttribute("custid", custid);
		m.addAttribute("sbalance", sbalance);
		m.addAttribute("dueAmount", dueAmount);
		m.addAttribute("accountNumber", accountNumber);
		m.addAttribute("command", new Accounts());
		return new ModelAndView("redirect:/utilities", m);
	}

	@RequestMapping(value = "/depositamount/{custid}/{sbalance}", method = RequestMethod.GET)
	public ModelAndView depositAmount(@PathVariable String custid, @PathVariable Float sbalance, ModelMap m) {
		int accountNumber = dao.getAccountNumber(custid);
		m.addAttribute("custid", custid);
		m.addAttribute("sbalance", sbalance);
		m.addAttribute("accountNumber", accountNumber);
		m.addAttribute("command", new Accounts());
		return new ModelAndView("redirect:/deposit", m);
	}

	@RequestMapping(value = "/withdrawamount/{custid}/{sbalance}", method = RequestMethod.GET)
	public ModelAndView withdrawamount(@PathVariable String custid, @PathVariable Float sbalance, ModelMap m) {
		int accountNumber = dao.getAccountNumber(custid);
		m.addAttribute("custid", custid);
		m.addAttribute("sbalance", sbalance);
		m.addAttribute("accountNumber", accountNumber);
		m.addAttribute("command", new Accounts());
		return new ModelAndView("redirect:/withdraw", m);
	}

	@RequestMapping(value = "/transferamount/{custid}/{sbalance}", method = RequestMethod.GET)
	public ModelAndView transferamount(@PathVariable String custid, @PathVariable Float sbalance, ModelMap m) {
		int accountNumber = dao.getAccountNumber(custid);
		m.addAttribute("custid", custid);
		m.addAttribute("sbalance", sbalance);
		m.addAttribute("accountNumber", accountNumber);
		m.addAttribute("command", new Accounts());
		return new ModelAndView("redirect:/transfer", m);
	}

	@RequestMapping("/accounthome")
	public String accounthome(Model m) {
		m.addAttribute("command", new Accounts());
		return "accounthome";
	}

	// utilities route
	@RequestMapping("/utilities")
	public String utilities(Model m) {
		m.addAttribute("command", new Accounts());
		System.out.println(m.getAttribute("command"));
		return "utilities";
	}

	// deposit route
	@RequestMapping("/deposit")
	public String deposit(Model m) {
		m.addAttribute("command", new Accounts());
		return "deposit";
	}

	// withdraw route
	@RequestMapping("/withdraw")
	public String withdraw(Model m) {
		m.addAttribute("command", new Accounts());
		return "withdraw";
	}

	// transfer route
	@RequestMapping("/transfer")
	public String transfer(Model m) {
		m.addAttribute("command", new Accounts());
		return "transfer";
	}

	@RequestMapping(value = "/depositAmount/{custid}", method = RequestMethod.POST)
	public ModelAndView depositAmount(@PathVariable String custid, @ModelAttribute("account") Accounts a, ModelMap m1) {
		System.out.println("Hello" + custid);
		dao.depositMoney(custid, a.getBalance());
		Accounts details = dao.getCustDetails(custid);
		int accountNumber = dao.getAccountNumber(custid);

		if (details != null) {
			m1.addAttribute("sbalance", details.getBalance());
			m1.addAttribute("username", details.getF_name() + ", " + details.getL_name());
			m1.addAttribute("custid", custid);
			m1.addAttribute("accountNumber", accountNumber);
			m1.addAttribute("dueAmount", dao.getDueAmount(custid));
		} else {
			m1.addAttribute("sbalance", 0.0);
			m1.addAttribute("username", "test");
			m1.addAttribute("custid", "0");
			m1.addAttribute("dueAmount", "0");
			m1.addAttribute("accountNumber", 0);
		}
		return new ModelAndView("redirect:/home", m1); 
	}

	@RequestMapping(value = "/withdrawAmount/{custid}", method = RequestMethod.POST)
	public ModelAndView withdrawAmount(@PathVariable String custid, @ModelAttribute("account") Accounts a, ModelMap m1) {
		dao.drawMoney(custid, a.getBalance());
		Accounts details = dao.getCustDetails(custid);
		int accountNumber = dao.getAccountNumber(custid);
		if (details != null) {
			m1.addAttribute("sbalance", details.getBalance());
			m1.addAttribute("username", details.getF_name() + ", " + details.getL_name());
			m1.addAttribute("custid", custid);
			m1.addAttribute("accountNumber", accountNumber);
			m1.addAttribute("dueAmount", dao.getDueAmount(custid));
		} else {
			m1.addAttribute("sbalance", 0.0);
			m1.addAttribute("username", "test");
			m1.addAttribute("custid", "0");
			m1.addAttribute("dueAmount", "0");
			m1.addAttribute("accountNumber", 0);
		}
		return new ModelAndView("redirect:/home", m1); 
	}

	@RequestMapping(value = "/transferAmount/{custid}", method = RequestMethod.POST)
	public ModelAndView transferAmount(@PathVariable String custid, @ModelAttribute("account") Accounts a, ModelMap m1) {
		int count = dao.drawMoney(custid, a.getBalance());
		int accountNumber = dao.getAccountNumber(custid);
		if (count > 0)
			dao.depositMoneyToAccount(a.getAccount_number(), a.getBalance());
		Accounts details = dao.getCustDetails(custid);
		if (details != null) {
			m1.addAttribute("sbalance", details.getBalance());
			m1.addAttribute("username", details.getF_name() + ", " + details.getL_name());
			m1.addAttribute("custid", custid);
			m1.addAttribute("accountNumber", accountNumber);
			m1.addAttribute("dueAmount", dao.getDueAmount(custid));
		} else {
			m1.addAttribute("sbalance", 0.0);
			m1.addAttribute("username", "test");
			m1.addAttribute("custid", "0");
			m1.addAttribute("dueAmount", "0");
			m1.addAttribute("accountNumber", 0);
		}
		return new ModelAndView("redirect:/home", m1); 
	}

	@RequestMapping(value = "/utilitiesAmount/{custid}", method = RequestMethod.POST)
	public ModelAndView utilitiesAmount(@PathVariable String custid, @ModelAttribute("account") Accounts a, ModelMap m1) {
		int count = dao.drawMoney(custid, a.getDueAmount());
		if (count > 0) {
			dao.payBill(custid, a.getDueAmount());
		}

		Accounts details = dao.getCustDetails(custid);
		int accountNumber = dao.getAccountNumber(custid);
		if (details != null) {
			m1.addAttribute("sbalance", details.getBalance());
			m1.addAttribute("username", details.getF_name() + ", " + details.getL_name());
			m1.addAttribute("custid", custid);
			m1.addAttribute("accountNumber", accountNumber);
			m1.addAttribute("dueAmount", dao.getDueAmount(custid));
		} else {
			m1.addAttribute("sbalance", 0.0);
			m1.addAttribute("username", "test");
			m1.addAttribute("custid", "0");
			m1.addAttribute("dueAmount", "0");
			m1.addAttribute("accountNumber", 0);
		}
		return new ModelAndView("redirect:/home", m1);
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String forgotpassword(@ModelAttribute("forgotpassword") ForgotPassword forgotPassword, Errors errors) {
		if (errors.hasErrors()) {
			return "redirect:/LoginFailed";
		} else if (forgotPassword.getNewPassword().equals(forgotPassword.getConfirmNewPassword())) {
			dao.updatePassword(forgotPassword);
			return "redirect:/login";
		} else {
			return "redirect:/login";
		}
	}
}
