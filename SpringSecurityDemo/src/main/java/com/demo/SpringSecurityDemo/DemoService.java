package com.demo.SpringSecurityDemo;

import org.springframework.security.access.annotation.Secured;

public class DemoService {
	@Secured("ROLE_USER")
	

		// Method
		public void method(String msg)
		{
			// Print statement
			System.out.println("User Authenticated "+ msg);
		}
	
	@Secured("ROLE_ADMIN")
	public void methods()
	{
		// Print statement
		System.out.println("Admin Authenticated");
	}
	}


