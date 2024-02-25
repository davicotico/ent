package com.davidticona.ent.util.Tree;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Getter
@Setter
public class TreeNode {
    private Integer id;
    private String code;
    private String name;
    private List<TreeNode> children;
    public TreeNode(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.children = new LinkedList<>();
    }
}
