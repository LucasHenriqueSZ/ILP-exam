package com.web_exam.web_library.application.controllers;

import com.web_exam.web_library.application.messages.MessagesSuccess;
import com.web_exam.web_library.domain.facades.BookFacade;
import com.web_exam.web_library.domain.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping("/new")
    public ModelAndView newBook(Book book) {
        ModelAndView mv = new ModelAndView("new_book");
        mv.addObject("book", book);
        return mv;
    }

    @PostMapping("/new")
    public ModelAndView createBook(@Validated Book book, BindingResult br,
                                   RedirectAttributes attributes) {
        if (br.hasErrors()) {
            return newBook(book);
        }
        ModelAndView mv = new ModelAndView();
        try {
            bookFacade.saveBook(book);
            mv.setViewName("redirect:/books/new");
            attributes.addFlashAttribute("message", MessagesSuccess.BOOK_CREATED.getMessage());
        } catch (Exception e) {
            attributes.addFlashAttribute("alert", e.getMessage());
            mv.setViewName("redirect:/books/new");
        }
        return mv;
    }

}
