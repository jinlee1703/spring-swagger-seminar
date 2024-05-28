package com.example.swaggersemniar.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swaggersemniar.auth.dto.UserCreateDto;
import com.example.swaggersemniar.auth.dto.UserUpdateDto;
import com.example.swaggersemniar.auth.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "[사용자 관련 API]", description = "사용자 관련 CRUD API")
public class UserController {
	private final UserService userService;

	@Operation(summary = "사용자 생성", description = "사용자를 생성합니다.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "사용자 생성 성공"),
			@ApiResponse(responseCode = "400", description = "사용자 생성 실패")
	})
	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserCreateDto.Request dto) {
		return ResponseEntity.ok(userService.create(dto));
	}

	@Operation(summary = "사용자 조회", description = "사용자를 조회합니다.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "사용자 조회 성공"),
			@ApiResponse(responseCode = "400", description = "사용자 조회 실패")
	})
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		return ResponseEntity.ok(userService.read(id));
	}

	@Operation(summary = "사용자 수정", description = "사용자를 수정합니다.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "사용자 수정 성공"),
			@ApiResponse(responseCode = "400", description = "사용자 수정 실패")
	})
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserUpdateDto.Request dto) {
		return ResponseEntity.ok(userService.update(id, dto));
	}

	@Operation(summary = "사용자 삭제", description = "사용자를 삭제합니다.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "사용자 삭제 성공"),
			@ApiResponse(responseCode = "400", description = "사용자 삭제 실패")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}
}
