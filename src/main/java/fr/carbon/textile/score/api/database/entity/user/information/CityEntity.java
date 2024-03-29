package fr.carbon.textile.score.api.database.entity.user.information;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "City")
@Table(name = "`City`", schema = "`UserInformation`", catalog = "postgres")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @OneToOne
    @JoinColumn(name = "`CountryId`", nullable = false)
    private CountryEntity _country;

    @OneToMany(targetEntity = UserEntity.class, mappedBy = "_city")
    List<UserEntity> _users = new ArrayList<>();


    public CityEntity() {
    }

    public CityEntity(String name, CountryEntity country) {
        _name = name;
        _country = country;
    }

    public int getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public CountryEntity getCountry() {
        return _country;
    }

    public void setCountry(CountryEntity country) {
        _country = country;
    }

    public List<UserEntity> getUsers() {
        return _users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_country, that._country) &&
                Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _country);
    }
}
