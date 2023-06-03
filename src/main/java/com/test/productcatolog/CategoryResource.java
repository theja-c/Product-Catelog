package com.test.productcatolog;

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

@Path("category")
public class CategoryResource {
	CategoryRepository repo=new CategoryRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategory() {
		return repo.getCategory();
	}
	@GET
	@Path("ofId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category getCategory(@PathParam("id") int id) {
		return repo.getCategory(id);
	}
	@POST
	@Path("insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Category createCategory(Category c) {
		System.out.println(c);
		repo.createCategory(c);
		return c;
	}
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Category updateCategory(Category c) {
		System.out.println(c);
		if(repo.getCategory(c.getId()).getId() ==0) {
			repo.createCategory(c);
		}else {
			repo.updateCategory(c);
		}
		return c;
	}
	@DELETE
	@Path("ofId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category deleteCategory(@PathParam("id") int id) {
		Category c= repo.getCategory(id);
		if(c.getId()!=0) {
			repo.deleteCategory(id); 
		}
		return c;
	}
}
