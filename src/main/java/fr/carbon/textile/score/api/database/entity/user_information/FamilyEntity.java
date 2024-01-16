package fr.carbon.textile.score.api.database.entity.user_information;

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
    private List<UserToFamilyEntity> _userToFamily;

    public FamilyEntity() {
    }

    public FamilyEntity(String address, List<UserToFamilyEntity> userToFamily) {
        _address = address;
        _userToFamily = userToFamily;
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

    public List<UserToFamilyEntity> getUserToFamily() {
        return _userToFamily;
    }

    public void setUserToFamily(List<UserToFamilyEntity> userToFamily) {
        _userToFamily = userToFamily;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyEntity that = (FamilyEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_address, that._address) &&
                Objects.equals(_userToFamily, that._userToFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _address, _userToFamily);
    }
}
