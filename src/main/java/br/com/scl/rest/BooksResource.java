package br.com.scl.rest;

import br.com.scl.domain.Book;
import br.com.scl.service.BookService;
import br.com.scl.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class BooksResource {

	@Autowired
	private BookService bookService;

	@GET
	public List<Book> get() {
		List<Book> books = bookService.getBooks();
		return books;
	}

	@GET
	@Path("{id}")
	public Book get(@PathParam("id") long id) {
		Book c = bookService.getBook(id);
		return c;
	}

	@GET
	@Path("/title/{title}")
	public List<Book> getByNome(@PathParam("title") String title) {
		List<Book> books = bookService.getBookByTitle(title);
		return books;
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		bookService.delete(id);
		return Response.Ok("Book deletado com sucesso");
	}

	@POST
	public Response post(Book c) {
		bookService.save(c);
		return Response.Ok("Book salvo com sucesso");
	}

	@PUT
	public Response put(Book c) {
		bookService.save(c);
		return Response.Ok("Book atualizado com sucesso");
	}
}
