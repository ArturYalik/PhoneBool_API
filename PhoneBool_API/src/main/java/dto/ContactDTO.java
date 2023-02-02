package dto;
//{
//  "contacts": [
//    {
//      "id": "string",
//      "name": "string",
//      "lastName": "string",
//      "email": "string",
//      "phone": "5642709903627",
//      "address": "string",
//      "description": "string"
//    }
//  ]
//}

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString

public class ContactDTO {
    String id;
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;
}


