package com.davivienda.kata.service;

import com.davivienda.kata.dto.*;

public interface IAuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
