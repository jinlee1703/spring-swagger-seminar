package com.example.swaggersemniar.auth.dto;

import com.example.swaggersemniar.auth.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserReadDto {
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
