package org.springboot.nofail_crud.data.dao.impl;

import org.springboot.nofail_crud.data.dao.BoardDAO;
import org.springboot.nofail_crud.data.entity.Board;
import org.springboot.nofail_crud.data.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;


@Component
public class BoardDAOImpl implements BoardDAO {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    @Override
    public Board insertBoard(Board board){
        Board result = boardRepository.save(board);
        return result;
    }
    @Override
    public Board selectBoard(String id) throws Exception{
        Optional<Board> board = boardRepository.findById(id);
        if(board.isPresent()){
            Board result = board.get();
            return result;
        }
        else{
            throw new Exception("찾을 수 없다!");
        }
    }

    @Override
    public Board updateBoardTitle(String title) throws Exception{
        Optional<Board> findBoard = boardRepository.findById(title);
        Board result;

        if(findBoard != null){
            Board board = findBoard.get();

            board.setTitle(title);
            board.setUpdateAt(LocalDateTime.now());
            result = boardRepository.save(board);
        }
        else {
            throw new Exception("찾을 수 없음");
        }
        return result;
    }
    @Override
    public void deleteBoard(String content) throws Exception {
        Optional<Board> findBoard = boardRepository.findById(content);

        if(findBoard != null){
            Board board = findBoard.get();
            boardRepository.delete(board);
        }else{
            throw new Exception("찾을 수 없음");
        }
    }

}
