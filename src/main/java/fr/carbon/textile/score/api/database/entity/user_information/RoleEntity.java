package fr.carbon.textile.score.api.database.entity.user_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Role")
@Table(name = "`Role`", schema = "`UserInformation`", catalog = "postgres")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false, unique = true)
    private String _name;

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        _name = name;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(_id, that._id) && Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name);
    }
}
