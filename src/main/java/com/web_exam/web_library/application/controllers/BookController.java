package com.web_exam.web_library.application.controllers;

import com.web_exam.web_library.application.messages.MessagesSuccess;
import com.web_exam.web_library.domain.facades.BookFacade;
import com.web_exam.web_library.domain.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookFacade bookFacade;

    @GetMapping("/new")
    public ModelAndView newBook(@RequestParam(name = "id", required = false) Long id, Book book,
                                RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("new_book");
        try {
            Book currentBook = (id != null) ? bookFacade.findBookById(id) : book;
            mv.addObject("book", currentBook);
        } catch (Exception e) {
            attributes.addFlashAttribute("alert", e.getMessage());
            mv.setViewName("redirect:/books");
        }
        return mv;
    }

    @PostMapping("/new")
    public ModelAndView createBook(@Validated Book book, BindingResult br,
                                   RedirectAttributes attributes) {
        if (br.hasErrors()) {
            return newBook(null, book, attributes);
        }
        ModelAndView mv = new ModelAndView();
        try {
            bookFacade.saveBook(book);
            mv.setViewName("redirect:/books");
            attributes.addFlashAttribute("message", MessagesSuccess.BOOK_CREATED.getMessage());
        } catch (Exception e) {
            attributes.addFlashAttribute("alert", e.getMessage());
            mv.setViewName("redirect:/books/new");
        }
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView editBook(@Validated Book book, BindingResult br,
                                 RedirectAttributes attributes) {
        if (br.hasErrors()) {
            return newBook(null, book, attributes);
        }
        ModelAndView mv = new ModelAndView();
        try {
            bookFacade.editBook(book);
            mv.setViewName("redirect:/books");
            attributes.addFlashAttribute("message", MessagesSuccess.BOOK_UPDATED.getMessage());
        } catch (Exception e) {
            attributes.addFlashAttribute("alert", e.getMessage());
            mv.setViewName("redirect:/books");
        }
        return mv;
    }

    @GetMapping
    public ModelAndView listBooks(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "7") int size) {
        ModelAndView mv = new ModelAndView("list_books");
        Page<Book> booksPage = bookFacade.listBooks(page, size);
        mv.addObject("booksPage", booksPage);
        return mv;
    }

    @GetMapping("/delete")
    public ModelAndView deleteBook(@RequestParam("id") Long id, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/books");
        try {
            bookFacade.deleteBook(id);
            attributes.addFlashAttribute("message", MessagesSuccess.BOOK_DELETED.getMessage());
        } catch (Exception e) {
            attributes.addFlashAttribute("alert", e.getMessage());
        }
        return mv;
    }

    @GetMapping("/rest-search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("query") String query) {
        return ResponseEntity.ok(bookFacade.searchBooks(query));
    }
}
