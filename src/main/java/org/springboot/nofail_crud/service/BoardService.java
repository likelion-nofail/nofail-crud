package org.springboot.nofail_crud.service;


import org.springboot.nofail_crud.data.dto.request.ChangeBoardTitleDto;
import org.springboot.nofail_crud.data.dto.request.RequestBoardDto;
import org.springboot.nofail_crud.data.dto.response.ResponseBoardDto;

public interface BoardService {
    ResponseBoardDto saveBoard(RequestBoardDto requestBoardDto);
    ResponseBoardDto getBoard(RequestBoardDto requestBoardDto);
    ResponseBoardDto changeBoardTitle(ChangeBoardTitleDto changeBoardTitleDto) throws Exception;
    void deleteBoard(String content) throws Exception;
}

