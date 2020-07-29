package sovimal.olymicid.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import sovimal.olymicid.commonutility.BaseClass;
import sovimal.olymicid.pagractions.Olymicid_HomePage_Action;

public class Olymicid_HomePageTest extends BaseClass {
	

	
	@Test
	public void verifyEmailID(){
		
		Assert.assertEquals(Olymicid_HomePage_Action.verfiyEmailName(), "engineeringolympiads@gmail.com");
	}
	

}
