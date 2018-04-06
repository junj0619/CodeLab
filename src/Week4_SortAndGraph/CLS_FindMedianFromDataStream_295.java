class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (min.size() == 0 || max.size() == 0) {
                if (min.size() == 0 && max.size() == 0) 
                    max.offer(num);
                else if (min.size() == 0)
                    min.offer(num);
                else 
                    max.offer(num);

                if (min.size() == max.size() && min.size() == 1) 
                {
                    if (max.peek() > min.peek()) {
                        min.offer(max.poll());
                        max.offer(min.poll());
                    }                  
                }
            return;
        }
            
        
                    
        if (num <= max.peek())
            max.offer(num);
        else 
            min.offer(num);    
                
        if (min.size() - max.size() > 1) 
            max.offer(min.poll());
        if (max.size() - min.size() > 1)
            min.offer(max.poll());
    }
    
    public double findMedian() {
        if (max.size() > min.size()) 
            return (double)max.peek();
        else if (min.size() > max.size())
            return (double)min.peek();
        else 
            return (double)(max.peek() + min.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
