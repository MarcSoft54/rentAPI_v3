package com.marcdev.rent_v3;

import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.modelDTO.*;
import com.marcdev.rent_v3.services.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class RentV3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RentV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		UserService userService = new UserService();
//		ArticleService articleService = new ArticleService();
//		CommentService commentService = new CommentService();
//		RankingService rankingService = new RankingService();
//		SubscribeService subscribeService = new SubscribeService();
//		MessageService messageService = new MessageService();
//
//
//		MessageDto message = new MessageDto(
//				"hello world",
//				Timestamp.valueOf(LocalDateTime.now())
//		);
//
//		SubscribeDto subscribe = new SubscribeDto(
//				21L
//		);
//
//		RankingDto ranking = new RankingDto(
//				1L,
//				0L
//		);
//
//		UserDto user = new UserDto(
//				"marc",
//				"dev",
//				"marcdev@dev.com",
//				"marc",
//				"male",
//				657284175,
//				"Cameroun"
//		);
//
//		ArticleDto article = new ArticleDto(
//				"Classique",
//				"Cameroun",
//				28000,
//				"bafoussam",
//				"http://localhost:200/marcDev",
//				"http://localhost:200/pictureUrl",
//				"http://localhost:200/videoUrl",
//				"Home that's not fare from the roote",
//				2,
//				4,
//				1,
//				5,
//				1
//		);
//
//		CommentDto comment = new CommentDto(
//				"marc dev"
//		);
//
//		Long id = 1L;
//
//		userService.createUser(user);
//		articleService.createArticle(article);
//		commentService.createComment(comment, id);
//		rankingService.createLikeAndDislike(id,ranking);
//		messageService.createMessage(message, id);
//		subscribeService.createSubscribe(id, 0L);
	}
}
