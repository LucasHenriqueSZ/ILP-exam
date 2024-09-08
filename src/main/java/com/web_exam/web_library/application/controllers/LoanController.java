package com.web_exam.web_library.application.controllers;

import com.web_exam.web_library.application.messages.MessagesSuccess;
import com.web_exam.web_library.domain.facades.LoanFacade;
import com.web_exam.web_library.domain.model.Loan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanFacade loanFacade;

    @GetMapping("/make")
    public ModelAndView makeLoan(Loan loan, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("make_loan");
        mv.addObject("loan", loan);
        return mv;
    }

    @PostMapping("/make")
    public ModelAndView createLoan(@Validated Loan loan, BindingResult br,
                                   RedirectAttributes attributes) {
        if (br.hasErrors()) {
            return makeLoan(loan, attributes);
        }
        ModelAndView mv = new ModelAndView();
        try {
             loanFacade.saveLoan(loan);
            mv.setViewName("redirect:/loans/make");
            attributes.addFlashAttribute("message", MessagesSuccess.LOAN_CREATED.getMessage());
        } catch (Exception e) {
            attributes.addFlashAttribute("alert", e.getMessage());
            mv.setViewName("redirect:/loans/make");
        }
        return mv;
    }

    @GetMapping
    public ModelAndView listLoans(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "7") int size) {
        ModelAndView mv = new ModelAndView("list_loans");
        mv.addObject("loansPage", loanFacade.listLoans(page, size));
        return mv;
    }

}
