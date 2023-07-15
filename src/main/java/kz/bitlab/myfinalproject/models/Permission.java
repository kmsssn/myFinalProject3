package kz.bitlab.myfinalproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="permissions")
@Getter
@Setter
public class Permission extends BaseModel implements GrantedAuthority{

    @Column(name="role")
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
