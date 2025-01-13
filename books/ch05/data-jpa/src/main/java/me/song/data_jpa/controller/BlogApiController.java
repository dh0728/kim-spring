package me.song.data_jpa.controller;

import me.song.data_jpa.dto.AddArticleRequest;
import lombok.RequiredArgsConstructor;
import me.song.data_jpa.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import me.song.data_jpa.service.BlogService;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 Json 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    //HTTP 메서드가 POST일 떄 전달받는 URL과 동일하면 메서드로 메핑
    @PostMapping("/api/articles")
    // @RequestBody로 요청 본문 값 매칭
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
