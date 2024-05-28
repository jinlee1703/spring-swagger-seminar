package com.example.swaggersemniar.auth.dto;

import com.example.swaggersemniar.auth.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserReadDto {
	@Getter
	@AllArgsConstructor
	@Schema(name = "UserReadDto.Response", description = "사용자 조회 응답 DTO")
	public static class Response {
		@Schema(description = "사용자 아이디", example = "1")
		private Long id;
		@Schema(description = "사용자 아이디", example = "test")
		private String username;
		@Schema(description = "사용자 이름", example = "테스터")
		private String name;
		@Schema(description = "전화번호", example = "010-1234-5678")
		private String phone;

		public static Response of(User user) {
			return new Response(user.getId(), user.getUsername(), user.getName(), user.getPhone());
		}
	}
}
