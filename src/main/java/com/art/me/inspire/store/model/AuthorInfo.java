package com.art.me.inspire.store.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class AuthorInfo {

    public final UUID id;

    public final String name;

    public final String period;

    @JsonCreator
    public AuthorInfo(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("period") String period) {
        this.id = id;
        this.name = name;
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorInfo that = (AuthorInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, period);
    }

    @Override
    public String toString() {
        return "AuthorInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", period=" + period +
                '}';
    }
}
