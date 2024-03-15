package com.sutdy.board.controller;

import com.sutdy.board.entity.Board;
import com.sutdy.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write")
    public String boardWriteForm(){

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardlist(Model model){

        model.addAttribute("list",boardService.boardList());

        return "boardlist";
    }

    @GetMapping("board/view")
    public String boardView(Model model, @RequestParam(name = "id") Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("board/delete")
    public String boardDelete(@RequestParam(name = "id") Integer id){

        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
}
