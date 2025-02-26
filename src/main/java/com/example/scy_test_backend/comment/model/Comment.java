package com.example.scy_test_backend.comment.model;


import com.example.scy_test_backend.board.model.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String content;

    private String writer;

    @ManyToOne
    @JoinColumn(name = "board_idx", nullable = false)
    private Board board;
}
