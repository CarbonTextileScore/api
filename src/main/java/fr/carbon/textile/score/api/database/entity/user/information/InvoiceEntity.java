package fr.carbon.textile.score.api.database.entity.user.information;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "Invoice")
@Table(name = "`Invoice`", schema = "`UserInformation`", catalog = "postgres")
public class InvoiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Date`", nullable = false)
    private Timestamp _date;
    @Basic
    @Column(name = "`Quota`", nullable = false)
    private int _quota;
    @ManyToOne
    @JoinColumn(name = "`UserId`", nullable = false)
    private UserEntity _user;

    public InvoiceEntity() {
    }

    public InvoiceEntity(Timestamp date, int quota, UserEntity user) {
        _date = date;
        _quota = quota;
        _user = user;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public Timestamp getDate() {
        return _date;
    }

    public void setDate(Timestamp date) {
        _date = date;
    }

    public int getQuota() {
        return _quota;
    }

    public void setQuota(int quota) {
        _quota = quota;
    }

    public UserEntity getUser() {
        return _user;
    }

    public void setUser(UserEntity userId) {
        _user = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return Objects.equals(_id, that._id) &&
                _quota == that._quota &&
                Objects.equals(_date, that._date) &&
                Objects.equals(_user, that._user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _date, _quota, _user);
    }
}
