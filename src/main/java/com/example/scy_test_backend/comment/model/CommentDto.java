package com.example.scy_test_backend.comment.model;

import lombok.Getter;
import lombok.Setter;

public class CommentDto {

    @Getter
    @Setter
    public static class RequestDto {
        private long board_idx;
        private String content;
        private String writer;
    }
}
