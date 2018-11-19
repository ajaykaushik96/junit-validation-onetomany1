package com.OnetoMany.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnetoMany.Service.AccountService;
import com.OnetoMany.dto.Account;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountservice;
	
	
	@GetMapping("/account")
	public List<Account> getAllAccounts()
	{
		
		return accountservice.getAllAccounts();
		
	}
     
	@GetMapping("/account/{accNo}")
	public Optional<Account> getAccount(@PathVariable Long accNo)
	{
		return accountservice.getAccount(accNo);
	}
	
	@PostMapping("/account/{accNo}")
	public void addAccount(@RequestBody Account account ,@PathVariable Long accNo)
	
	{
		System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+account.getAccNo());
		accountservice.addAccount(account, accNo);
	}
	
	@PutMapping("/account/{accNo}")
	public void UpdateAccount(@RequestBody Account account , @PathVariable Long accNo)
	{
		accountservice.UpdateAccount(account, accNo);
		
		
		
		
	}
	
	
	@DeleteMapping("/account/{accNo}")
	public void DeleteAccount(@PathVariable Long accNo)
	{ 
		accountservice.DeleteAccount(accNo);
	}
	
	
	
	
	
	
}
