public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem next() {
        return this.rightLink;
    }

    @Override
    public ListItem setNext(ListItem rightLink) {
        return this.rightLink = rightLink;
    }

    @Override
    public ListItem previous() {
        return this.leftLink;
    }

    @Override
    public ListItem setPrevious(ListItem leftLink) {
        return this.leftLink = leftLink;
    }

    @Override
    public int compareTo(ListItem list, Object value) {

//        compareTo(), takes a ListItem and compares it to the ListItem
//        that called this method. Use value from ListItem for comparison
//        If this value is greater than the value that was passed in, then
//        it should return a number greater than zero. If vice versa,
//        then it should return a number less than zero, and zero if equal.

        return 0;

    }
}
