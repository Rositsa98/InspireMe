package com.art.me.inspire.store.jpa;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "author",
        uniqueConstraints =
        @UniqueConstraint(
                name = DbConstants.UK_AUTHOR_NAME,
                columnNames = {"id", "name"}))
@Access(AccessType.FIELD)
public class AuthorEntity {

    @Id
    @Column(columnDefinition = "uuid")
    protected UUID id;

    @Length(min = 1)
    @Column(nullable = false)
    protected String name;

    @Column
    protected String period;

    public AuthorEntity() {
    }

    public AuthorEntity(UUID id, String name, String period) {
        this.id = id;
        this.name = name;
        this.period = period;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
