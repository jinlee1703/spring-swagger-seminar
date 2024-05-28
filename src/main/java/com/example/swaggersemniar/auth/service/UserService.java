package com.example.swaggersemniar.auth.service;

import org.springframework.stereotype.Service;

import com.example.swaggersemniar.auth.dto.UserCreateDto;
import com.example.swaggersemniar.auth.dto.UserReadDto;
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
}
