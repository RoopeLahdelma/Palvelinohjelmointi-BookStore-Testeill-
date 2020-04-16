package com.example.BookStoreNew;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BookStoreNew.domain.Book;
import com.example.BookStoreNew.domain.BookRepository;
import com.example.BookStoreNew.domain.Category;
import com.example.BookStoreNew.domain.CategoryRepository;
import com.example.BookStoreNew.domain.User;
import com.example.BookStoreNew.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

		@Autowired
		private BookRepository brepository;
		@Autowired
		private CategoryRepository crepository;
		@Autowired
		private UserRepository usrepository;
		
		@Test
		public void findBynameShouldReturnBook() {
		List<Book> books = brepository.findByName("Apinanraivo");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getName()).isEqualTo("Apinanraivo");
		}
		@Test
		public void createNewBook() {
		Book book = new Book("Touhutonni", "Pertti Jarla", "2839281928", 2014, new Category("Komedia"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
		}
		
	@Test
	public void deleteNewBook() {
	Book book = new Book("Alamaailman ihmeet", "Samppa Linna", "3728918273", 2020, new Category("Romanttinen-komedia"));
	brepository.save(book);

	brepository.deleteAll(); //<---Miksi ei toimi tämä?!?!? 
	assertThat(brepository.count()).isEqualTo(0);
	
	}  
    
    @Test
    public void findByNameCategoryTest() {
    	List<Category> categories = crepository.findByName("Toiminta");
    	assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Toiminta");
    }
    
    @Test
    public void createNewCategoryTest() {
       	Category category = new Category("Kauhu-Komedia");
    	crepository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }
    
    @Test
    public void deleteCategoryTests() {
    	Category category = new Category("Kauhu-Komedia");
    	crepository.save(category);
    	crepository.deleteAll();
    	assertThat(crepository.count()).isEqualTo(0); 
    }   
    
    @Test
    public void findByUsernameUserTest() {
        User user = usrepository.findByUsername("user");
        assertThat(user.getUsername()).isNotNull();
        assertThat(user.getRole()).isEqualTo("USER");
    }
    
    @Test
    public void createNewUserTest() {
    	User user = new User("Roope L", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
    	usrepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }  
    
    @Test
    public void deleteAllUsersTest() {
    	User user = new User("Roope L", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
    	usrepository.save(user);
    	usrepository.deleteAll();
    	assertThat(usrepository.count()).isEqualTo(0); 
    }   

}
		


