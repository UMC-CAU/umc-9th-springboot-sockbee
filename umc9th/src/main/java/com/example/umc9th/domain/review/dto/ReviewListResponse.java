package com.example.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReviewListResponse {

    private final int page;
    private final int size;
    private final long totalElements;
    private final int totalPages;
    private final List<ReviewResponseDTO> reviews;
}

