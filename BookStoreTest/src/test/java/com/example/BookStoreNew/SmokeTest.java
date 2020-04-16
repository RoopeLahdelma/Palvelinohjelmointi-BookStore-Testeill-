package com.example.BookStoreNew;

import static org.assertj.core.api.Assertions.assertThat; 

import org.junit.jupiter.api.Test;
//import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BookStoreNew.domain.UserRepository;
import com.example.BookStoreNew.web.BookController;
import com.example.BookStoreNew.web.UserDetailServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Test
	void contextLoadsOther() {
	}
	@Autowired
    private BookController bookController;
	@Autowired
	private UserRepository usrepository;
	@Autowired
	private UserDetailServiceImpl udsi;
	

    @Test
    public void contexLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }
    
    @Test
    public void contexLoads1() throws Exception {
        assertThat(usrepository).isNotNull();
    }	
    
    @Test
    public void contexLoads2() throws Exception {
        assertThat(udsi).isNotNull();
    }	
}

