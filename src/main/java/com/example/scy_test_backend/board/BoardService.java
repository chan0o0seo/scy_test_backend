package com.example.scy_test_backend.board;

import com.example.scy_test_backend.board.model.Board;
import com.example.scy_test_backend.common.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getAllBoards() throws CustomException {
        return boardRepository.findAll();
    }

    public Board getBoardByIdx(Long idx) throws CustomException {
        return boardRepository.findByIdx(idx);
    }

    public void createBoard(Board board) throws CustomException {
        boardRepository.save(board);
    }
}
