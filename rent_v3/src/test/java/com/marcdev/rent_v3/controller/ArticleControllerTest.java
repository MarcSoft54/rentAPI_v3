package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.modelDTO.ArticleDto;
import com.marcdev.rent_v3.services.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ArticleService articleService;
    @MockBean
    UserService userService;
    @MockBean
    RankingService rankingService;
    @MockBean
    SubscribeService subscribeService;
    @MockBean
    MessageService messageService;
    @MockBean
    CommentService commentService;

//    ArticleDto article = new ArticleDto(
//            "Classique",
//            "Cameroun",
//            28000,
//            "bafoussam",
//            "http://localhost:200/marcDev",
//            "http://localhost:200/pictureUrl",
//            "http://localhost:200/videoUrl",
//            "Home that's not fare from the root",
//            5,
//            4,
//            1,
//            5,
//            1
//    );
//    ArticleDto article2 = new ArticleDto(
//            "Classique",
//            "Cameroun",
//            28000,
//            "bafoussam",
//            "http://localhost:200/marcDev",
//            "http://localhost:200/pictureUrl",
//            "http://localhost:200/videoUrl",
//            "Home that's not fare from the root",
//            1,
//            4,
//            1,
//            5,
//            1
//    );
//


//    @Test
//    void createArticles() throws Exception {
//        mvc.perform(post("/api/setArticle?articleDto="+article+"&id=1"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void delArticle() throws Exception {
//        mvc.perform(delete("/api/delArticle?articleId=0"))
//                .andExpect(status().isOk());
//    }
//
//
//    @Test
//    void updateArticle() throws Exception {
//        mvc.perform(put("/api/updateArticle?articleDto="+article2+"&id=1&userId=1"))
//                .andExpect(status().isOk());
//    }

    @Test
    void searchArticle() throws Exception{
        mvc.perform(get("/api/searchArticle?price=0"))
                .andExpect(status().isOk());
    }

    @Test
    void getArticles() throws Exception {
        mvc.perform(get("/api/getAllArticle"))
                .andExpect(status().isOk());
    }
}