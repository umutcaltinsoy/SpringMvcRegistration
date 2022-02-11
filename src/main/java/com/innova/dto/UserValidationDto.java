package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class UserValidationDto {

    @NotEmpty(message = "Please enter your First Name.")
    //@NotNull(message ="Please enter your First Name")
    private String userName;

    @NotEmpty(message = "Please enter your Last Name.")
    //@NotNull(message = "Please enter your Last Name")
    private String userSurname;

    @NotEmpty(message = "Please enter your e-mail address.")
    //@NotNull
    @Email(message = "Please enter your e-mail address in the appropriate format.")
    private String emailAddress;

    @NotEmpty(message = "Please enter your password.")
    //@NotNull(message = "Please enter your password")
    private String userPassword;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
