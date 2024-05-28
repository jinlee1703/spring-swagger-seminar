package com.example.swaggersemniar.auth.dto;

import com.example.swaggersemniar.auth.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserReadDto {
	@Getter
	@AllArgsConstructor
	@Schema(name = "UserReadDto.Request", description = "사용자 조회 요청 DTO")
	public static class Response {
		@Schema(description = "사용자 아이디", example = "test")
		private Long id;
		@Schema(description = "사용자 이름", example = "테스터")
		private String username;
		@Schema(description = "이름", example = "사용자")
		private String name;
		@Schema(description = "휴대폰 번호", example = "010-1234-5678")
		private String phone;

		public static Response of(User user) {
			return new Response(user.getId(), user.getUsername(), user.getName(), user.getPhone());
		}
	}
}
