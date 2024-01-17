package fr.carbon.textile.score.api.database.entity.user.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Country")
@Table(name = "`Country`", schema = "`UserInformation`", catalog = "postgres")
public class CountryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`Lat`", nullable = false, precision = 8)
    private double _lat;
    @Basic
    @Column(name = "`Lon`", nullable = false, precision = 8)
    private double _lon;

    public CountryEntity() {
    }

    public CountryEntity(
            String name,
            double lat,
            double lon
    ) {
        _name = name;
        _lat = lat;
        _lon = lon;
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

    public double getLat() {
        return _lat;
    }

    public void setLat(double lat) {
        _lat = lat;
    }

    public double getLon() {
        return _lon;
    }

    public void setLon(double lon) {
        _lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return Double.compare(_lat, that._lat) == 0 &&
                Double.compare(_lon, that._lon) == 0 &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _lat, _lon);
    }
}
