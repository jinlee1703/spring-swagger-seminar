package com.example.swaggersemniar.auth.dto;

import com.example.swaggersemniar.auth.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserUpdateDto {
	@Getter
	@AllArgsConstructor
	@Schema(name = "UserRequestDto.Request", description = "사용자 조회 요청 DTO")
	public static class Request {
		@Schema(description = "사용자 이름", example = "테스터")
		private String username;
		@Schema(description = "비밀번호", example = "password")
		private String password;
		@Schema(description = "이름", example = "이름")
		private String name;
		@Schema(description = "휴대폰 번호", example = "010-1234-5678")
		private String phone;

		public User toEntity() {
			return User.builder()
					.username(username)
					.password(password)
					.build();
		}
	}

	@Getter
	@AllArgsConstructor
	public static class Response {
		private Long id;
		private String username;
		private String name;
		private String phone;

		public static Response of(User user) {
			return new Response(user.getId(), user.getUsername(), user.getName(), user.getPhone());
		}
	}
}
