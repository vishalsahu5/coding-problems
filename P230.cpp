/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void inorder(TreeNode* root, int &k, int &ans){
        if(!root) return;
        if(ans == INT_MIN)
            inorder(root->left, k, ans);
        k--;
        if(k == 0){
            ans = root->val;
            return;
        }
        if(ans == INT_MIN)
            inorder(root->right, k, ans);
    }
    int kthSmallest(TreeNode* root, int k) {
        int ans = INT_MIN;
        inorder(root, k, ans);
        return ans;
    }
};