package com.jm.wikigames.socialservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Social {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long count;
    @NonNull
    private Long gameItemId;

    public void increment(){
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Social social = (Social) o;
        return Objects.equals(getId(), social.getId()) && getGameItemId().equals(social.getGameItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGameItemId());
    }
}
