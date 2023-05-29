package kr.megaptera.assignment.dtos;

public record LineItemDto(
    String id,
    String productName,
    Long quantity,
    Long totalPrice,
    Long unitPrice
) {

}
