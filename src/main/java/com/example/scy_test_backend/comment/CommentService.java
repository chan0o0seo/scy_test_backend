package com.example.scy_test_backend.comment;

import com.example.scy_test_backend.board.BoardRepository;
import com.example.scy_test_backend.board.model.Board;
import com.example.scy_test_backend.comment.model.Comment;
import com.example.scy_test_backend.common.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public void save(Comment comment, long board_idx) throws CustomException {
        Board board = boardRepository.findById(board_idx).orElseThrow(() -> new CustomException("no board found"));
        comment.setBoard(board);
        board.getComments().add(comment);
        boardRepository.save(board);
    }

}
