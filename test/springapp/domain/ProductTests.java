package springapp.domain;

import junit.framework.TestCase;

public class ProductTests extends TestCase {

	private Product product;
	
	protected void setUp() throws Exception{
		product= new Product();
	}
	
	public void testSetAndGetDescription(){
		String testDescription="aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription, product.getDescription());
	}
	
	public void testSetAndGetPrice(){
		Double testPrice=100.0;
		assertEquals(0,0,0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(),0);
	}
}
