package com.example.scy_test_backend.board.model;

import lombok.Getter;
import lombok.Setter;

public class BoardDto {

    @Getter
    @Setter
    public static class RequestDto {
        private String title;

        private String content;

        private String writer;
    }
}
