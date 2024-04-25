package kz.myfinalproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="faculties")
@Getter
@Setter
public class Faculty extends BaseModel{

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Subject> subjects;


}