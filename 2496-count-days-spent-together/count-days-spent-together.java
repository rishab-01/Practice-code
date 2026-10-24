class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aAlice = parseDay(arriveAlice);
        int lAlice = parseDay(leaveAlice);
        int aBob = parseDay(arriveBob);
        int lBob = parseDay(leaveBob);

        int start = Math.max(aAlice, aBob);
        int end = Math.min(lAlice, lBob);

        return Math.max(0, end - start + 1);
    }

    private int parseDay(String date) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        return totalDays;
    }
}