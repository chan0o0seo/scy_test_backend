package com.example.scy_test_backend.board;


import com.example.scy_test_backend.board.model.Board;
import com.example.scy_test_backend.board.model.BoardDto;
import com.example.scy_test_backend.common.BaseResponse;
import com.example.scy_test_backend.common.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Tag(name = "User API", description = "Board 작성 관련 API")
public class BoardController {
    private final BoardService boardService;
    private static final Logger logger = LogManager.getLogger(BoardController.class);


    @GetMapping("/list")
    @Operation(summary = "목록 조회", description = "게시글 전체 목록을 가져옵니다.")
    public BaseResponse<List<Board>> list() {
        return BaseResponse.success(boardService.getAllBoards());
    }

    @GetMapping("/{idx}")
    @Operation(summary = "단건 조회", description = "idx로 게시글 하나를 조회합니다.")
    public BaseResponse<Board> getBoard(@PathVariable String idx) {
        return BaseResponse.success(boardService.getBoardByIdx(Long.parseLong(idx)));
    }

    @PostMapping("/write")
    @Operation(summary = "게시글 작성", description = "새로운 게시글을 작성합니다.")
    public BaseResponse<String> writeBoard(@RequestBody BoardDto.RequestDto requestDto) {
        logger.info("write");
        Board newBoard = Board.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .writer(requestDto.getWriter())
                .build();

            boardService.createBoard(newBoard);
        return BaseResponse.success("ok");
    }

}
