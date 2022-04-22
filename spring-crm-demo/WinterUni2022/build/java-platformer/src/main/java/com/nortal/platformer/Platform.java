package com.nortal.platformer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Platform {

    private Integer index;
    private Integer cost;

    public Platform(Integer index, Integer cost) {
        this.index = index;
        this.cost = cost;
    }
    public Platform() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "index=" + index +
                ", cost=" + cost +
                '}';
    }
}
