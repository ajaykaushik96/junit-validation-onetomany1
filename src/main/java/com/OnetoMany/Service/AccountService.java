package com.OnetoMany.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnetoMany.Repository.Repo;
import com.OnetoMany.Repository.RepoAccount;
import com.OnetoMany.dto.Account;
import com.OnetoMany.dto.Employee;

@Service
public class AccountService {

	
	@Autowired
	private RepoAccount repoAccount;
	@Autowired
	Repo repo;

	public List<Account> getAllAccounts()
	{
		return repoAccount.findAll();
	}
	
	public Optional<Account> getAccount(Long accNo)
	{
	   return repoAccount.findById(accNo);	
	}

	public void addAccount(Account account , Long accNo)
	{
		Optional<Employee> emp=repo.findById(accNo);
		if(emp.isPresent())
		{
			System.out.print("ifsc code======================"+account.getAccNo());
			Employee e=emp.get();
			account.setEmployee(e);
			repoAccount.save(account);
		}
		
	}
	
	public void UpdateAccount(Account account ,Long accNo)
	{
		Optional<Account> acc = repoAccount.findById(accNo);
		if(acc.isPresent())
		{
			Account a = acc.get();
			a.setAccNo(account.getAccNo());
			//a.setIFSC_Code(account.getIFSC_Code());
			repoAccount.save(a);
			
		}
		

	}
	
	public void DeleteAccount(Long accNo)
	{
		repoAccount.deleteById(accNo);
	}
	

}
