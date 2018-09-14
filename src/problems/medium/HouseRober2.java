package problems.medium;

/**
 * Created by rajat on 15/08/18.
 */
public class HouseRober2 {

  public int rob(int[] nums) {

    int totalHouses = nums.length;
    if(totalHouses == 0) {
      return 0;
    }

    if(totalHouses == 1) {
      return nums[0];

    }

    int maxUptilPrevHouseIncludingFirst = nums[0];
    int excludingPrevHouseIncludingFirst = 0;

    int maxUptilPrevHouseExcludingFirst = nums[1];
    int excludingPrevHouseExcludingFirst = 0;


    for(int i=2;i<totalHouses;i++) {
      int excludingThisHouse = maxUptilPrevHouseExcludingFirst;
      int includeThisHouse = excludingPrevHouseExcludingFirst + nums[i];
      maxUptilPrevHouseExcludingFirst = Math.max(includeThisHouse,excludingThisHouse);
      excludingPrevHouseExcludingFirst = excludingThisHouse;
    }

    for(int i=1;i<totalHouses-1;i++) {
      int excludingThisHouse = maxUptilPrevHouseIncludingFirst;
      int includeThisHouse = excludingPrevHouseIncludingFirst + nums[i];
      maxUptilPrevHouseIncludingFirst = Math.max(includeThisHouse,excludingThisHouse);
      excludingPrevHouseIncludingFirst = excludingThisHouse;
    }

    return Math.max(maxUptilPrevHouseIncludingFirst,maxUptilPrevHouseExcludingFirst);
  }

}
