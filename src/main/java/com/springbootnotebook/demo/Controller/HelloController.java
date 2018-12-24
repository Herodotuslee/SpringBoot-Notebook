package com.springbootnotebook.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/api/v2")
public class HelloController {
//    method

//    Spring mvc annotation
//    @Autowired
//    private Book book;

    @RequestMapping("/hello")
    @GetMapping
    public String sayHi(){
        return "hello World";
    }

    @RequestMapping(value="/say",method= RequestMethod.GET)
    public String sayHi2(){
        return "hello World2";
    }

//    simple way
    @GetMapping("/hello2")
    public String sayHi3(){
        return "hello World3";
    }

    //not only response template
    @GetMapping("/books")
    @ResponseBody
    public Object getAll(){

        Map<String,Object> map =new HashMap<>();
        map.put("name","hello");
        map.put("age",18);
       return map;
    }

    @GetMapping("/books/{id}/{username:[a-z_]+}")
    public  Object getOne(@PathVariable long id,@PathVariable String username){
        System.out.println("---id "+id + "username "+ username);
        Map<String,Object> book= new HashMap<>();
        book.put("name","yoyoy");
        book.put("isbn","1313131");
        book.put("user",username);
        return book;
    }
    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,String author,String isbn){
        Map<String,Object> book =new HashMap<String,Object>();
        book.put("name",name);
        book.put("author",author);
        book.put("isbn",isbn);
        return book;
    }
}
