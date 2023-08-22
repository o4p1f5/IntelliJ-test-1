package test.test1;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
public class BookAPI {
    private List<Book> bookList = new ArrayList<>(); // DB는 아직 다루기 힘들어서 List로 예시 대체
    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book>  GetALL(){
        return bookList; // booKList 내용 조회
    }
    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public String Add(@RequestBody Book book){
        bookList.add(book);
        return "Add"; // postman -> post, body/raw/JSON으로 클래스에 있는 값을 지정해줘야됨
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")
    public String Update(@RequestBody Book tobook,@PathVariable int id){
        Book find_book = bookList.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null); // 찾는 id의 내용이 있는 찾음
        if(find_book != null){
            find_book.setAuthor(tobook.getAuthor());
            find_book.setName(tobook.getName());
            find_book.setPrice(tobook.getPrice());
            return "Update Success"; // postman -> post, body/raw/JSON(tobook)으로 적어준 내용으로 바꿈
        }
        return "fail";
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public String  Delete(@PathVariable int id) {
        Book find_book = bookList.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null); // 찾는 id의 내용이 있는 찾음

        if(find_book != null) {
             bookList.remove(find_book);
             return "Delete Success"; // 해당 id의 내용 지움
        }
        return "fail";
    }
}
