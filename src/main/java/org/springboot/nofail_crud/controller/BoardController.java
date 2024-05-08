package org.springboot.nofail_crud.controller;

import org.springboot.nofail_crud.data.dto.request.ChangeBoardTitleDto;
import org.springboot.nofail_crud.data.dto.request.RequestBoardDto;
import org.springboot.nofail_crud.data.dto.response.ResponseBoardDto;
import org.springboot.nofail_crud.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    private BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseBoardDto> getBoard(@RequestParam RequestBoardDto requestBoardDto) throws Exception{
        ResponseBoardDto responseBoardDto = boardService.getBoard(requestBoardDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @PostMapping("/post") // create
    public ResponseEntity<ResponseBoardDto> createBoard(@RequestParam RequestBoardDto requestBoardDto){
        ResponseBoardDto responseBoardDto = boardService.saveBoard(requestBoardDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseBoardDto> changeBoardTitle(@RequestBody ChangeBoardTitleDto changeBoardTitleDto) throws  Exception{
        ResponseBoardDto responseBoardDto = boardService.changeBoardTitle(changeBoardTitleDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }

    @DeleteMapping("/delete") // delete
    private ResponseEntity<String> deleteBoard(String content) throws Exception{
        boardService.deleteBoard(content);
        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료!");
    }
}
