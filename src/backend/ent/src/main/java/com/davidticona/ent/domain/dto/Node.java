package com.davidticona.ent.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Getter
@Setter
public class Node {
    private Integer id;
    private String code;
    private String name;
    private List<Node> children;
    public Node(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
