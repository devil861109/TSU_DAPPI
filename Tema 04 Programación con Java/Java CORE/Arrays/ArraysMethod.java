import java.util.Arrays;

public class ArraysMethod {
    public static void main(String[] args) {
        int[] nums = {1,5,3,10,15,0};
        int[] nums2 = {5,3,2,1};
        String[] names = {"Adam", "Kevin", "Joe", "Nora"};

        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums); //quicksort O(n * log n)
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(names));
        Arrays.sort(names); //mergesort O(n * log n)
        System.out.println(Arrays.toString(names));

        //ONCE SORTED, we can use BinarySearch

        int result = Arrays.binarySearch(nums, 100);
        System.out.println(result);

        //compare

        System.out.println(Arrays.equals(nums, nums2));

        //copy arrays

        int[] copyArray = Arrays.copyOf(nums, nums.length);
        System.out.println(Arrays.toString(copyArray));

        //anonimous array
        modify(new int[] {1,2,3,4,5});

    }

    private static void modify(int[] nums) { //REFERENCE
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = nums[i] * 10;
            System.out.println(nums[i]);
        }
    }
}
