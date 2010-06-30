package springapp.service;

import springapp.service.SimpleProductManager;
import springapp.domain.Product;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class SimpleProductManagerTests extends TestCase {

	private SimpleProductManager productManager;
	private List<Product> products;
	private static int PRODUCT_COUNT=2;
	private static int PRICE_INCREASE=10;
	
	private static Double CHAIR_PRICE=new Double(20.50);
	private static String CHAIR_DESC="Chair";
	
	private static Double TABLE_PRICE=new Double(150.10);
	private static String TABLE_DESC="Table";
	
	protected void setUp() throws Exception {
		productManager=new SimpleProductManager();
		products=new ArrayList<Product>();
		
		Product product= new Product();
		product.setDescription("Chair");
		product.setPrice(CHAIR_PRICE);
		products.add(product);
		
		product = new Product();
		product.setDescription("Table");
		product.setPrice(TABLE_PRICE);
		products.add(product);
		
		productManager.setProducts(products);
		
	}
	
	public void testGetProductsWithNoProducts(){
		productManager=new SimpleProductManager();
		assertNull(productManager.getProducts());
	}
	
	public void testGetProductes(){
		List<Product> products = productManager.getProducts();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
		
		Product product = products.get(0);
		assertEquals(CHAIR_DESC, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());
		
		product=products.get(1);
		assertEquals(TABLE_DESC, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());
	}
	
    public void testIncreasePriceWithNullListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.increasePrice(PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Products list is null.");
        }
    }
    
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.setProducts(new ArrayList<Product>());
            productManager.increasePrice(PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Products list is empty.");
        }           
    }
    
    public void testIncreasePriceWithPositivePercentage() {
        productManager.increasePrice(PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Product> products = productManager.getProducts();      
        Product product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice());
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getPrice());       
    }

}
