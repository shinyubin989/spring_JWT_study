package CandiFormation_Spring.SolutionChallenge.article;


import CandiFormation_Spring.SolutionChallenge.articleLike.ArticleLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity //데이터베이스의 테이블과 1:1 매핑되는 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
public class Article {

  @Id
  @Column(nullable = false, name = "article_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private String post_time;

  @Column(nullable = false)
  private String news_agency;

  @Column(nullable = false)
  private int like_num = 0;

  @Column(nullable = false)
  private int comment_num = 0;
}
