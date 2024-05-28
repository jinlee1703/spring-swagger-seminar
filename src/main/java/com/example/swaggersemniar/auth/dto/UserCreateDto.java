package com.example.swaggersemniar.auth.dto;

import com.example.swaggersemniar.auth.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserCreateDto {
	@Getter
	@AllArgsConstructor
	public static class Request {
		private String username;
		private String name;
		private String password;
		private String phone;

		public User toEntity() {
			System.out.println("UserCreateDto.Request.toEntity");
			System.out.println("username: " + username);
			System.out.println("name: " + name);
			System.out.println("password: " + password);
			System.out.println("phone: " + phone);
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

		Response of(User user) {
			return new Response(user.getId());
		}
	}
}
