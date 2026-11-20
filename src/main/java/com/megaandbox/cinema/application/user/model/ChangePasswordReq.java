package com.megaandbox.cinema.application.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangePasswordReq {
    private String currentPassword;
    private String newPassword;
}
