package fr.carbon.textile.score.api.database.entity.training.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "VideoCategory")
@Table(name = "`VideoCategory`", schema = "`TrainingInformation`", catalog = "postgres")
public class VideoCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;

    public VideoCategoryEntity() {
    }

    public VideoCategoryEntity(String name) {
        this._name = name;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCategoryEntity that = (VideoCategoryEntity) o;
        return Objects.equals(_id, that._id) && Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name);
    }
}
