package fr.carbon.textile.score.api.database.entity.user.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "TIGInfrastructure")
@Table(name = "`TIGInfrastructure`", schema = "`UserInformation`", catalog = "postgres")
public class TIGInfrastructureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @OneToOne
    @JoinColumn(name = "`CityId`", nullable = false)
    private CityEntity _city;

    public TIGInfrastructureEntity() {
    }

    public TIGInfrastructureEntity(String name, CityEntity city) {
        _name = name;
        _city = city;
    }

    public Integer getId() {
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

    public CityEntity getCity() {
        return _city;
    }

    public void setCity(CityEntity cityId) {
        _city = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIGInfrastructureEntity that = (TIGInfrastructureEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_city, that._city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _city);
    }
}
