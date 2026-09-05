public class Q5_RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newPosition = (i + k) % nums.length;
            newArray[newPosition] = nums[i];
        }

        return newArray;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        printArray(rotateArray(nums1, 3));

        int[] nums2 = {1, 2};
        printArray(rotateArray(nums2, 3));
    }
}
