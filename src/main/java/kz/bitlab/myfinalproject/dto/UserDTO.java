package kz.bitlab.myfinalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private int courseNum;
    private String facultyName;


}
