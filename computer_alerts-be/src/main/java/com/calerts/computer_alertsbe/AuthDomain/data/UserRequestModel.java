package com.calerts.computer_alertsbe.AuthDomain.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestModel {
   private String username;
   private String password;
}
