package com.test.productcatolog;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("product")
public class ProductResource {
	ProductRepository repo=new ProductRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProduct() {
		return repo.getProduct();
	}
	@GET
	@Path("ofId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") int id) {
		return repo.getProduct(id);
	}
	@POST
	@Path("insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product createProduct(Product p) {
		System.out.println(p);
		repo.createProduct(p);
		return p;
	}
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product updateProduct(Product p) {
		System.out.println(p);
		if(repo.getProduct(p.getId()).getId() ==0) {
			repo.createProduct(p);
		}else {
			repo.updateProduct(p);
		}
		return p;
	}
	@DELETE
	@Path("ofId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product deleteProduct(@PathParam("id") int id) {
		Product p= repo.getProduct(id);
		if(p.getId()!=0) {
			repo.deleteProduct(id);
		}
		return p;
	}
}
