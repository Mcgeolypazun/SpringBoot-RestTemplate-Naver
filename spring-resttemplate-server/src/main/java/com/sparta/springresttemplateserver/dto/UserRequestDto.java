package com.sparta.springresttemplateserver.dto;

import com.sparta.springresttemplateserver.entity.Item;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String username;
    private String password;
}
