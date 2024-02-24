package com.davidticona.ent.util;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.dto.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public class Tree {
    private List<AdjacentItem> items;
    
    public Tree() {}

    public Tree(List<AdjacentItem> items) {
        this.items = items;
    }
    
    public void setItems(List<AdjacentItem> items) {
        this.items = items;
    }
    
    public List<TreeNode> getTree() {
        return buildTree(this.items, null);
    }
    
    public List<TreeNode> getTree(Integer parentId) {
        return buildTree(this.items, parentId);
    }
    
    private List<TreeNode> buildTree(List<AdjacentItem> elements, Integer parentId) {
        List<TreeNode> output = new LinkedList<>();
        for (AdjacentItem item : groupByParentId(parentId)) {
            TreeNode newNode = new TreeNode(item.id(), item.code(), item.name());
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
