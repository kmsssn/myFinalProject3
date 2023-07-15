package kz.bitlab.myfinalproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="courses")
@Getter
@Setter
public class Course extends BaseModel{

        @Column(name = "course_num")
        private int courseNum;

}