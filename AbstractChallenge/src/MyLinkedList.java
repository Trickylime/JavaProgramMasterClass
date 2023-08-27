import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot() {
        return root;
    }

    public boolean addItem(ListItem list){

        return true;
    }

    public boolean removeItem(ListItem list){

        return true;
    }

    public void traverse(ListItem list){
        list = this.root;

    }



    @Override
    public Node item(int index) {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
