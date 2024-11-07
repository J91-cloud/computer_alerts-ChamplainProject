package com.calerts.computer_alertsbe.AuthDomain.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private String username;
    private List<String> roles;
}
