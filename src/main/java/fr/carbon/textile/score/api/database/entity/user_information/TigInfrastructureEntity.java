package fr.carbon.textile.score.api.database.entity.user_information;

import jakarta.persistence.*;

@Entity
@Table(name = "TIGInfrastructure", schema = "UserInformation", catalog = "postgres")
public class TigInfrastructureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "CityId", nullable = false)
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TigInfrastructureEntity that = (TigInfrastructureEntity) o;

        if (id != that.id) return false;
        if (cityId != that.cityId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + cityId;
        return result;
    }
}
