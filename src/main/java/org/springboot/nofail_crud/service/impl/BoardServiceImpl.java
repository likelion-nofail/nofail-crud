package org.springboot.nofail_crud.service.impl;

import org.springboot.nofail_crud.data.dao.BoardDAO;
import org.springboot.nofail_crud.data.dto.request.ChangeBoardTitleDto;
import org.springboot.nofail_crud.data.dto.request.RequestBoardDto;
import org.springboot.nofail_crud.data.dto.response.ResponseBoardDto;
import org.springboot.nofail_crud.data.entity.Board;
import org.springboot.nofail_crud.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO){
        this.boardDAO = boardDAO;
    }

    public ResponseBoardDto getBoard(String id) throws Exception{
        Board board = boardDAO.selectBoard(id);

        ResponseBoardDto responseBoardDto =  new ResponseBoardDto();
        responseBoardDto.setContent(board.getContent());
        responseBoardDto.setId(board.getId());
        responseBoardDto.setName(board.getName());
        responseBoardDto.setTitle(board.getTitle());
        return responseBoardDto;
    }

    @Override
    public ResponseBoardDto saveBoard(RequestBoardDto requestBoardDto){
        Board board = new Board();
        board.setName(requestBoardDto.getName());
        board.setId(requestBoardDto.getId());
        board.setContent(requestBoardDto.getContent());
        board.setTitle(requestBoardDto.getTitle());
        board.setCreateAt(LocalDateTime.now());
        board.setUpdateAt(LocalDateTime.now());

        Board savedBoard = boardDAO.insertBoard(board);
        ResponseBoardDto responseBoardDto = new ResponseBoardDto();
        responseBoardDto.setTitle(savedBoard.getTitle());
        responseBoardDto.setName(savedBoard.getName());
        responseBoardDto.setContent(savedBoard.getContent());
        responseBoardDto.setId(savedBoard.getId());

        return responseBoardDto;
    }

    @Override
    public ResponseBoardDto getBoard(RequestBoardDto requestBoardDto) {
        return null;
    }


    @Override
    public ResponseBoardDto changeBoardTitle(ChangeBoardTitleDto changeBoardTitleDto)throws Exception{
        Board findBoard = boardDAO.updateBoardTitle(changeBoardTitleDto.getTitle());

        ResponseBoardDto responseBoardDto  = new ResponseBoardDto();
        responseBoardDto.setId(findBoard.getId());
        responseBoardDto.setTitle(findBoard.getTitle());
        responseBoardDto.setName(findBoard.getName());
        responseBoardDto.setId(findBoard.getId());
        return responseBoardDto;
    }

    @Override
    public void deleteBoard(String content) throws Exception{
        boardDAO.deleteBoard(content);
    }
}
