package com.springbootnotebook.demo.Service;

import com.springbootnotebook.demo.Model.Book;
import com.springbootnotebook.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAll(){
        return bookRepository.findAll();

    }

    public  Book save(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> findOne(long id){
        return bookRepository.findById(id);
    }

    public List<Book> findByJPQL(int len){
        return bookRepository.findAllByJPQL(len);
    }

//    @Transactional
//    public  int updateByJPQL(int status,long id){
//        return bookRepository.updateByJPQL(status,id);
//    }

}
