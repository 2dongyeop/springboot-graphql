package io.dongvelop.springbootgraphql.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 게시글 엔티티 모델
 */
@Getter
@Entity
@ToString
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "views")
    private Long views = 0L;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @OneToMany(mappedBy = "post")
    private final List<Comment> comments = new ArrayList<>();

    public void increaseView() {
        this.views++;
    }

    public Post(final String title, final String content, final User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
