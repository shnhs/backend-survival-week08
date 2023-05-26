package kr.megaptera.assignment.models;

import java.util.Objects;

public abstract class EntityId {
  private String value;

  public EntityId() {
  }

  public EntityId(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityId entityId = (EntityId) o;
    return Objects.equals(value, entityId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
