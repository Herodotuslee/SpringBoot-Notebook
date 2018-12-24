package com.springbootnotebook.demo.Controller;


import com.springbootnotebook.demo.Model.Book;
import com.springbootnotebook.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @PostMapping("/books")
    public Book post(@RequestParam String name,@RequestParam String author,@RequestParam String description,@RequestParam int status){
        Book book =new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        return bookService.save(book);
    }


    @GetMapping("/books/{id}")
    public Optional<Book> getOne(@PathVariable long id){
        return bookService.findOne(id);
    }

//
//    @PutMapping("/books")
//    public Book updat(@RequestParam long id,@RequestParam String name,@RequestParam String author,)

    @PostMapping("/books/by")
    public  List<Book> findBy(@RequestParam int len){
        return bookService.findByJPQL(len);
    }

//    @PostMapping("/books/by"){
//        public int findBy(@RequestParam int status,@RequestParam long id){
//            return bookService.updateByJPQL(status,id);
//
//        }
//     }
}
