package org.springboot.nofail_crud.data.entity;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content222;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updateAt;
}
