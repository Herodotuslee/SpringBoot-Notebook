package com.springbootnotebook.demo.Repository;

import com.springbootnotebook.demo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {


//    @Query("select b from Book b where length(b.name)>?1")
    @Query(value ="select * from book where  LENGTH(name)>?1", nativeQuery = true)
    List<Book> findAllByJPQL(int len);

//


}
