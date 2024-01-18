package fr.carbon.textile.score.api.database.entity.market.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "FabricAnimalOrigin")
@Table(name = "`FabricAnimalOrigin`", schema = "`MarketInformation`", catalog = "postgres")
public class FabricAnimalOriginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;

    public FabricAnimalOriginEntity() {
    }

    public FabricAnimalOriginEntity(String name) {
        _name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabricAnimalOriginEntity that = (FabricAnimalOriginEntity) o;
        return Objects.equals(_id, that._id) && Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name);
    }
}
