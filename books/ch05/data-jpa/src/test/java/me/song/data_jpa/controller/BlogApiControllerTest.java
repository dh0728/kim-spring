package me.song.data_jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.song.data_jpa.domain.Article;
import me.song.data_jpa.dto.AddArticleRequest;
import me.song.data_jpa.repository.BlogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest //테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; //직렬화 역직렬화를 위한 클래스
                                         //자바 겍치를 json 데이터로 변환하는 직렬화 또는 json 데이터를 자바에서 사용하기 위해
                                         //자바 객체로 변환하는 반직열화 할 떄 사용

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
        blogRepository.deleteAll();
    }


    @DisplayName("addArticle: 블로그 글 추가에 성공")
    @Test
    public void addArticle() throws Exception {

        //given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        // 객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        //when
        //설정한 내용을 바탕으로 요청 전송
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody)
        );

        //then
        result.andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();

        Assertions.assertThat(articles.size()).isEqualTo(1); //크기가 1인지 검증하기
        Assertions.assertThat(articles.get(0).getTitle()).isEqualTo(title);
        Assertions.assertThat(articles.get(0).getContent()).isEqualTo(content);





    }

}