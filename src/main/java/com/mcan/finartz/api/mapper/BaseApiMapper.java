package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.BaseRequest;
import com.mcan.finartz.api.response.BaseResponse;
import com.mcan.finartz.service.dto.BaseDto;

import java.util.List;

public interface BaseApiMapper<T extends BaseDto, R extends BaseRequest, P extends BaseResponse> {
    List<P> dtoListToResponseList(List<T> dtoList);

    P dtoToResponse(T t);

    T requestToDto(R request);
}
