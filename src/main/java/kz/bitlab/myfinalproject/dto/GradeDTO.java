package kz.bitlab.myfinalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {

    private Long id;
    private UserDTO user;
    private SubjectDTO subject;
    private double rk1;
    private double rk2;
    private double exam;

}
