package com.example.swaggersemniar.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swaggersemniar.auth.dto.UserCreateDto;
import com.example.swaggersemniar.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserCreateDto.Request dto) {
		return ResponseEntity.ok(userService.create(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		return ResponseEntity.ok(userService.read(id));
	}
}
