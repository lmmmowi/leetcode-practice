package com.lmmmowi.leetcode.p297;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Codec {

    private static final String DELIMITER = "\0";
    private static final String NULL_VALUE = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        this.doSerialize(root, values);
        return values.stream().map(i -> i == null ? NULL_VALUE : Integer.toString(i)).collect(Collectors.joining(DELIMITER));
    }

    private void doSerialize(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            this.doSerialize(root.left, list);
            this.doSerialize(root.right, list);
        } else {
            list.add(null);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> list = Stream.of(data.split(DELIMITER))
                .map(s -> NULL_VALUE.equals(s) ? null : Integer.valueOf(s))
                .collect(Collectors.toList());
        return this.doDeserialize(list);
    }

    public TreeNode doDeserialize(List<Integer> list) {
        Integer value = list.remove(0);
        if (value == null) {
            return null;
        }

        TreeNode node = new TreeNode(value);
        node.left = this.doDeserialize(list);
        node.right = this.doDeserialize(list);
        return node;
    }
}
