public class ZigzagIterator {
    int i, j;
    List<Integer> v1, v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = 0;
        j = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int r = 0;
        if (hasNext()) {
            if (i >= v1.size()) {
                j++;
                r = v2.get(j - 1);
            } else if (j >= v2.size()) {
                i++;
                r = v1.get(i - 1);
            } else if (i == j) {
                i++;
                r = v1.get(i - 1);
            } else {
                j++;
                r = v2.get(j - 1);
            }
        }
        return r;
    }

    public boolean hasNext() {
        if (i < v1.size() || j < v2.size()) {
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
