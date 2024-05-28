package com.example.swaggersemniar.auth.service;

import org.springframework.stereotype.Service;

import com.example.swaggersemniar.auth.dto.UserCreateDto;
import com.example.swaggersemniar.auth.dto.UserReadDto;
import com.example.swaggersemniar.auth.dto.UserUpdateDto;
import com.example.swaggersemniar.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public UserCreateDto.Response create(UserCreateDto.Request dto) {
		return new UserCreateDto.Response(userRepository.save(dto.toEntity()).getId());
	}

	public UserReadDto.Response read(Long id) {
		return userRepository.findById(id).map(UserReadDto.Response::of)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
	}

	public UserUpdateDto.Response update(Long id, UserUpdateDto.Request dto) {
		return userRepository.findById(id).map(user -> {
			user.update(dto);
			userRepository.save(user);
			return UserUpdateDto.Response.of(user);
		}).orElseThrow(() -> new IllegalArgumentException("User not found"));
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
