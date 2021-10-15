package testngfeatures;

import org.testng.annotations.Test;

public class PriorityConcept {
	// if want to executed tc on priority ,then use priority
	//priority  can give in - as well.
	//priority  can give in 0 as well.
	//if not giving priority for any test cases then they execute first after that priority mentioned tc executed.
	//if provide same priority then these executed on the basis of alphabetoc order.
	//if no priority given ,then tc executed on the basis of alphabetoc order.
	
	@Test()
	public void a_test() {
		System.out.println("a test");
	}

	@Test(priority = 1)
	public void b_test() {
		System.out.println("b test");
	}

	@Test()
	public void c_test() {
		System.out.println("c test");
	}

	@Test
	public void d_test() {
		System.out.println("d test");
	}

	@Test(priority = 2)
	public void e_test() {
		System.out.println("e test");
	}


}
