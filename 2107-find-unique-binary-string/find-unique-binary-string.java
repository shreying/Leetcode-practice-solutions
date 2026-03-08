class Solution {
    String ans = "";
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        int width = nums[0].length();
        var root = new Node();
        for(var num: nums) {
            dfs(root, num, num.length() -1);
        }

        findAnswer(root, width-1, "");
        return ans;

    }
    private void findAnswer(Node node, int count, String curString) {
        if (count == -1) {
            ans = curString;
            return;
        }
        if (node.left == null) {
            var newNode = new Node();
            node.left = newNode;
            findAnswer(node.left, count-1, "0" + curString);
        }
        else if (node.right == null) {
            var newNode = new Node();
            node.right = newNode;
            findAnswer(node.right, count-1, "1" + curString);
        }
        else {
             findAnswer(node.right, count-1,  "1" + curString);
             findAnswer(node.left, count-1,  "0" + curString);
        }
    }

    private void dfs(Node node, String num, int curInd) {
        if (curInd == -1) {
            return;
        }
        if (num.charAt(curInd) == '1') { //right
            if (node.right == null) {
                node.right = new Node();
            } 
            dfs(node.right, num, curInd -1);
        }else { //left
            if (node.left == null) {
                node.left = new Node();
            } 
            dfs(node.left, num, curInd -1);
        }
    }

    class Node{
        int val;
        Node left;
        Node right;
    }
}