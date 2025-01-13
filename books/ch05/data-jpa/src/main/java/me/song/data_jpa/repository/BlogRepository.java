package me.song.data_jpa.repository;

import me.song.data_jpa.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
