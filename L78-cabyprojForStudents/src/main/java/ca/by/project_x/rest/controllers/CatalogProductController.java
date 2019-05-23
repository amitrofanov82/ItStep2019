package ca.by.project_x.rest.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.conversion.EntityDtoCoversionUtils;
import ca.by.project_x.persistence.model.catalog.ProductImage;
import ca.by.project_x.persistence.repository.auto.ProductsAutoRepository;
import ca.by.project_x.rest.dto.Comment;
import ca.by.project_x.rest.dto.catalog.Product;
import ca.by.project_x.rest.dto.catalog.ProductDetails;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/catalog")
@Slf4j
public class CatalogProductController {
	
	@Autowired
	ProductsAutoRepository prodRepo;
	
	/** to prevent extra large queries to DB */
	private final static int MAX_DB_SELECTION_LIMIT = 100;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/product")
	public ResponseEntity<List<Product>> getAllProducts() {
        log.debug("get all products request");
        List<Product> product = new ArrayList<>(5);
        Product product1 = new Product(new Long(1), "Mega-Vintage", "NonPenisCanina", "Helmet", "Original helmet of Rome legioneers", 999.99, "/resources/products/1.jpg");
        Product product2 = new Product(new Long(2), "Linen", "NonPenisCanina", "Pillow", "Just usual black pillow on which you can sleep", 999.99, "/resources/products/2.jpg");
        Product product3 = new Product(new Long(3), "Accessories", "Crafter", "Book Cover", "Cool stuff, its book cover, you can hide ugly books into this thing!", 49.99, "/resources/products/3.jpg");
        Product product4 = new Product(new Long(4), "Accessories", "Crafter", "Beer box", "Most useful thing EVER!", 69.0, "/resources/products/4.jpg");
        Product product5 = new Product(new Long(5), "Accessories", "SomeOtherShop", "Purse", "Purse for money and different tiny stuff", 45.93, "/resources/products/5.jpg");

        product.addAll(Arrays.asList(new Product[] {product1, product2, product3, product4, product5}));

        return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/product")
	public ResponseEntity<String> addProduct(@RequestBody Product newProduct) {
		System.out.println(newProduct.toString());
		return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		System.out.println("delete categor with id = " + id);
		return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/product/{id}")
	public ResponseEntity<ProductDetails> getProductDetails(@PathVariable Long id) throws IOException {

        Comment c1 = new Comment(1L, id, "type", "This is a reason to read books!!!!", new Long(1), "PinkPony");
        Comment c2 = new Comment(2L, id, "type", "Piece of shit", new Long(2), "Hater666");

        Product p = new Product(id, "Books", "Crafter", "Book Cover", "Cool stuff, its book cover, you can hide ugly books into this thing!",
        		49.99, "/resources/products/3.jpg");
        ProductDetails product = new ProductDetails(p, 5.0, new String[] {"M"}, "Leather, Paper", new String[] {"brown"},
        		false, new String[] {"/resources/products/3.jpg", "/resources/products/3.jpg"}, new Comment[] {c1, c2});

        return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam(defaultValue = "10") Integer maxSize,
			@RequestParam(required = false) String orderBy, @RequestParam(required = false) String type,
			@RequestParam(required = false) Long[] categoryIds, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer skip, @RequestParam(defaultValue = "") String q) {

        List<Product> products = new ArrayList<Product>(Arrays.asList(new Product[] {
                new Product(new Long(1), "Mega-Vintage", "NonPenisCanina", "Helmet", "Original helmet of Rome legioneers", 999.99, "/resources/products/1.jpg"),
                new Product(new Long(2), "Linen", "NonPenisCanina", "Pillow", "Just usual black pillow on which you can sleep", 999.99, "/resources/products/2.jpg"),
                new Product(new Long(3), "Accessories", "Crafter", "Book Cover", "Cool stuff, its book cover, you can hide ugly books into this thing!", 49.99, "/resources/products/3.jpg"),
                new Product(new Long(4), "Accessories", "Crafter", "Beer box", "Most useful thing EVER!", 69.0, "/resources/products/4.jpg"),
                new Product(new Long(5), "Accessories", "SomeOtherShop", "Purse", "Purse for money and different tiny stuff", 45.93, "/resources/products/5.jpg"),
                new Product(new Long(6), "Mega-Vintage", "NonPenisCanina", "Helmet", "Original helmet of Rome legioneers", 999.99, "/resources/products/1.jpg"),
                new Product(new Long(7), "Linen", "NonPenisCanina", "Pillow", "Just usual black pillow on which you can sleep", 999.99, "/resources/products/2.jpg"),
                new Product(new Long(8), "Accessories", "Crafter", "Book Cover", "Cool stuff, its book cover, you can hide ugly books into this thing!", 49.99, "/resources/products/3.jpg")
        }));

        List<Product> productsFilter = new ArrayList<>();

        for (Product product : products) {
            if (productsFilter.size() >= maxSize)
                break;
            q = q.replaceAll("^\"|\"$", "").toLowerCase().trim();
            if (q.isEmpty()
                || prepared(product.getName()).contains(q)
                || prepared(product.getDescription()).contains(q)) {
                productsFilter.add(product);
            }
        }

        return new ResponseEntity<>(productsFilter, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/category/{id}")
	public ResponseEntity<List<Product>> productsInCategory(@PathVariable Long id,
			@RequestParam(required = false) Integer maxSize, @RequestParam(required = false) String orderBy,
			@RequestParam(required = false) String type, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer skip) {
		
		Page<ca.by.project_x.persistence.model.catalog.Product> entities =  prodRepo.findByCategoryId(1L, null);
		List<Product> result = new ArrayList<>();
		
		//TODO: too slow approach. Refactor later
		entities.forEach(e -> {
			List<ProductImage> pi = prodRepo.findImagesByProductId(e.getId());
			e.setProductImages(pi);		
			result.add(EntityDtoCoversionUtils.categoryToDto(e));
		});
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	
    private String prepared(String originalString)
    {
        return originalString.toLowerCase().trim();
    }
}
