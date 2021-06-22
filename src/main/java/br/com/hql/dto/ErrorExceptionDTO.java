package br.com.hql.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorExceptionDTO {
    private String msg;
}
