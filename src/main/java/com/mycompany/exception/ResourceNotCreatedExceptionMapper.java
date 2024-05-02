/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exception;

/**
 *
 * @author Hashirhalaldeen
 */

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ResourceNotCreatedExceptionMapper implements ExceptionMapper<ResourceNotCreatedException>{
     private static final Logger LOGGER = LoggerFactory.getLogger(ResourceNotFoundExceptionMapper.class);
    @Override
    public Response toResponse(ResourceNotCreatedException exception) {
         LOGGER.error("ResourceNotCreatedException caught: {}",
exception.getMessage(), exception);
        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                       .entity(  exception.getMessage())
                       .build();
    }
}