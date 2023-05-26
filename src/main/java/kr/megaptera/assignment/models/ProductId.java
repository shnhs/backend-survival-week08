package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;


public class ProductId extends EntityId {
  
  public ProductId() {
  }

  public ProductId(String value) {
    super(value);
  }

  public static ProductId generate() {
    return new ProductId(TsidCreator.getTsid()
                                    .toString());
  }

}
