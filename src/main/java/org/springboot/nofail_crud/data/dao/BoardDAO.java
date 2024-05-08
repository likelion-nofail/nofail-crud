package org.springboot.nofail_crud.data.dao;


import org.springboot.nofail_crud.data.entity.Board;

public interface BoardDAO {
    Board insertBoard(Board board);

    Board selectBoard(String id) throws Exception;

    Board updateBoardTitle(String title) throws Exception;

    void deleteBoard(String content) throws Exception;
}
