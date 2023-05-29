package kr.megaptera.assignment.dtos;

import java.util.List;

public record LineItemsListDto(
    List<LineItemDto> lineItems
) {

}
