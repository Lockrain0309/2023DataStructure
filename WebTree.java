import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
    public WebNode root;

    // 存入 WebPage 物件
    public WebTree(WebPage rootPage) {
        this.root = new WebNode(rootPage);
    }
 
    public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException {
        setPostOrderScore(root, keywords);
    }

    private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException {
        for (WebNode w : startNode.children) {
            setPostOrderScore(w, keywords);
        }
        startNode.setNodeScore(keywords);
    }

    public double eulerPrintTree() {
        return eulerPrintTree(root);
    }

    //計算tree的totalScore
    private double eulerPrintTree(WebNode startNode) {
        double totalScore = startNode.nodeScore;

        for (WebNode w : startNode.children) {
            totalScore += eulerPrintTree(w);
        }

        return totalScore;
    }

    
}
