package fr.carbon.textile.score.api.database.entity.quota_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Retribution")
@Table(name = "`Retribution`", schema = "`QuotaInformation`", catalog = "postgres")
public class RetributionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`", nullable = false)
    private int _id;
    @Basic
    @Column(name = "`QuotaGains`", nullable = false)
    private int _quotaGains;
    @Basic
    @Column(name = "`Punishment`", nullable = false)
    private String _punishment;

    public RetributionEntity() {
    }

    public RetributionEntity(int quotaGains, String punishment) {
        this._quotaGains = quotaGains;
        this._punishment = punishment;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public int getQuotaGains() {
        return _quotaGains;
    }

    public void setQuotaGains(int quotaGains) {
        this._quotaGains = quotaGains;
    }

    public String getPunishment() {
        return _punishment;
    }

    public void setPunishment(String punishment) {
        this._punishment = punishment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetributionEntity that = (RetributionEntity) o;
        return _id == that._id && _quotaGains == that._quotaGains && Objects.equals(_punishment, that._punishment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _quotaGains, _punishment);
    }
}
