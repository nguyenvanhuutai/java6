package com.poly.demo.online_so5;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @RequestMapping("/yourPage")
public String yourPage(Model model,@RequestParam("p") Optional<Integer> p) {
    int totalPages = 15; // Số trang tổng cộng
    int currentPage =  p.orElse(0)    ; // Trang hiện tại

    List<Integer> pageNumbers = new ArrayList<>();
    for (int i = Math.max(currentPage - 2, 1); i <= Math.min(currentPage + 2, totalPages); i++) {
        pageNumbers.add(i);
    }

    model.addAttribute("totalPages", totalPages);
    model.addAttribute("currentPage", currentPage);
    model.addAttribute("pageNumbers", pageNumbers);

    return "page";
}

}
