package com.marcdev.rent_v3;

import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.modelDTO.*;
import com.marcdev.rent_v3.services.service.*;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "rentAPI",
				description = "RentApi is the API built by MARC DEV and use for an application name RentApp ",
				version = "1.0",
				termsOfService = "mgsoft",
				contact = @Contact(
						name = "Marc William",
						url = "http://marcdev.com",
						email = "marcwilliam756@gmail.com"
				),
				license = @License(
						name = "license",
						url = "openMarcdev.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "\n\n\nmade by Marc William",
				url = "http:#"
		)

)
public class RentV3Application implements CommandLineRunner {
	@Autowired
	UserService userService;
	@Autowired
	RankingService rankingService;
	@Autowired
	ArticleService articleService;
	@Autowired
	SubscribeService subscribeService;
	@Autowired
	MessageService messageService;
	@Autowired
	CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(RentV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		MessageDto message = new MessageDto(
				"hello world"
		);

		SubscribeDto subscribe = new SubscribeDto(
				21L
		);

		RankingDto ranking = new RankingDto(
				1L,
				0L
		);

		UserDto user = new UserDto(
				"marc",
				"dev",
				"marcdev@dev.com",
				"marc",
				"male",
				657284175,
				"Cameroun"
		);

		ArticleDto article = new ArticleDto(
				"Classique",
				"Cameroun",
				28000,
				"bafoussam",
				"http://localhost:200/marcDev",
				"http://localhost:200/pictureUrl",
				"http://localhost:200/videoUrl",
				"Home that's not fare from the root",
				2,
				4,
				1,
				5,
				1
		);

		CommentDto comment = new CommentDto(
				"marc dev"
		);

		Long id = 1L;

		userService.createUser(user);
		articleService.createArticle(article, id);
		commentService.createComment(comment, id);
		rankingService.createLikeAndDislike(id,ranking);
		messageService.createMessage(message, id);
		subscribeService.createSubscribe(id, 0L);
	}
}
