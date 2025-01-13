package me.song.data_jpa.service;

import me.song.data_jpa.dto.AddArticleRequest;
import lombok.RequiredArgsConstructor;
import me.song.data_jpa.domain.Article;
import me.song.data_jpa.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙는 필드의 생성자 추가
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
