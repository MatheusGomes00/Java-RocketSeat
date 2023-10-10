package br.com.danieleleao.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modificadores:
 * public
 * private
 * protected
 */ 

@RestController
@RequestMapping("/users")
public class UserController {  // o nome da classe tem que ser igual ao nome do arquivo...
    
    @Autowired
    private IUserRepository userRepository;
    /**
     * tipos de modificadores
     * String (texto)
     * Integer (int)
     * Double (double) numeros 0.0000
     * Float (float) numeros 0.000
     * char (A, b, C) caracteres
     * Date (data)
     * Void não tem retorno, apenas uma lógica é executada dentro do método
     */

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername());
        
        if(user != null){
            // mensagem de erro
            // status code... se foi sucesso ou erro na operação
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }
        
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
