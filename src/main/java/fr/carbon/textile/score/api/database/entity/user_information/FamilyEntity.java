package fr.carbon.textile.score.api.database.entity.user_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Family")
@Table(name = "`Family`", schema = "`UserInformation`", catalog = "postgres")
public class FamilyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int _id;
    @Basic
    @Column(name = "`Address`", nullable = false)
    private String _address;

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

    public FamilyEntity() {
    }

    public FamilyEntity(String address) {
        _address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyEntity that = (FamilyEntity) o;
        return _id == that._id && Objects.equals(_address, that._address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _address);
    }
}
