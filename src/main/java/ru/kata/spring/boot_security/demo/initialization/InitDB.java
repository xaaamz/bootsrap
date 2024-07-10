package ru.kata.spring.boot_security.demo.initialization;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class InitDB {

    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public InitDB(RoleService roleService, UserService userService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void fillDb() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        User admin = new User("qwer@qwer.qwer", "firsName1", "lastName1", 34, passwordEncoder.encode("qwer"));
        admin.addRole(roleService.add(roleAdmin));
        userService.add(admin);

        User user = new User("asdf@asdf.asdf", "firsName2", "lustName2", 23, passwordEncoder.encode("asdf"));
        user.addRole(roleService.add(roleUser));
        userService.add(user);

        User userAdmin = new User("zxcv@zxcv.zxcv", "firsName3", "lustName3", 45, passwordEncoder.encode("zxcv"));
        userAdmin.addRole(roleService.add(roleUser));
        userAdmin.addRole(roleService.add(roleAdmin));
        userService.add(userAdmin);
    }
}
