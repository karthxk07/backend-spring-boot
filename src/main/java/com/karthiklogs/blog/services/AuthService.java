package com.karthiklogs.blog.services;


import com.karthiklogs.blog.payloads.LoginDto;
import com.karthiklogs.blog.payloads.RegisterDto;

public interface AuthService {

    String Login (LoginDto loginDto);
    String Register (RegisterDto registerDto);

}
