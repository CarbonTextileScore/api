package fr.carbon.textile.score.api.database.entity.quota_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "PunishmentRequirement")
@Table(name = "`PunishmentRequirement`", schema = "`QuotaInformation`", catalog = "postgres")
public class PunishmentRequirement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`MinAge`", nullable = false)
    private int _minAge;
    @Basic
    @Column(name = "`MaxAge`", nullable = false)
    private int _maxAge;

    public PunishmentRequirement() {
    }

    public PunishmentRequirement(int minAge, int maxAge) {
        this._minAge = minAge;
        this._maxAge = maxAge;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        this._id = id;
    }

    public int getMinAge() {
        return _minAge;
    }

    public void setMinAge(int minAge) {
        this._minAge = minAge;
    }

    public int getMaxAge() {
        return _maxAge;
    }

    public void setMaxAge(int maxAge) {
        this._maxAge = maxAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunishmentRequirement that = (PunishmentRequirement) o;
        return _minAge == that._minAge && _maxAge == that._maxAge && Objects.equals(_id, that._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _minAge, _maxAge);
    }
}
