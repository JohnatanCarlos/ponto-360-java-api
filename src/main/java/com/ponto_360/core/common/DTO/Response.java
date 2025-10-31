package com.ponto_360.core.common.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude( JsonInclude.Include.NON_NULL )
public class Response< T > {

    private T body;
    private Integer recordsCount;
    //    private List< ErrorResponse > errors;
    private String traceId;

    public Response( T body ) {
        this( body, null, null );
    }

    public Response( T body, Integer recordsCount ) {
        this( body, recordsCount, null );
    }

//    public Response( List<ErrorResponse> errors){
//        this(errors,null);
//    }

//    public Response( List< ErrorResponse > errors, String traceId ) {
//        this( null, null, errors ,traceId);
//    }
//
//    public Response( ErrorResponse error ) {
//        this( error,null);
//    }
//
//    public Response( ErrorResponse error, String traceId ) {
//        this( null, null, Collections.singletonList(error),traceId);
//    }

    protected Response( T body, Integer recordsCount, String traceId ) {
        this.body = body;
        this.recordsCount = recordsCount;
        this.traceId = traceId;
    }
}
