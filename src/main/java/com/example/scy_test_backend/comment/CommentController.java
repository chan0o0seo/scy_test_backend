package com.example.scy_test_backend.comment;


import com.example.scy_test_backend.comment.model.Comment;
import com.example.scy_test_backend.comment.model.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Tag(name = "Comment API", description = "댓글 작성 관련 API")
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/write")
    @Operation(summary = "댓글 작성", description = "새로운 댓글을 작성합니다.")
    public void writeComment(@RequestBody CommentDto.RequestDto dto) {
        Comment newComment = Comment.builder()
                .content(dto.getContent())
                        .writer(dto.getWriter())
                                .build();

        commentService.save(newComment,dto.getBoard_idx());
    }
}
