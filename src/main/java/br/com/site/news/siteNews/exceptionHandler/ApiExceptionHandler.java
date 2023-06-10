package br.com.site.news.siteNews.exceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.site.news.siteNews.model.MesageModel;




// Tratar exceções
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MesageModel mg = new MesageModel();
    private Map<String, String> listErrors = new HashMap<>();

    protected  org.springframework.http.ResponseEntity<java.lang.Object> handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers, org.springframework.http.HttpStatusCode status, org.springframework.web.context.request.WebRequest request) {
     
        // Limpar as mensagem antes evinvar os erros para o front
        listErrors.clear();
        
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String fildName = ((FieldError) error).getField();
            String errorMassage = error.getDefaultMessage();
            
            listErrors.put(fildName, errorMassage);
        }
          
        
        mg.setErrors(listErrors);
        return handleExceptionInternal(ex, mg, headers, status, request);
      }
    
}
