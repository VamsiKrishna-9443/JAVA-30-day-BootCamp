import java.util.Arrays;

public class TwoSumTwoPointer {

    public static int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,11,7, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}