package CandiFormation_Spring.SolutionChallenge.articleLike;

import CandiFormation_Spring.SolutionChallenge.article.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article_like")
public class ArticleLike {
  @Id
  @Column(nullable = false, name = "article_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(targetEntity = Article.class)
  private Article article;

  @Column(nullable = false)
  private String post_time;

  @Column(nullable = false)
  private String news_agency;

  @Column(nullable = false)
  private int like_num = 0;

  @Column(nullable = false)
  private int comment_num = 0;
}
