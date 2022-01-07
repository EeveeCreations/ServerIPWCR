package nl.ipwcr.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecourseNotFoundException extends Exception{
        private static final long serialVersionUID = 1L;

        public RecourseNotFoundException(String message){
            super(message);
        }
}
