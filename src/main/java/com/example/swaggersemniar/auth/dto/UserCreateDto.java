package com.example.swaggersemniar.auth.dto;

import com.example.swaggersemniar.auth.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserCreateDto {
	@Getter
	@AllArgsConstructor
	@Schema(name = "UserCreateDto.Request", description = "사용자 생성 요청 DTO")
	public static class Request {
		@Schema(description = "사용자 아이디", example = "test")
		private String username;
		@Schema(description = "사용자 이름", example = "테스터")
		private String name;
		@Schema(description = "비밀번호", example = "password")
		private String password;
		@Schema(description = "휴대폰 번호", example = "010-1234-5678")
		private String phone;

		public User toEntity() {
			return User.builder()
					.username(username)
					.name(name)
					.password(password)
					.phone(phone)
					.build();
		}
	}

	@Getter
	@AllArgsConstructor
	public static class Response {
		private Long id;

		public static Response of(User user) {
			return new Response(user.getId());
		}
	}
}
