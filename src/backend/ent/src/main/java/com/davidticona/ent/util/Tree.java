package com.davidticona.ent.util;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.dto.Node;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public class Tree {
    private List<AdjacentItem> items;
    
    public Tree(List<AdjacentItem> items) {
        this.items = items;
    }
    
    public List<Node> getTree() {
        return buildTree(this.items, null);
    }
    
    private List<Node> buildTree(List<AdjacentItem> elements, Integer parentId) {
        List<Node> output = new LinkedList<>();
        for (AdjacentItem item : groupByParentId(parentId)) {
            Node newNode = new Node(item.id(), item.code(), item.name());
            boolean isParent = hasChildren(item.id());
            if (isParent) {
                newNode.setChildren(buildTree(elements, item.id()));
            }
            output.add(newNode);
        }
        return output;
    }
    
    private List<AdjacentItem> groupByParentId(Integer parentId) {
        return items.stream().filter(item -> Objects.equals(item.parentId(), parentId)).toList();
    }
    
    protected boolean hasChildren(Integer itemId) {
        return items.stream().filter((AdjacentItem item) -> Objects.equals(item.parentId(), itemId)).count() > 0;
    }
}
