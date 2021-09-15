package com.jm.wikigames.userservice.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameRole;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<UserModel> users;

    @Override
    public String getAuthority() {
        return this.nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return Objects.equals(getId(), roleModel.getId()) && Objects.equals(getNameRole(), roleModel.getNameRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameRole());
    }
}
