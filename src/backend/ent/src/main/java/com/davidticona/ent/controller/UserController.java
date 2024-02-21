package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.dto.Node;
import com.davidticona.ent.domain.entity.User;
import com.davidticona.ent.service.UserService;
import com.davidticona.ent.util.Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


class RoleAdj {
    Integer id;
    Integer parentId;
    String code;

    public RoleAdj(Integer id, Integer parentId, String code) {
        this.id = id;
        this.parentId = parentId;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}

class RoleDto {
    Integer id;
    String code;
    List<RoleDto> children = new LinkedList<>();
    
    public RoleDto(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public List<RoleDto> getChildren() {
        return children;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setChildren(List<RoleDto> children) {
        this.children = children;
    }
    
}


/**
 *
 * @author David Tomas Ticona Saravia
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> read() {
        
        return this.userService.read();
        
    }
    
    @GetMapping("/test")
    public List<Node> test() {
        List<AdjacentItem> listaSimple = new LinkedList<>();
        listaSimple.add(new AdjacentItem(1, 0, "root", ""));
        listaSimple.add(new AdjacentItem(2, 1, "CEO", "CEO"));
        listaSimple.add(new AdjacentItem(3, 2, "Operations", "Op"));
        listaSimple.add(new AdjacentItem(4, 2, "Financial", ""));
        listaSimple.add(new AdjacentItem(5, 2, "IT", ""));
        listaSimple.add(new AdjacentItem(6, 4, "Sales", ""));
        listaSimple.add(new AdjacentItem(7, 4, "Marketing", ""));
        listaSimple.add(new AdjacentItem(8, 4, "Payroll", ""));
        listaSimple.add(new AdjacentItem(9, 5, "Network", ""));
        listaSimple.add(new AdjacentItem(10, 5, "Security", ""));
        listaSimple.add(new AdjacentItem(11, 5, "Admin", ""));
        return new Tree(listaSimple).getTree();
    }
}
