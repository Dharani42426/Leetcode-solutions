class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        Arrays.sort(nums);

        for (int a = 0; a < n - 3; a++) {

            // Skip duplicate first elements
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < n - 2; b++) {

                // Skip duplicate second elements
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int left = b + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[a]
                             + nums[b]
                             + nums[left]
                             + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[a],
                            nums[b],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicates
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {

                        left++;

                    } else {

                        right--;
                    }
                }
            }
        }

        return result;
    }
}