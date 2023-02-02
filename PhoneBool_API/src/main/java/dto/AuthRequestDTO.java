package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// {
//         "username": "string",
//         "password": "l|;>>x#CrLb-[9<M-#5Hr$JDqDG!0~U3ed%+Z)i8fvySp06AQ26>>:`(0!nd`>ZWrZ#fUgt|H"
//         }
@Setter
@Getter
@Builder
@ToString

public class AuthRequestDTO {
     String username;
     String password;
}

