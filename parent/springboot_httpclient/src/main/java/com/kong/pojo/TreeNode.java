package com.kong.pojo;/**
 * Created by xuebi on 2019/8/15.
 */

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author xuebi
 * @Date 2019/8/15 17:48
 * @Version 1.0
 */
@Data
@Builder
public class TreeNode {
    private String nodeName;
    private String nodeCode;
    private List<TreeNode> children;

}
