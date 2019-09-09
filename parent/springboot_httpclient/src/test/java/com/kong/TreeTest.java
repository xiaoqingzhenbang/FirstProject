package com.kong;/**
 * Created by xuebi on 2019/8/15.
 */

import com.kong.pojo.TreeNode;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @ClassName TreeTest
 * @Description TODO
 * @Author xuebi
 * @Date 2019/8/15 17:49
 * @Version 1.0
 */
public class TreeTest {

    private static TreeNode node0;
    private static List<String> targetNode = Lists.newArrayList("B1", "C1");

    public static void main(String[] args) {
        init();
        System.out.println(node0);
        filterNode(node0, targetNode);
        if (node0.getChildren().size() == 0) {
            node0 = null;
        }
        System.out.println(node0);

    }

    private static  void init() {
        node0 = TreeNode.builder().nodeCode("0").nodeName("A").build();
        TreeNode node1 = TreeNode.builder().nodeCode("1").nodeName("B").build();
        TreeNode node2 = TreeNode.builder().nodeCode("2").nodeName("C").build();
        TreeNode node3 = TreeNode.builder().nodeCode("3").nodeName("D").build();

        TreeNode node4 = TreeNode.builder().nodeCode("4").nodeName("B1").build();
        TreeNode node5 = TreeNode.builder().nodeCode("5").nodeName("B2").build();
        TreeNode node6 = TreeNode.builder().nodeCode("6").nodeName("C1").build();
        TreeNode node7 = TreeNode.builder().nodeCode("7").nodeName("D1").build();
        TreeNode node8 = TreeNode.builder().nodeCode("8").nodeName("D2").build();

        node1.setChildren(Lists.newArrayList(node4, node5));
        node2.setChildren(Lists.newArrayList(node6));
        node3.setChildren(Lists.newArrayList(node7, node8));

        node0.setChildren(Lists.newArrayList(node1, node2, node3));
    }

    public static List<TreeNode> filterNode(TreeNode treeNode, List<String> targetNode) {

        List<TreeNode> nodes = treeNode.getChildren();
        List<TreeNode> newNodes = Lists.newArrayList();
        List<TreeNode> tagNodes = Lists.newArrayList();

        for (TreeNode node : nodes) {
            if (targetNode.contains(node.getNodeName())) {
                newNodes.add(node);
            }
            if (node.getChildren() != null && node.getChildren().size() > 0) {
                List<TreeNode> retNodes = filterNode(node, targetNode);
                if (retNodes.size() > 0) {
                    node.setChildren(retNodes);
                } else {
                    // 没有子节点情况
                    node.setChildren(null);
                    // 标记,循环结束后删除
                    tagNodes.add(node);
                }
            }
        }
        nodes.removeAll(tagNodes);
        return newNodes;
    }

}
