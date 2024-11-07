package com.calerts.computer_alertsbe.AuthDomain.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@Generated

public class UserResponseModel {
    private String username;
    private List<String> roles;
    private String jwtToken;
}
