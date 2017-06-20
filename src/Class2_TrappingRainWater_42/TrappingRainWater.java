package Class2_TrappingRainWater_42;

/**
 * Created by junjin on 6/17/17.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[right];

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
