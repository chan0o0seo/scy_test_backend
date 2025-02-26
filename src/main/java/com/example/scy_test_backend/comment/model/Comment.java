package com.example.scy_test_backend.comment.model;


import com.example.scy_test_backend.board.model.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String content;

    private String writer;

    @ManyToOne
    @JoinColumn(name = "board_idx", nullable = false)
    @JsonIgnore
    private Board board;
}
