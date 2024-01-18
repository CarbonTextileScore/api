package fr.carbon.textile.score.api.database.entity.user.information;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "Family")
@Table(name = "`Family`", schema = "`UserInformation`", catalog = "postgres")
public class FamilyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Address`", nullable = false)
    private String _address;
    @OneToMany(mappedBy = "_family")
    private List<UserEntity> _users;

    public FamilyEntity() {
    }

    public FamilyEntity(String address, List<UserEntity> users) {
        _address = address;
        _users = users;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public List<UserEntity> getUsers() {
        return _users;
    }

    public void setUsers(List<UserEntity> users) {
        _users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyEntity that = (FamilyEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_address, that._address) &&
                Objects.equals(_users, that._users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _address, _users);
    }
}
