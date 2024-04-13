package io.dongvelop.springbootgraphql.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 댓글 엔티티 모델
 */
@Getter
@Entity
@ToString
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @ToString.Exclude
    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Comment(final String content, final User writer, final Post post) {
        this.content = content;
        this.writer = writer;
        setPost(post);
    }

    private void setPost(final Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}
