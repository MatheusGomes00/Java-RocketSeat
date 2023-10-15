package br.com.danieleleao.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;  // biblioteca foda com vários métodos exemplo getter e setter
// import lombok.Getter;  Somente os getters
// import lombok.Setter;  Somente os setters


@Data
@Entity(name="tb_users")  // gera uma entidade
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // @Column(name = "usuario")  altera o nome da coluna no banco

    @Column(unique = true)  // no banco de dados o username é único
    private String username;
    private String name;
    private String password;

    @CreationTimestamp  // revela quando foi feita uma alteração
    private LocalDateTime createdAt;
    
}
