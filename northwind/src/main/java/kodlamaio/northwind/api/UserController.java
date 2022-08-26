package kodlamaio.northwind.api;


import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.core.utilities.results.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<?> add(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userService.add(user));
    }


    @GetMapping("/getUser")
    public ResponseEntity<DataResult<User>> findByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {

            validationErrors.put(error.getField(),error.getDefaultMessage());
        }
        ErrorDataResult<Object> errors=new ErrorDataResult<Object>("Dogrulama Hatalari",validationErrors);
        return errors;
    }


}
